package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.BoardDao;
import kr.or.ddit.service.BoardService;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BoardMemberVO;



@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardMemberVO> boards(Map<String,String> map){
		return this.boardDao.boards(map);
	}
	
	@Override
	public int boardMemberInsert(BoardMemberVO boardMemberVO) {
		this.boardDao.boardMemberInsert(boardMemberVO);
		List<AttachVO> list = FileUploadUtil.fileUploadAction(boardMemberVO.getMemberImage(),boardMemberVO.getMemId());
		this.boardDao.insertAttach(list);
		return 0;
	}
	
	//BOARDMEMBER 테이블의 전체 행 수 구함
	@Override
	public int getTotal(Map<String,String> map) {
		return this.boardDao.getTotal(map);
	}
	@Override
	public int idCheck(String memId) {
		return this.boardDao.idCheck(memId);
	}
}
