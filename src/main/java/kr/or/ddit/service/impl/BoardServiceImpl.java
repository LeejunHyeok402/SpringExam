package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dao.BoardDao;
import kr.or.ddit.mapper.MemMepper;
import kr.or.ddit.service.BoardService;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BoardMemberVO;



@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	MemMepper memMapper;
	
	@Override
	public List<BoardMemberVO> boards(Map<String,String> map){
		return this.memMapper.boardMemberList(map);
	}
	
	@Transactional
	@Override
	public int boardMemberInsert(BoardMemberVO boardMemberVO) {
		//boardmember 테이블에 들어감
		this.memMapper.boardMemberInsert(boardMemberVO);
		//attach 테이블에 들어감
		List<AttachVO> list = FileUploadUtil.fileUploadAction(boardMemberVO.getMemberImage(),boardMemberVO.getMemId());
		this.memMapper.insertAttach(list);
		return 0;
	}
	
	@Override
	public int AttachInsert(List<AttachVO> list) {
		this.memMapper.insertAttach(list);
		return 0;
	}
	
	//BOARDMEMBER 테이블의 전체 행 수 구함
	@Override
	public int getTotal(Map<String,String> map) {
		return this.memMapper.getTotal(map);
	}
	//아이디 중복체크
	@Override
	public int idCheck(String memId) {
		return this.memMapper.idCheck(memId);
	}
	
	@Override
	public BoardMemberVO memDetail(String memId) {
		return this.memMapper.memDetail(memId);
	}
}
