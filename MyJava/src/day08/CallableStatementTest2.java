package day08;
import jdbc.util.*;
import java.sql.*;
import javax.swing.*;

public class CallableStatementTest2 {

	public static void main(String[] args) throws SQLException{
//		Scanner sc = new Scanner(System.in);
//		System.out.print("작성자번호 입력 : ");
//		int number = sc.nextInt();
//		sc.skip("\r\n"); //엔터값 건너뛰기 //sc.nextLine();
//		System.out.print("메세지 입력 : ");
//		String msg = sc.nextLine();
//		System.out.println(number + " / " + msg);
		
		String num = JOptionPane.showInputDialog("작성자번호 입력");
		if(num==null)
			return;
		String msg = JOptionPane.showInputDialog("메세지 입력");
		if(msg==null)
			return;
		int number = Integer.parseInt(num);
		
		
		Connection con = DBUtil.getCon();
		
		String sql = "{call memo_update(?,?)}";
		
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, number);
		cstmt.setString(2, msg);
		int n = cstmt.executeUpdate();
		System.out.println(n + " 개의 레코드를 수정했어요.");
		
		cstmt.close();
		con.close();


	}

}
