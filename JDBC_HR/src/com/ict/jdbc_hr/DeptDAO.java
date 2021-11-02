package com.ict.jdbc_hr;
import java.sql.*;

import jdbc.util.DBUtil;
import java.util.*;

public class DeptDAO extends DAOBase{
	
	// C (Create) : Insert문
	/** 부서정보를 등록하는 메소드
	 * Insert/Update
	 * Delete
	 */
	public int insertDept(DeptVO vo) {
		try {
			con = DBUtil.getCon();
			// insert문 작성 => ps얻기 => execute() => 반환하기
			String sql = "insert into dept (deptno, dname, loc) values("
					+" dept_seq.nextval, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getDname());
			ps.setString(2, vo.getLoc());
			
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}//---------------------------------------------
	
	// R(Read): 조회 - select문 수행
	/*
	 *모든 부서정보를 가져오는 메소드 
	 */
	public ArrayList<DeptVO> listDept(){
		try {
			con = DBUtil.getCon();
			String sql = "SELECT DEPTNO, DNAME, LOC FROM DEPT ORDER BY DEPTNO";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<DeptVO> arr = new ArrayList<>();
			while(rs.next()) {
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				DeptVO record = new DeptVO(deptno, dname, loc);
				arr.add(record);
			}
			return arr;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	/** D : 삭제 - Delete문 수행
	 * 부서번호(PK)로 부서정보를 삭제하는 메소드 */
	public int deleteDept(int deptno) {
		try {
			con = DBUtil.getCon();
			String sql = "DELETE FROM DEPT WHERE DEPTNO = ?"; //Delete문 
			ps = con.prepareStatement(sql);
			ps.setInt(1, deptno);
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}

		
	}
}
