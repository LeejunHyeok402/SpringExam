package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.service.BoardService;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.BoardMemberVO;
import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MemberController {
	
	//DI(의존성 주입), IOC(제어의 역전)
	@Inject
	MemberService memberService;
	
	//요청 파라미터 : register?userId=hongkd&passwd=1234
	@GetMapping("/register")
	public String regusterByParameter(String userId,String passwd) {
		log.info("regusterByParameter에 왔다");
		
		log.info("userId: "+userId);
		log.info("passwd: "+passwd);
		
		return "success";
	}
	
	//경로(Path) 변수(Variable)
	//요청 URI /register/hongkd
	@RequestMapping(value="/register/{userId}",method = RequestMethod.GET)
	public String registerByPath(@PathVariable String userId) {
		log.info("registerByPath에 왔다");
		
		log.info("userId: "+userId);
		
		return "success";
	}
	
	@GetMapping("/register01")
	public String register01() {
		//forwarding
		return "/register";
	}
	@PostMapping("/register01")
	public String register01Post(String userId,String password,String coin) {
		log.info("userId: "+userId);
		log.info("password: "+password);
		log.info("coin: "+coin);
		
		return "success";
	}
	
	@GetMapping("/register/register03")
	public String register03() {
		return "register/register";
	}
	// 폼필드 값이 숫자일 경우 컨트롤러 타입을 숫자형으로 작성하여 숫자형으로 받을 수있음
	@PostMapping("/register/register03")
	public String register03Post(String userId,String password,int coin) {
		log.info("userId: "+userId);
		log.info("password: "+password);
		log.info("coin: "+coin);
		
		//tiles-config.xml에서 */* 1개의 주소일 때는 안됨
		return "register/success";
	}
	
	//@PathVariable : url에서 경로 변수 값을 가져오기 위한 애너테이션
	//URL 경로 상의 경로 변수(PathVariable)가 여러개 일때
	//@PathVariable 애너테이션을 사용하여 특정한 경로 변수명을 지정
	//요청URI: /register/register03/a001/100
	@RequestMapping(value="/register/register03/{userId}/{coin}")
	public String register03ByPath(@PathVariable("userId") String userId,@PathVariable("coin") int coin) {
		log.info("register03ByPath에 왔다.");
		log.info("userId: "+userId);
		log.info("coin: "+coin);
		
		return "register/success";
	}
	@GetMapping("/register/register04")
	public String register04ByParam() {
		return "register/register04";
	}
	
	//@RequestParam 에너테이션 사용하여 HTML 폼 필드명을 지정하여 요청을 처리 할수 있음
	@PostMapping("/register/register04")
	public String register04ByParamPost(@RequestParam("userId") String id,@RequestParam("password") String pw,@RequestParam String coin) {
		log.info("id: "+id);
		log.info("pw: "+pw);
		log.info("coin: "+coin);
		
		return "register/success";
	}
	
	@GetMapping("/register/register05")
	public String register05ByBeans() {
		return "register/register05";
	}
	
	//폼 텍스트 필드 요소의 값을 자바빈즈 매개변수의 정수 타입 매개변수로 처리 됨
	//@modelAttribute 생략가능
	@PostMapping("/register/register05")
	public String register05ByBeansPost(@ModelAttribute MemberVO memberVO,int coin,ArrayList<String> cars,AddressVO addressVO,Model model) {
		log.info("memberVO: " +memberVO.toString());
//		log.info("coin: " +coin);
//		log.info("birth: " +memberVO.getBirth());
//		log.info("nationality: "+memberVO.getNationality());
//		String[] carList = memberVO.getCars();
//		log.info("cars"+cars.toString());
//		for (String car : carList) {
//			log.info("car: "+car);
//		}
		List<CardVO> cardVOList = memberVO.getCardVOList();
		log.info("처음 AddressVO: "+memberVO.toString());
		//cars -> car
		String car = StringUtils.join(memberVO.getCars(),",");
		memberVO.setCar(car);
		//hobbyList ->hobby
		String hobby = StringUtils.join(memberVO.getHobbyList(),",");
		memberVO.setHobby(hobby);
		
		int result = this.memberService.memberInsert(memberVO);
		model.addAttribute("result",result);
		log.info("나중 AddressVO: "+memberVO.toString());
		log.info("cardVO: "+cardVOList);
		return "register/success";
	}
	
	//요청 URI : /registerByGet01?userId=a001&birth=1234 (x)
	//요청 URI : /registerByGet01?userId=a001&birth=2022-10-31 (x)	
	//요청 URI : /registerByGet01?userId=a001&birth=20221031 (x)	
	//요청 URI : /registerByGet01?userId=a001&birth=2022/10/31 (o)	
	@GetMapping("/register/registerByGet01")
	public String registerByGet01(String userId,Date birth) {
		log.info("registerByGet01에 왔다.");
		
		log.info("userId: "+userId);
		log.info("birth: "+birth);
		
		return "register/success";
	}
	//요청 URI : /registerByGet02?userId=a001&birth=1234 (x)
	//요청 URI : /registerByGet02?userId=a001&birth=2022-10-31 (x)	
	//요청 URI : /registerByGet02?userId=a001&birth=20221031 (x)	
	//요청 URI : /registerByGet02?userId=a001&birth=2022/10/31 (o)	
	@GetMapping("/register/registerByGet02")
	public String registerByGet02(MemberVO memberVO) {
		log.info("registerByGet01에 왔다.");
		
		log.info("userId: "+memberVO.getUserId());
		log.info("birth: "+memberVO.getBirth());
		
		return "register/success";
	}
	
	
}
