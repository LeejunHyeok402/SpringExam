package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;

//매퍼xml(book_SQL.xml)을 실행시키는
//DAO(Data Access Object)클래스
//Repository 어노테이션 : 데이터에 접근하는 자바빈 객체로 스프링에 등록 해줌
//스프링에게 데이터를 관리하는 클래스라고 알려줌
@Repository
public class BookDao {
	
	//DI(Dependency Injection) : 의존성 주입
	//new 키워드를 통해 직접 생성하지 않고
	//스프링이 미리 만들어 놓은 (서버 실행 시 미리 root-context.xml을 읽어서
	//자바빈 객체로 인스턴스화 해놓음) sqlSessionTemplate 타입 객체를
	//BookDao 객체에 주입하여 사용함
	//2. IoC(Inversion of Control) : 제어의 역전
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//<insert id="insert" parameterType="kr.or.ddit.vo.BookVO">
	
	public int insert(BookVO bookVO) {
		
		//book_SQL.xml 파일의 namespace가 book이고, id가 insert인
		//태그를 찾아 그 안에 들어있는 SQL을 실행함
		//insert 성공 : 1이상, 실패면 0
		
		 
		return this.sqlSessionTemplate.insert("book.insert",bookVO);	
		}
	
	public BookVO selectDetail(BookVO bookVO) {
		//sqlSessionTemplate : 쿼리를 실행하는 객체 (root-context.xml)
		//selectOne() 메소드 : 1행을 가져올때 사용/selectList() 메소드: 결과 집합 목록 변환(다중행)
		//결과 행 수가 0이면? null 리턴
		//결과 행 수가 2이상이면 ? TooManyResultException 예외 발생
		//.selectOne("namespace.id", 파라미터)
		return this.sqlSessionTemplate.selectOne("book.select_detail", bookVO);
	}
	
	public List<BookVO> list(String keyword){
		//select 결과를 목록으로 받음. selectList("namespace.id",파라미터);
		return this.sqlSessionTemplate.selectList("book.list",keyword);
	}
	
	//책 수정하기
	//insert/update/delete의 resultType은 생략
	public int update(BookVO bookVO) {
		return this.sqlSessionTemplate.update("book.update",bookVO);
	}
	
	//책 삭제하기
	public int delete(int bookId) {
		//.delete("namespace.id",파라미터)
		return this.sqlSessionTemplate.delete("book.delete",bookId);
	}
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.sqlSessionTemplate.insert("book.insertAttach", attachVOList);
	}
}
