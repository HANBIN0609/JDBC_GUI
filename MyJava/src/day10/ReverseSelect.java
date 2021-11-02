package day10;
import java.sql.*;
import jdbc.util.*;
/**ResultSet�� Ŀ���� ����Ʈ�� forward only�μ����Ǿ� ����. rs.next()
 * ResultSetĿ���� ��������� �̵���Ű����
 * Statement�� PreparedStatement��ü�� ���� �� �ɼ��� �����ؾ� �Ѵ�.
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
		// => Ŀ���� ��������� �̵��� �� �ִ�.
		
		ResultSet rs = ps.executeQuery();
		
		//rs�� Ŀ���� ������ ���� ���Ŀ� ��ġ���Ѻ���.
		rs.afterLast(); // <=> beforeFirst()
		while(rs.previous()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			System.out.println(empno+"\t"+ename+"\t"+job);
		}
		/* rs.first() : ù��° �࿡ ��ġ
		 * rs.last() : ������ �࿡ ��ġ
		 * rs.beforeFirst() : ù��° ���� ������ ��ġ
		 * rs.absolute(int n) : Ư�� ������ �̵�
		 * 	�Ű������� ����� next(), ������ previous()
		 * rs.getRow() : ���� Ŀ���� ��ġ�� ���� ���ȣ�� ��ȯ
		 */
		rs.absolute(-2); // 2��° ������ �̵�
		System.out.println(rs.getInt(1)+"/"+rs.getString(2));
		
		con.close();
	}

}
