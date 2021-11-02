package day07;
import java.sql.*;

public class MemoSelect {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공!");
		/* forName() 메소드가 해주는 것
		 * 1. OracleDriver 객체를 생성
		 * 2. DriverManager에 OracleDriver 객체를 등록한다.
		 *    DriverManager ==> 여러 개의 드라이버들을 관리한다. (Vector에 저장해서 관리함)
		 */
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##scott", pwd = "c##scott";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB 연결 성공! : con = " + con);
		
		Statement stmt = con.createStatement();
		
		String sql = "select idx, name, msg, wdate from memo order by idx desc";
		// select문일 경우 => ResultSet executeQuery(String sql)
		// ResultSet => 결과 테이블을 참조한다.
		/* ResultSet은 select문에 의해 영향받은 결과 테이블을 참조한다.
	     * - 논리적인 커서를 이동시키는 방식으로 데이터를 추출한다.
	     * - 논리적인 커서는 첫번째 행의 직전에 위치하고 있다가 (before first)
	     *   next()메소드가 호출되면 커서를 다음 칸으로 이동시키고, 이동한 위치에
	     *   레코드가 있다면 true를 반환한다.
	     *   boolean next()
	     *   데이터 꺼낼때는 rs.getXXX("컬럼명"), rs.getXXX(컬럼인덱스)
	     */
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int idx = rs.getInt("idx"); // number => rs.getInt("컬럼명")
			String name = rs.getString("name"); // varchar2 => rs.getString()
			String msg = rs.getString("msg");
			java.sql.Date wdate = rs.getDate("wdate"); // date => rs.getDate()
			System.out.println(idx + "\t" + name + "\t" + msg + "\t" + wdate);
		}
		
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
	}

}
