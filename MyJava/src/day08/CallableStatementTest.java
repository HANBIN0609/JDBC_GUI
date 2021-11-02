package day08;
import java.sql.*;
import jdbc.util.*;
import java.util.*;

public class CallableStatementTest {

	public static void main(String[] args) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("�ۼ��� �Է� ==> ");
		String name = sc.next();
		sc.skip("\r\n");
		System.out.println("�޽��� �Է� ==> ");
		String msg = sc.nextLine();
		System.out.println(name + " / " + msg);
		
		Connection con = DBUtil.getCon();
		// ���ν����� ȣ���Ϸ��� CallableStatement�� ���;� �Ѵ�.

		String sql = "{call memo_add(?,?)}";
		
		CallableStatement cs = con.prepareCall(sql);
		cs.setString(1, name);
		cs.setString(2, msg);
		int n = cs.executeUpdate();
		
		System.out.println(n + "���� ���ڵ带 �����߽��ϴ�.");
		
		cs.close();
		con.close();
	}

}
