package day07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MemoUpdate {

	public static void main(String[] args) {
		try {
		// 1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("����̹� �ε� ����!");
		
		// 2. DB ����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB ���� ����! : con = " + con);
		
		// 3. Statement ������
		Statement stmt = con.createStatement();
		
		// 4. SQL�� �ۼ� => 1������ msg�� ���� "���õ� ��ſ� �Ϸ� �Ǽ���~"(update��)
		String sql = "update memo set msg = '���õ� ��ſ� �Ϸ� �Ǽ���~' where idx = 1";

		// 5. execute() �����Ű�� => auto commit ��
		// boolean execute(String sql) : ��� sql���� �����Ų��.
		// int executeUpdate(String sql) : DML����(insert/update/delete) �����Ų��.
		// 			: DML ���忡 ���� ������� ���ڵ� ���� ��ȯ�Ѵ�.
		// boolean b = stmt.execute(sql);
		int b = stmt.executeUpdate(sql);
		System.out.println("b = " + b);
		
		// 6. db�����ڿ� �ݳ�
		if(stmt != null) stmt.close();
		if(con != null) con.close();
		
		
		}catch(ClassNotFoundException e) {
			System.out.println("Driver�� ��ġ���� �ʾҰų� ����̹����� Ʋ�Ƚ��ϴ�.");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
