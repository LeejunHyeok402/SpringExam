package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;


/*
 	Controller 어노테이션
 	스프링 프레임워크에게 
 	이 클래스는 웹 프라우저의 요청(request)를 받아 들이는 컨트롤러라고 알려줌
 	스프링은 servlet-context.xml의 context:component-scan의 설정에 의해
 	이 클래스를 자바빈 객체로 등록(메모리에 바인딩)
 */
@Slf4j
@Controller
public class BookController {
	//도서 관리 시스템
	//BookService 서비스를 호출하기 위해 의존성 주입(DI)
	@Autowired
	BookService bookService;
	
	//요청 URI => http://localhost/create
	//Request : client가 server에 URI를 요청
	//Mapping : create(메소드를 실행)
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView create() {
		/*
		 	ModelAndView
		 	1)Model : return할 데이터 (String , ing, List,Map,vo..)를 담당
		 	2)view : 화면을 담당(뷰(view=jsp)의 경로)
		 	ViewResolver => prefix +jsp파일명 + suffix
		 */
		ModelAndView mav = new ModelAndView();
		
		
		
		/*
		 	servlet-context
		 	<beans:property name="prefix" value="/WEB-INF/views/" />
			<beans:property name="suffix" value=".jsp" />
		 */
		///WEB-INF/views/book/create.jsp
		mav.setViewName("book/create");
		return mav;
	}
	
	//URI : localhost/create
	//요청 파라미터: {"title":"개똥이","category":"소설","price":"1000"}
	//BookVO : {"bookId":0,"title":"개똥이","category":"소설","price":"1000","insertDate":""}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView createPost(ModelAndView mav,@ModelAttribute BookVO bookVO) {
		//bookVO : BookVO [bookId=0, title=개똥이, category=소설, price=10000, insertDate=null]
		log.info(bookVO.toString());
		int result = this.bookService.insert(bookVO);
		log.info("result: "+result);
		
		if(result < 1) {	//등록 실패
			// /create (get방식)URI를 재요청
			// 책 입력 화면으로 이동
			mav.setViewName("redirect:/create");
		}else {				//등록 성공
			mav.setViewName("redirect:/detail?bookId="+bookVO.getBookId());
		}
		
		return mav;
	}
	
	//책 상세보기
	//요청된URI 주소 : http://localhost/detail?bookId=1
	//URL : http://localhost/detail
	//요청(HTTP) 파라미터, 쿼리 스트링 : bookId=1
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public ModelAndView detail(ModelAndView mav,@ModelAttribute BookVO bookVO) {
		log.info("deatail에 왔다");
		log.info("bookVO: "+bookVO.toString());
		
		//select 결과 1행을 bookVO에 담을 것
		BookVO data = this.bookService.selectDetail(bookVO);
		
		//forwarding => "/WEB-INF/views/book/detail.jsp"찾아서
		//해석/컴파일하여 HTML을 응답
		//데이터(BookVO) 1행을  함께 응답
		//but, redirect는 데이터를 응답해주지 못함
		mav.setViewName("book/detail");
		mav.addObject("data", data);
		mav.addObject("bookId", data.getBookId());
		
		return mav;
	}
	
	//요청 URI => http://localhost/list
	//요청 URI => http://localhost/list?keyword=java
	//@RequestParam(value="파라미터name(keyword)",required=false(?keyword=일 때 오류방지))
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mav,@RequestParam(value="keyword",required=false) String keyword) {
		List<BookVO> list = this.bookService.list(keyword);
		//forwading
		for(BookVO bookVO:list) {
			log.info("vo:"+bookVO.toString());
		}
		mav.setViewName("book/list");
		mav.addObject("data",list);
		return mav;
	}
	
	//책 수정하기
	//요청URI => /update?bookId=1
	//요청URL => /update
	//요청 파라미터 => bookId=1
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView update(BookVO bookVO,ModelAndView mav) {
		//챡 수정 화면 = 책 입력 화면, 책 상세화면
		// 책 입력 화면 형식을 그대로 따라가고, 빈칸을 데이터로 채워주면 됨
	BookVO data = this.bookService.selectDetail(bookVO);
	
	//forwarding
	mav.addObject("data",data);
	mav.setViewName("book/update");
	
	return mav;
	}

	//책변경
	//http://localhost/update?bookId=2&title=개똥이월드2&category=소설2&price=12000
	//요청URI : http://localhost/update
	//요청 파라미터: bookId=2&title=개똥이월드2&category=소설2&price=12000
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView updatePost(ModelAndView mav,@ModelAttribute BookVO bookVO) {
		log.info("updatePost => BookVO: "+bookVO.toString());
		
		int result = this.bookService.update(bookVO);
		if(result>0) {//업데이트 성공 -> 책 상세페이지(detail.jsp)로 이동
			mav.setViewName("redirect:/detail?bookId="+bookVO.getBookId());
		}else {	//업데이트 실패 => 업데이트 뷰(update.jsp)로 페이지 이동
			mav.setViewName("redirect:/update?bookId="+bookVO.getBookId());
		}
		
		return mav;
	}
	
	//요청URI => http://localhost//delete?bookId=1
	//요청URL => http://localhost//delete
	//요청파라미터 => {"bookId":"1"}
	//스프링에서는 요청 파라미터를 매개변수로 받을 수있음
	//매개변수 타입이 int 타입으로 자동 형 변환 됨
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ModelAndView delete(ModelAndView mav, int bookId) {
		log.info("bookId : "+bookId);
		
		//해당 글 삭제
		int result = this.bookService.delete(bookId);
		if(result >0) {	//삭제 성공
			//목록으로 요청 이동
			mav.setViewName("redirect:/list");
		}else {
			//redirect => 재요청	=> 88번째 줄 메소드를 다시 실행함
			mav.setViewName("redirect:/detail?bookId="+bookId);
		}
		return mav;
	}
}
