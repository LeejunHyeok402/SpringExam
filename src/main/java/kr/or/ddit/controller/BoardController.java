package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.service.BoardService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BoardMemberVO;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;



//자바빈에 넣기
@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	/*	RequestMapping의 value속성에 요청 경로를 설정	
	 	-요청 경로는 반드시 설정해야 하는 필수 정보
	 	-속성이 하나일 때는 속성명을 생략할 수 있음(골뱅이	RequestMapping(value="/register"))
	 	-컨트롤러의 클래스 레벨과 메서드 레벨로 지정할 수 있음
	 	-클래스 레벨로 요청 경로를 지정하면 메서드 레벨에서 지정한 경로의 기본 경로로 취급됨
	 	-클래스 레벨의 요청 경로에 메서드 레벨의 요청경로를 덧붙인 형태가 최종 경로가 됨
	 */
	//value속성에 요청 경로 값을 입력
	//요청URL : http://localhost/board/register
	@RequestMapping(value="/register")
	public void registerForm() {
		log.info("registerForm");
	}
	
	//속성이 하나일 때는 속성명을 생략할 수 있음
	@RequestMapping("/modify")
	public void modifyForm() {
		log.info("modifyForm");
	}
	
	/*
	 	2.경로 패턴 매핑
	 	요청 경로를 동적으로 표현이 가능한 경로 패턴을 지정할 수 있음
	 	-URL 경로 상의 변하는 값을 경로 변수로 취급
	 	-경로 변수에 해당하는 값을 파라미터 변수에 설정할 수 있음
	 */
	//요청URI : http://localhost/board/read/100 => 100번글
	//요청URI : http://localhost/board/read/101 => 101번글
	//요청URI : http://localhost/board/read/102 => 102번글
	//요청URI :  http://localhost/board/read?boardNo=103
	@RequestMapping("/read/{boardNo}")
	public String read(@PathVariable("boardNo") int boardNo) {
		log.info("boardNo: "+boardNo);
		
		
		//뷰 이름 지정
		return "board/read";
	}
	
	@RequestMapping("/formHome")
	public String formHome() {
		//forwarding
		return "board/formHome";
	}
	
	/*	3. Http 메서드 매핑
	 	method 속성을 사용하여 Http메서드를 매핑 조건으로 지정 가능
	 	화면으로 응답하는 경우 HTTP 메서드로 Get방식과 Post방식 2가지를 사용함
	 */
//	@GetMapping("URL")
	@RequestMapping(value="/register2",method=RequestMethod.GET)
	public String register2(Model model) {
		//Model 인터페이스 => 데이터 담당
		model.addAttribute("name", "개똥이");
		
		
		//forwarding 경로 담당
		return "board/formHome";
	}
