package day10;
import java.sql.*;
import jdbc.util.*;
/**여러 개의 SQL문을 한꺼번에 전송하는 일괄처리 방식
 * 여러 개의 SQL문을 작성하여
 * Statement의 addBatch(String sql)호출
 * executeBatch()
 * */
public class BatchQuery {

	public static void main(String[] args) throws SQLException{
		Connection con = DBUtil.getCon();
		//Connection의 디폴트 : auto commit
		con.setAutoCommit(false); // 트랜잭션 처리를 하기 위해 커밋을 수동으로설정
		Statement st = con.createStatement();
		
		st.addBatch("insert into memo values(memo_sq.nextval, '김길동', 'Batch Test1', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '윤길동', 'Batch Test2', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '박길동', 'Batch Test3', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '이길동', 'Batch Test4', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '허길동', 'Batch Test5', sysdate)");
		boolean isCommit = false;
		try {
			int[] cnt = st.executeBatch();
			isCommit = true;
		} catch (SQLException e) {
			// con.rollback(); // 하나라도 실패하면 rollback()
			isCommit = false;
			e.printStackTrace();
		} 
		
		if(isCommit) {
			// 전부 성공하면 commit
			con.commit();
		} else {
			// 하나라도 실패하면 rollback
			con.rollback();
		}
		con.setAutoCommit(true); // 자동 커밋으로 복원
		
		String sql = "select * from memo order by idx desc";
		
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int idx = rs.getInt(1);
			String name = rs.getString(2);
			String msg = rs.getString(3);
			Date wdate = rs.getDate(4);
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		
		rs.close();
		st.close();
		con.close();
		
	}

}
