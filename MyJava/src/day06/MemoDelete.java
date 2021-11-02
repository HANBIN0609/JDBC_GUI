package day06;
import java.sql.*;

import javax.swing.JOptionPane;

public class MemoDelete {

	public static void main(String[] args) 
	throws Exception
	{
		
		String name = JOptionPane.showInputDialog("삭제할 글의 작성자명을 입력하세요");
		if(name==null) return;
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
		
		// 2. DB연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB 연결 성공! : con = " + con);
		
		// 3. stmt로 얻어오기
		Statement stmt = con.createStatement();
		
		// 4. sql문 작성 => delete문 (작성자로 삭제)
		String sql = "delete from memo where name = '" + name + "'";
		
		// 5. executeUpdate()로 실행시키기
		int b = stmt.executeUpdate(sql);
		
		// 6. 몇개의 글이 삭제되었는지 출력하기
		System.out.println("삭제된 글의 갯수 : " + b);
		
		// 7. db연결자원 반납
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
