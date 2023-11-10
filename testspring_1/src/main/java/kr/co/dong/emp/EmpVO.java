package kr.co.dong.emp;

import lombok.Data;

@Data
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private int deptno;
}
