package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemberVO;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int memberInsert(MemberVO memberVO) {
		return this.sqlSessionTemplate.insert("member.memberInsert", memberVO);
	}
	
	public int addressInsert(MemberVO memberVO) {
		return this.sqlSessionTemplate.insert("member.addressInsert", memberVO);
	}
	
	public int cardInsert(List<CardVO> cardVOList) {
		return this.sqlSessionTemplate.insert("member.insertCard", cardVOList);
	}
}
