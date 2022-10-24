package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BookVO;

//서비스 interface:비즈니스 로직
public interface BookService {
	//메소드 시그니처
	
	//Book 테이블에 insert
	public int insert(BookVO bookVO);
	
	//Book 테이블에 select
	public BookVO selectDetail(BookVO bookVO);

	//Book 테이블 전체 select
	public List<BookVO> list(String keyword);
	
	//Book 테이블에 update
	public int update(BookVO bookVO);
	
	//Book 테이블에서 delete
	int delete(int bookId);
}
