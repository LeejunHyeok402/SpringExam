package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BoardMemberVO;

public interface BoardService {
	//메소드 시그니처
	
	public List<BoardMemberVO> boards(Map<String,String> map);

	public int boardMemberInsert(BoardMemberVO boardMemberVO);

	public int getTotal(Map<String,String> map);

	public int idCheck(String memId);

	public int AttachInsert(List<AttachVO> list);

	public BoardMemberVO memDetail(String memId);
}
