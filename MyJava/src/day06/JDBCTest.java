package day06;
import java.sql.*;
import javax.swing.*;
/* DBMS : Oracle
 * 
 * �뿪�� : JDBC DRIVER => DBMS�翡�� �ٿ�ε� �޾Ƽ� ��ġ�ؾ���
 * 						 �츮 ��ǻ�� ���ÿ� oracle ��ġ => ��ġ�� ���� JDBC driver ����
 * 
 * ���α׷� : Java
 * ������Ʈ ��Ŭ�� => Configure Build Path > Library �� ����
 * > Classpath ���� �� > add External Jars �����Ͽ�
 * ojdbc8.jar �߰�
 */
public class JDBCTest {

	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("�ۼ��ڸ� �Է��ϼ���");
		if(name == null) return;
		
		String msg = JOptionPane.showInputDialog("�޽����� �Է��ϼ���");
		if(msg == null) return;
		
		
		// ����̹� �ε� ==> Class.forName() �޼ҵ带 �̿���
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
						// ��Ű����.Ŭ������ => ����Ŭ����̹�
		System.out.println("Driver Loading ����!");
		
		// DB�� �����ϱ� ���� �������� ����
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
				  // ��������:dbms����:����̹�Ÿ��:@ȣ��Ʈ��:��Ʈ��ȣ:����db(SID)
		String user = "c##scott";
		String pwd = "c##scott";
		
		// DB ���� => DriverManager Ŭ������ getConnection() �޼ҵ� �̿�
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB ���� ����! : con = " + con);
		
		// SQL�� �ۼ��ؼ� �ش� SQL���� �����Ű�� ���� Statement��ü ������
		Statement stmt = con.createStatement();
		
		// SQL�� �ۼ�
		/*String sql = "insert into memo(idx, name, msg, wdate)" + 
						" values(memo_sq.nextval, '���ڹ�', '�ݰ����ϴ�!', sysdate)";*/
		String sql2 = "insert into memo(idx, name, msg, wdate)" + 
				" values(memo_sq.nextval, '"+ name + "', '" + msg + "', sysdate)";
		// SQL���� �����Ű��
		// boolean execute(String sql)
		/* sql��(query��)�� �����Ű�� �޼ҵ�
		 * ��ȯ���� sql���� select���̸� true�� ��ȯ�ϰ�,
		 * select���� �ƴ� �����̸� false�� ��ȯ�Ѵ�.
		 */
		boolean b = stmt.execute(sql2);
		System.out.println("b = " + b);
		
		if(stmt != null) stmt.close();
		
		if(con != null) con.close(); //DB���� �ڿ� �ݳ� (�ſ� �߿��� �ڵ�)
		}catch(ClassNotFoundException e) {
			System.out.println("Driver�� ��ġ���� �ʾҰų� ����̹����� Ʋ�Ƚ��ϴ�.");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
