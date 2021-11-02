package day07;
import java.sql.*;
import javax.swing.*;

public class MemoSelect2 {

	public static void main(String[] args) 
	throws Exception
	{
		String name = JOptionPane.showInputDialog("�˻��� �ۼ��ڸ� �Է��ϼ���");
		if(name == null) return;
		
		// 1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����!");
		
		// 2. db����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB ���� ����! : con = " + con);
		
		// 3. stmt���
		Statement stmt = con.createStatement();
		
		// 4. select�� => �˻�(where���� ����) 
		String sql = "select idx, name, msg, wdate from memo where name = '" + name + "'";

		// 5. select�� ���� => executeQuery()
		ResultSet rs = stmt.executeQuery(sql);
		
		// 6. �ݺ��� ���鼭 Ŀ�� �̵����� ������ ���� ����ϱ�
		while(rs.next()) {
			int idx = rs.getInt("idx"); 
			String name1 = rs.getString("name");
			String msg = rs.getString("msg");
			java.sql.Date wdate = rs.getDate("wdate"); 
			System.out.println(idx + "\t" + name1 + "\t" + msg + "\t" + wdate);
		}
		
		// 7. db �����ڿ� �ݳ�
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
