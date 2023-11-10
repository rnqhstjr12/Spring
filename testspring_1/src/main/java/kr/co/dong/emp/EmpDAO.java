package kr.co.dong.emp;


import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public interface EmpDAO {
	//전체 사원수 조회하는 함수
	public int empCount() throws Exception;	//interface 이므로 abstract생략 가능
	
	//전체사원조회
	public List<EmpVO> listAll() throws Exception;
	
	//사원번호로 사원조회
	public EmpVO detail(int empno) throws Exception;
	
	//사원추가
	public int insert(EmpVO empvo) throws Exception;
	
	//사원수정
	public int update(EmpVO empvo) throws Exception;
	
	//사원삭제(delete -> update) 근무중 -> 이직
	
	
}
