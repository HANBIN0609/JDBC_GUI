package day07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MemoUpdate {

	public static void main(String[] args) {
		try {
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
		
		// 2. DB 연결
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB 연결 성공! : con = " + con);
		
		// 3. Statement 얻어오기
		Statement stmt = con.createStatement();
		
		// 4. SQL문 작성 => 1번글의 msg를 변경 "오늘도 즐거운 하루 되세요~"(update문)
		String sql = "update memo set msg = '오늘도 즐거운 하루 되세요~' where idx = 1";

		// 5. execute() 실행시키기 => auto commit 됨
		// boolean execute(String sql) : 모든 sql문을 실행시킨다.
		// int executeUpdate(String sql) : DML문장(insert/update/delete) 실행시킨다.
		// 			: DML 문장에 의해 영향받은 레코드 수를 반환한다.
		// boolean b = stmt.execute(sql);
		int b = stmt.executeUpdate(sql);
		System.out.println("b = " + b);
		
		// 6. db연결자원 반납
		if(stmt != null) stmt.close();
		if(con != null) con.close();
		
		
		}catch(ClassNotFoundException e) {
			System.out.println("Driver가 설치되지 않았거나 드라이버명이 틀렸습니다.");
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
