/*
 * Service는 DAO 호출을 담당
 * 1) @Service
 * 2) EmpDAO를 주입
 */

package kr.co.dong.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDAO dao;
	
	@Override
	public int empCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.empCount();
	}

	@Override
	public List<EmpVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public EmpVO detail(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.insert(empVO);
	}

	@Override
	public int update(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
