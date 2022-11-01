package kr.or.ddit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dao.MemberDao;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.vo.CardVO;
import kr.or.ddit.vo.MemberVO;

/*	메서드에 @@Transactional 에너테이션을 부여
 	회원정보를 저장하다가 실패하거나 주소정보를 저장하다가 실패하거나
 	카드정보를 저장하다가 실패하면 모두 저장이 되지 않고 rollback
 */


@Transactional
@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDao memberDao;
	
	@Override
	public int memberInsert(MemberVO memberVO) {
		int result =  this.memberDao.memberInsert(memberVO);
		
			this.memberDao.addressInsert(memberVO);
			
			List<CardVO> cardVOList = memberVO.getCardVOList();	//userId가 null
			List<CardVO> cardVOList2 = new ArrayList<CardVO>();	//userId가 채워짐
			
			for (CardVO vo : cardVOList) {
				vo.setUserId(memberVO.getUserId());
				cardVOList2.add(vo);
			}
			
			return this.memberDao.cardInsert(cardVOList2);
	}	
}
