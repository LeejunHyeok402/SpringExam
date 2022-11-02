package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BoardMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardMemberVO> boards(Map<String,String> map){
		return this.sqlSessionTemplate.selectList("board.boardMemberList",map);
	}
	
	public int boardMemberInsert(BoardMemberVO boardMemberVO) {
		return this.sqlSessionTemplate.insert("board.boardMemberInsert",boardMemberVO );
	}
	
	public int insertAttach(List<AttachVO> attachVOList) {
		log.info("dao: "+this.sqlSessionTemplate);
		return this.sqlSessionTemplate.insert("board.insertAttach", attachVOList);
	}
	
	public int getTotal(Map<String,String> map) {
		return this.sqlSessionTemplate.selectOne("board.getTotal",map);
	}
	
	public int idCheck(String memId) {
		return this.sqlSessionTemplate.selectOne("board.idCheck",memId);
	}
}
