package day10;
import java.sql.*;
import jdbc.util.*;
import java.util.*;
/*ResultSetMetaData 클래스
 * - ResultSet에 관한 정보를 알고 있는 클래스
 * - 컬럼명, 컬럼의 자료형, 자료형 크기
 * 	 등의 메타정보를 알고자 하면 ResultSetMetaData를 이용하자
 * 
 */
public class ResultSetMetaDataTest {

	public static void main(String[] args) throws Exception{
		Connection con = DBUtil.getCon();
		Scanner sc = new Scanner(System.in);
		System.out.println("SELECT문을 입력하세요 => ");
		
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
		// 결과 테이블 (rs)에 대한 정보를 추출해보자.
		ResultSetMetaData rsmd = rs.getMetaData();
		// 컬럼 수 알아내기
		int count = rsmd.getColumnCount();
		System.out.println("count : "+count);
		
		// 컬럼에 대한 정보 알아내기
		for(int i = 1; i <= count; i++) {
			String colName = rsmd.getColumnName(i);
			String colType = rsmd.getColumnTypeName(i);
			int n = rsmd.isNullable(i);
			// not null => 0 반환, null 허용하면 => 1 반환
			
			int dispSize = rsmd.getColumnDisplaySize(i);
			
			System.out.println("컬럼명: "+colName+"["+colType+"]");
			System.out.println((n==0)?"NOT NULL":"NULL");
			System.out.println("컬럼 display 크기: "+dispSize);
			
			System.out.println("-------------------------");
		}
		
		
		rs.close();
	}

}