//	@PostMapping("URL")
	@RequestMapping(value="/register2",method=RequestMethod.POST)
	public String register2Post(Model model) {
		//Model 인터페이스 => 데이터 담당
		model.addAttribute("name", "메뚜기");
		
		
		//forwarding 경로 담당
		return "board/formHome";
	}
	/*	4. Param 매핑
	 * 	-요청 파라미터를 매핑 조건으로 지정하는 경우 params 속성을 사용함
	 *  -버튼이나 링크에 따라 매서드를 바꿔야 할 때 사용
	 */
	//<p><a href="/board/get?register">Register</a></p>
	@RequestMapping(value="/get",method = RequestMethod.GET,params = "register")
	public String getRegister() {
		log.info("getRegister에 왔다");
		return "board/formHome";
	}
	//<p><a href="/board/get?modify">Modify</a></p>
	@RequestMapping(value="/get",method = RequestMethod.GET,params = "modify")
	public String getModify() {
		log.info("getModify에 왔다");
		return "board/formHome";
	}
	
	/*
	 * <p>
		<form action="/board/post" method="post" />
			<button type="submit" name="register">Register</button>
		</form>
	</p>
	 */
	@RequestMapping(value="/post",method = RequestMethod.POST,params = "register")
	public String postRegister() {
		log.info("postRegister에 왔다");
		return "board/formHome";
	}
	
	/*
	 * <p>
		<form action="/board/post" method="post" />
			<button type="submit" name="register">Modify</button>
		</form>
	</p>
	 */
	@RequestMapping(value="/post",method = RequestMethod.POST,params = "modify")
	public String postModify() {
		log.info("postModify에 왔다");
		return "board/formHome";
	}
	
	/*	5.Header 매핑
	 	요청 헤더를 매핑 조건으로 지정하는경우에는 headers속성을 사용함
	 */
	@RequestMapping("/ajaxHome")
	public String ajaxHome() {
		
		log.info("ajaxHome에 왔다");
		
		return "board/ajaxHome";
	}
	
	//요청URI : http://localhost/board/7
	//@ResponseBody를 통해서 JSON데이터로 리턴
	@RequestMapping(value="/{boardNo}", method=RequestMethod.PUT)
	public ResponseEntity<String> ajaxModify(@PathVariable("boardNo") int boardNo){
		log.info("ajaxModify에 왔다");
		log.info("boardNo: "+boardNo);
		
		//success:function(result){
		//헤더에 String데이터를 넣음
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		return entity;
	}
	
	//요청 =>$.get("/board/"+boardNo,function(data){
	//요청URI => http://localhost/board/7
	@RequestMapping(value="/{boardNo}",method=RequestMethod.GET)
	public ResponseEntity<BookVO> getRead(@PathVariable("boardNo") int boardNo){
		
		log.info("boardNo: "+boardNo);
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		//vo를 응답데이터에 포함해보자
		ResponseEntity<BookVO> entity = new ResponseEntity<BookVO>(bookVO,HttpStatus.OK);
		return entity;
	}
	
	//요청URI : /board/getBook
	//data : {"boardNo":7}
	//contentType : appliction/json;charset:utf-8
	//dataType: json
	@ResponseBody
	@RequestMapping(value="/getBook",method = RequestMethod.POST)
	public List<BookVO> getBook(@RequestBody String boardNo) {
		log.info("boardNo: "+boardNo);
		//List 인터페이스를 ArrayList 클래스로 구현
		List<BookVO> bookVOList = new ArrayList<BookVO>();
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		bookVOList.add(bookVO);
		
		bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("모놀로그");
		bookVO.setCategory("음악");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		bookVOList.add(bookVO);
		
		return bookVOList;
	}
	
	/* 8.파일 업로드 폼 방식 요청처리
	  파일업로드 폼 파일 <input type="file" ... 요소(=태그)값을
	  스프링 MVC가 지원하는 MultipartFile 매개변수로 처리함
	 */
	@GetMapping("/register/register06")
	public String registerFile() {
		return "/register/register06";
	}
	
	
	@PostMapping("/board/registerFile01")
	public String registerFile01Post(MultipartFile picture) {
		log.info("registerFile01Post에  왔다.");
		log.info("오리지널 파일명: "+picture.getOriginalFilename());
		log.info("파일 크기: "+picture.getSize());
		log.info("파일 확장자: "+picture.getContentType());
		
		return "register/success";
	}
	@PostMapping("/board/registerFile02")
	public String registerFile02Post(MultipartFile picture,String userId,String password) {
		log.info("registerFile02Post에  왔다.");
		log.info("오리지널 파일명: "+picture.getOriginalFilename());
		log.info("파일 크기: "+picture.getSize());
		log.info("파일 확장자: "+picture.getContentType());
		
		log.info("userId: "+userId);
		log.info("password: "+password);
		
		return "register/success";
	}
	@PostMapping("/board/registerFile03")
	public String registerFile03Post(BoardMemberVO memVO) {
		log.info("registerFile03Post에  왔다.");
		log.info("오리지널 파일명: "+memVO.getPicture().getOriginalFilename());
		log.info("파일 크기: "+memVO.getPicture().getSize());
		log.info("파일 확장자: "+memVO.getPicture().getContentType());
		
		log.info("userId: "+memVO.getUserId());
		log.info("password: "+memVO.getPassword());
		
		return "register/success";
	}
	@PostMapping("/board/registerFile04")
	public String registerFile04Post(BoardMemberVO memVO) {
		log.info("registerFile04Post에  왔다.");
		log.info("memVO: "+memVO.toString());
		log.info("오리지널 파일명: "+memVO.getPicture().getOriginalFilename());
		log.info("파일 크기: "+memVO.getPicture().getSize());
		log.info("파일 확장자: "+memVO.getPicture().getContentType());
		log.info("오리지널 파일명: "+memVO.getPicture2().getOriginalFilename());
		log.info("파일 크기: "+memVO.getPicture2().getSize());
		log.info("파일 확장자: "+memVO.getPicture2().getContentType());
		
		log.info("userId: "+memVO.getUserId());
		log.info("password: "+memVO.getPassword());
		
		return "register/success";
	}
	
	//name[0]쓸려면 vo로 받을 것
	@PostMapping("/board/registerFile05")
	public String registerFile05PostList(List<MultipartFile> pictureList,BoardMemberVO memVO) {
		log.info("registerFile04Post에  왔다.");
		
		for (MultipartFile list : pictureList) {
			
			log.info("오리지널 파일명: "+list.getOriginalFilename());
			log.info("파일 크기: "+list.getSize());
			log.info("파일 확장자: "+list.getContentType());
			log.info("---------------------------------");
		}
		for (MultipartFile list : memVO.getPictureList()) {
			log.info("vo에서 가져온것");
			log.info("오리지널 파일명: "+list.getOriginalFilename());
			log.info("파일 크기: "+list.getSize());
			log.info("파일 확장자: "+list.getContentType());
			log.info("---------------------------------");
		}

		return "register/success";
	}
	@PostMapping("/board/registerFile06")
	public String registerFile06PostList(List<MultipartFile> pictureList,BoardMemberVO vo) {
		log.info("registerFile06Post에  왔다.");
		
		MultipartFile[] pictureArray = vo.getPictureArray();
		
		for (MultipartFile multipartFile : pictureArray) {
			log.info("오리지널 파일명: "+multipartFile.getOriginalFilename());
			log.info("파일 크기: "+multipartFile.getSize());
			log.info("파일 확장자: "+multipartFile.getContentType());
			
		}
		
		return "register/success";
	}
	
	@GetMapping("/register/register07")
	public String ajaxRegisterFile() {
		return "register/register07";
	}
	
	@RequestMapping(value="/board/uploadAjax" ,method=RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile[] file){
		String originalFileName = file[0].getOriginalFilename();
		log.info("originalName: "+originalFileName);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS_"+originalFileName,HttpStatus.OK);
		UUID uuid = UUID.randomUUID();
		List<AttachVO> list= FileUploadUtil.fileUploadAction(file, uuid.toString());
		this.boardService.AttachInsert(list);
		
		return entity;
	}
	////////////////////////////////////////////////////////////////
	
	@GetMapping("board/boards")
	public String boards(Model model,@RequestParam(defaultValue="1",required=false) int currentPage
			,@RequestParam Map<String,String> map) {
		log.info("currentPage: "+map);
		String cPage = map.get("currentPage");
		String show = map.get("show");
		String keyword = map.get("keyword");
		if(cPage==null) {
			map.put("currentPage", "1");
		}
		if(show == null || show=="") {
			map.put("show", "10");
		}
		if(keyword == null) {
			map.put("keyword", "");
		}
		List<BoardMemberVO> list = this.boardService.boards(map);
		log.info(list.toString());
		int size = Integer.parseInt(map.get("show"));
		
		
		int total = this.boardService.getTotal(map);
		//(전체 글 수, 현재페이지, 한 화면에 보여질 행 수, select 결과 list)
		model.addAttribute("data", new ArticlePage<BoardMemberVO>(total, currentPage, size, list));
		model.addAttribute("show",size);
		return "board/boards";
	}

	@GetMapping("board/insertBoard")
	public String board() {
		return "board/insert";
	}
	
	@PostMapping("board/insert")
	public String boardInsert(@ModelAttribute BoardMemberVO vo) {
		log.info("------------boardVO : "+vo.toString());
		
		this.boardService.boardMemberInsert(vo);
		
		return "redirect:/board/boards";
	}
	
	//요청 URI : board/idCheck
	//요청 파라미터: {"memId":"abc001"}
	//방식 : post
	@ResponseBody
	@PostMapping("board/idCheck")
	public Map<String,String> idCheck(@RequestBody Map<String,String> map) {
		
		int result = this.boardService.idCheck(map.get("memId"));
		log.info("memId: "+map);
	
		log.info(""+result);
		Map<String,String> mapResult = new HashMap<String, String>();
		
		if(result > 0) {
			mapResult.put("result","true");			
		}else {
			mapResult.put("result", "false");
		}
		
		return mapResult;
	}
	
	//요청 URI: /board/memdetail?memId=a001
	//요청 파라미터 : memId = a001
	@GetMapping("board/memdetail")
	public String memDetail(Model model,String memId) {
		log.info("memId: "+memId);
		BoardMemberVO vo = this.boardService.memDetail(memId);
		log.info("file: "+vo.toString());
		
		List<AttachVO> attachVOLits = vo.getAttachVOList();
		
		model.addAttribute("data",vo);
		model.addAttribute("list",attachVOLits);
		return "board/detail";
	}
}

