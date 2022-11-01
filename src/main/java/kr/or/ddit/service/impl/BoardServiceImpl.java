package kr.or.ddit.service.impl;

import java.util.List;

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
	public List<BoardMemberVO> boards(){
		return this.boardDao.boards();
	}
	
	@Override
	public int boardMemberInsert(BoardMemberVO boardMemberVO) {
		this.boardDao.boardMemberInsert(boardMemberVO);
		List<AttachVO> list = FileUploadUtil.fileUploadAction(boardMemberVO.getMemberImage(),boardMemberVO.getMemId());
		this.boardDao.insertAttach(list);
		return 0;
	}
}
