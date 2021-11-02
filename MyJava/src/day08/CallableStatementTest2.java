package day08;
import jdbc.util.*;
import java.sql.*;
import javax.swing.*;

public class CallableStatementTest2 {

	public static void main(String[] args) throws SQLException{
//		Scanner sc = new Scanner(System.in);
//		System.out.print("�ۼ��ڹ�ȣ �Է� : ");
//		int number = sc.nextInt();
//		sc.skip("\r\n"); //���Ͱ� �ǳʶٱ� //sc.nextLine();
//		System.out.print("�޼��� �Է� : ");
//		String msg = sc.nextLine();
//		System.out.println(number + " / " + msg);
		
		String num = JOptionPane.showInputDialog("�ۼ��ڹ�ȣ �Է�");
		if(num==null)
			return;
		String msg = JOptionPane.showInputDialog("�޼��� �Է�");
		if(msg==null)
			return;
		int number = Integer.parseInt(num);
		
		
		Connection con = DBUtil.getCon();
		
		String sql = "{call memo_update(?,?)}";
		
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, number);
		cstmt.setString(2, msg);
		int n = cstmt.executeUpdate();
		System.out.println(n + " ���� ���ڵ带 �����߾��.");
		
		cstmt.close();
		con.close();


	}

}
