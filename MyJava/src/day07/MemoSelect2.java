package day07;
import java.sql.*;
import javax.swing.*;

public class MemoSelect2 {

	public static void main(String[] args) 
	throws Exception
	{
		String name = JOptionPane.showInputDialog("검색할 작성자를 입력하세요");
		if(name == null) return;
		
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
		
		// 2. db연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB 연결 성공! : con = " + con);
		
		// 3. stmt얻기
		Statement stmt = con.createStatement();
		
		// 4. select문 => 검색(where절을 갖는) 
		String sql = "select idx, name, msg, wdate from memo where name = '" + name + "'";

		// 5. select문 실행 => executeQuery()
		ResultSet rs = stmt.executeQuery(sql);
		
		// 6. 반복문 돌면서 커서 이동시켜 데이터 꺼내 출력하기
		while(rs.next()) {
			int idx = rs.getInt("idx"); 
			String name1 = rs.getString("name");
			String msg = rs.getString("msg");
			java.sql.Date wdate = rs.getDate("wdate"); 
			System.out.println(idx + "\t" + name1 + "\t" + msg + "\t" + wdate);
		}
		
		// 7. db 연결자원 반납
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
