package kr.or.ddit.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BoardMemberVO;

public interface MemMepper {
	
	//글 목록
	public List<BoardMemberVO> boardMemberList(Map<String, String> map);
	
	public int boardMemberInsert(BoardMemberVO boardMemberVO); 
	
	public int insertAttach(List<AttachVO> attachVOList);
	
	public int getTotal(Map<String,String> map);
	
	public int idCheck(String memId);
	
	public BoardMemberVO memDetail(String memId);
}
