package day10;
import java.sql.*;
import jdbc.util.*;
import java.util.*;
/*ResultSetMetaData Ŭ����
 * - ResultSet�� ���� ������ �˰� �ִ� Ŭ����
 * - �÷���, �÷��� �ڷ���, �ڷ��� ũ��
 * 	 ���� ��Ÿ������ �˰��� �ϸ� ResultSetMetaData�� �̿�����
 * 
 */
public class ResultSetMetaDataTest {

	public static void main(String[] args) throws Exception{
		Connection con = DBUtil.getCon();
		Scanner sc = new Scanner(System.in);
		System.out.println("SELECT���� �Է��ϼ��� => ");
		
		String sql = "";
		while((sql = sc.nextLine())!=null) {
			if(sql.equals("x")) break;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			printResultSet(rs);
			st.close();
		}
		System.out.println("bye bye");
		
		con.close();
	}

	private static void printResultSet(ResultSet rs) throws SQLException{
		// ��� ���̺� (rs)�� ���� ������ �����غ���.
		ResultSetMetaData rsmd = rs.getMetaData();
		// �÷� �� �˾Ƴ���
		int count = rsmd.getColumnCount();
		System.out.println("count : "+count);
		
		// �÷��� ���� ���� �˾Ƴ���
		for(int i = 1; i <= count; i++) {
			String colName = rsmd.getColumnName(i);
			String colType = rsmd.getColumnTypeName(i);
			int n = rsmd.isNullable(i);
			// not null => 0 ��ȯ, null ����ϸ� => 1 ��ȯ
			
			int dispSize = rsmd.getColumnDisplaySize(i);
			
			System.out.println("�÷���: "+colName+"["+colType+"]");
			System.out.println((n==0)?"NOT NULL":"NULL");
			System.out.println("�÷� display ũ��: "+dispSize);
			
			System.out.println("-------------------------");
		}
		
		
		rs.close();
	}

}
