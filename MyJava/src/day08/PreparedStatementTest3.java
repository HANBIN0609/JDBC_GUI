package day08;
import jdbc.util.*;
import java.sql.*;
import java.util.*;

public class PreparedStatementTest3 {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 사원의 이름을 입력하세요(keyword)");
		String keyword = sc.next();
		System.out.println("검색 키워드: " + keyword);
		
		// 검색어에 해당하는 사원정보를 출력하되
		// 사번, 이름, 업무(job), 부서번호, 부서명
		Connection con = DBUtil.getCon();
		
		String sql = "select empno, ename, job, deptno, dname from emp join dept using (deptno) where ename like ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, "%"+keyword+"%");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			String dname = rs.getString("dname");
			int deptno = rs.getInt("deptno");
			
			System.out.println(empno + "\t" + ename + "\t" + job + "\t" + deptno + "\t" + dname);
		}
		
		
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(con != null) con.close();
	}

}
