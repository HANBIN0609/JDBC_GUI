package com.ict.jdbc_hr;

import java.sql.*;

import jdbc.util.DBUtil;
import java.util.*;

public class EmpDAO extends DAOBase{
	
	/**사원정보를 등록하는 메소드 - INSERT문
	 * - EMP_SEQ 시퀀스 생성하기
	 * - 시작값 : 8000
	 * - 증가치 : 1
	 * - INSERT문 작성하고 예외처리 하기 */
	public int insertEmp(EmpVO vo) {
		try {
			con = DBUtil.getCon();
			// insert문 작성 => ps얻기 => execute() => 반환하기
			String sql = "insert into emp (empno, ename, job, deptno, hiredate) values("
					+" emp_seq.nextval, ?, ?, ?, sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getEname());
			ps.setString(2, vo.getJob());
			ps.setInt(3, vo.getDeptno());
			
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}//---------------------------------------------
	
	/**모든 사원정보 가져오는 메소드 */
	public List<EmpVO> listEmp(){
		try {
			con = DBUtil.getCon();
			//String sql = "SELECT EMPNO, ENAME, JOB, HIREDATE, DEPTNO FROM EMP ORDER BY EMPNO"; // 사번, 사원명, 업무, 입사일, 부서번호
			String sql = "SELECT EMPNO, ENAME, JOB, HIREDATE, D.DEPTNO, DNAME"
					+ " FROM EMP E JOIN DEPT D ON E.DEPTNO = D.DEPTNO"
					+ " ORDER BY D.DEPTNO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			List<EmpVO> arr = new ArrayList<>();
			while(rs.next()) {
				int empno = rs.getInt("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				java.sql.Date hiredate = rs.getDate("HIREDATE");
				int deptno = rs.getInt("DEPTNO");
				String dname = rs.getString("DNAME");
				
				EmpVO record = new EmpVO(empno, ename, job, hiredate, dname, deptno);
				arr.add(record);
			}
			return arr;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	/**D - Delete (사번(PK)으로 사원정보 삭제처리) */
	public int deleteEmp(int empno) {
		try {
			con = DBUtil.getCon();
			String sql = "DELETE FROM EMP WHERE EMPNO = ?"; //Delete문 
			ps = con.prepareStatement(sql);
			ps.setInt(1, empno);
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
		
	}
	/**U - Update
	 *  사번으로 사원의 이름, 업무, 부서번호를 수정하는 메소드*/
	public int updateEmp(EmpVO emp) {
		try {
			con = DBUtil.getCon();
			String sql = "UPDATE emp SET ename = ?, job = ?, deptno = ("
					+ " SELECT deptno FROM dept WHERE dname = ?)"
					+ " WHERE empno = ?";
			System.out.println(emp.getEname()+", "+emp.getJob()+", "+emp.getDname());
			ps = con.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setString(3, emp.getDname());
			ps.setInt(4, emp.getEmpno());
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	
	
}////////////////////////////
