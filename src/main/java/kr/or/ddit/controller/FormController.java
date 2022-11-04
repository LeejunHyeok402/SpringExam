package kr.or.ddit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.vo.BoardMemberVO;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/form")
@Slf4j
@Controller
public class FormController {
	//<form:form modelAttribute="member" method="post" action="register">
	@GetMapping("/registerForm01")
	public String registerForm01(Model model) {
		log.info("registerForm01에 왔다.");
		
		//<form:input path="memId"/> BoardMemberVO에 있는 멤버 변수 이름을 맞쳐줘야한다.
		//modelAttribute="member" 이름과 같아야한다
		model.addAttribute("member",new BoardMemberVO());
		
		
		
		return "form/registerForm01";
	}
	@GetMapping("/registerForm02")
	public String registerForm02(@ModelAttribute BoardMemberVO boardMemberVO) {
		log.info("registerForm02에 왔다.");

		
		return "form/registerForm02";
	}
	@GetMapping("/registerForm03")
	public String registerForm03(@ModelAttribute("boardMemberVO") BoardMemberVO boardMemberVO,Model model) {
		log.info("registerForm03에 왔다.");
		
		//폼객체에 미리 지정해서 넣을 수 있음
		boardMemberVO.setMemId("g001");
		boardMemberVO.setMemName("개똥이");
		//password는 값을 설정하여 view에 전달하더라도 password 필드에 반영이 안됨
		boardMemberVO.setPassword("1234");
		
		//체크박스
		Map<String, String> hobbyMap = new HashMap<String,String>();		
		hobbyMap.put("Sports", "Sports");
		hobbyMap.put("Music", "Music");
		hobbyMap.put("Movie", "Movie");
		
		//라디오버튼
		Map<String, String> gender = new HashMap<String,String>();
		gender.put("male", "male");
		gender.put("female", "female");
		gender.put("other", "other");
		//셀렉트 박스
		Map<String, String> nationalityMap = new HashMap<String,String>();
		nationalityMap.put("korea", "korea");
		nationalityMap.put("america", "america");
		nationalityMap.put("australia", "australia");
		
		model.addAttribute("hobbyMap",hobbyMap);
		model.addAttribute("gender",gender);
		model.addAttribute("nationalityMap",nationalityMap);
		return "form/registerForm03";
	}
	
	//요청 URI : /form/register
	//방식: post
	//파라미터: {"memId":"g001","memName":"개똥이"}
	@PostMapping("/register")
	public String registerPost(@Validated BoardMemberVO boardMemberVO,BindingResult result,Model model) {
		log.info(boardMemberVO.toString());
		
		//register03.jsp에서 post 요청시 validated 확인 후
		//문제 발생시 폼 화면으로 돌아감
		String nextPage="";
		if(result.hasErrors()) {
			nextPage= "form/registerForm03";
			return nextPage;
		}
		
		String[] hobbyList = boardMemberVO.getHobbyList();
		if(hobbyList != null) {
			for (String hobby : hobbyList) {
				log.info("hobbyList: "+hobby);
			}
		}
		
		model.addAttribute("hobbyList",hobbyList);
		nextPage = "form/success";
		return nextPage;
	}
	
}
