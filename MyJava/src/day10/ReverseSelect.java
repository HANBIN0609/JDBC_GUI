package day10;
import java.sql.*;
import jdbc.util.*;
/**ResultSet의 커서는 디폴트로 forward only로설정되어 있음. rs.next()
 * ResultSet커서를 자유자재로 이동시키려면
 * Statement나 PreparedStatement객체를 얻어올 때 옵션을 지정해야 한다.
 * */
public class ReverseSelect {

	public static void main(String[] args) throws Exception{
		Connection con = DBUtil.getCon();
		
		String sql = "SELECT empno, ename, job FROM emp ORDER BY empno ASC";
		
		//PreparedStatement ps = con.prepareStatement(sql);
		//forward_only
		PreparedStatement ps = con.prepareStatement(sql, 
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		// => 커서를 자유자재로 이동할 수 있다.
		
		ResultSet rs = ps.executeQuery();
		
		//rs의 커서를 마지막 행의 직후에 위치시켜보자.
		rs.afterLast(); // <=> beforeFirst()
		while(rs.previous()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			System.out.println(empno+"\t"+ename+"\t"+job);
		}
		/* rs.first() : 첫번째 행에 위치
		 * rs.last() : 마지막 행에 위치
		 * rs.beforeFirst() : 첫번째 행의 직전에 위치
		 * rs.absolute(int n) : 특정 행으로 이동
		 * 	매개변수가 양수면 next(), 음수면 previous()
		 * rs.getRow() : 실제 커서가 위치한 곳의 행번호를 반환
		 */
		rs.absolute(-2); // 2번째 행으로 이동
		System.out.println(rs.getInt(1)+"/"+rs.getString(2));
		
		con.close();
	}

}
