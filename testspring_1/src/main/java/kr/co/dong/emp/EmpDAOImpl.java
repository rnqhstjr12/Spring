/*
 * DAOImpl -> mybatis를 호출
 * 1)SqlSession 사용
 * 2)@Repository 
 */
package kr.co.dong.emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class EmpDAOImpl implements EmpDAO{

	@Autowired	//인스턴스 호출
	private SqlSession sqlSession;
	
	private static final String namespace = "kr.co.dong.empMapper";
	
	@Override
	public int empCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".empCount");
	}

	@Override
	public List<EmpVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAll");
	}

	@Override
	public EmpVO detail(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(EmpVO empvo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".insert", empvo);
	}

	@Override
	public int update(EmpVO empvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
