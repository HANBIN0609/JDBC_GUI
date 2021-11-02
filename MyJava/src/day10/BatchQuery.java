package day10;
import java.sql.*;
import jdbc.util.*;
/**���� ���� SQL���� �Ѳ����� �����ϴ� �ϰ�ó�� ���
 * ���� ���� SQL���� �ۼ��Ͽ�
 * Statement�� addBatch(String sql)ȣ��
 * executeBatch()
 * */
public class BatchQuery {

	public static void main(String[] args) throws SQLException{
		Connection con = DBUtil.getCon();
		//Connection�� ����Ʈ : auto commit
		con.setAutoCommit(false); // Ʈ����� ó���� �ϱ� ���� Ŀ���� �������μ���
		Statement st = con.createStatement();
		
		st.addBatch("insert into memo values(memo_sq.nextval, '��浿', 'Batch Test1', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '���浿', 'Batch Test2', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '�ڱ浿', 'Batch Test3', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '�̱浿', 'Batch Test4', sysdate)");
		st.addBatch("insert into memo values(memo_sq.nextval, '��浿', 'Batch Test5', sysdate)");
		boolean isCommit = false;
		try {
			int[] cnt = st.executeBatch();
			isCommit = true;
		} catch (SQLException e) {
			// con.rollback(); // �ϳ��� �����ϸ� rollback()
			isCommit = false;
			e.printStackTrace();
		} 
		
		if(isCommit) {
			// ���� �����ϸ� commit
			con.commit();
		} else {
			// �ϳ��� �����ϸ� rollback
			con.rollback();
		}
		con.setAutoCommit(true); // �ڵ� Ŀ������ ����
		
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
