package day08;
import jdbc.util.*;
import java.sql.*;
import java.util.*;

public class PreparedStatementTest2 {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 사람의 이름을 입력 =>");
		String findName = sc.next();
		
		Connection con = DBUtil.getCon();
		
		String sql = "select empno, ename, job, sal from emp where ename = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, findName);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			int sal = rs.getInt("sal");
			
			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + sal + "\t");
		}
		
		
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(con != null) con.close();
	}

}
