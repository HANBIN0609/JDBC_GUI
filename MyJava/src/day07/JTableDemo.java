package day07;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;

public class JTableDemo extends JFrame {

	JPanel p;
	JTable table; // View
	DefaultTableModel model; // Model => 데이터를 갖는다 

	String[][] data = {
			{"1", "홍길동", "Java반", "010-1111-2222"},
			{"2", "김길동", "C반", "010-2111-2222"},
			{"3", "홍철수", "Network반", "010-3111-2222"},
			{"4", "박길남", "Java반", "010-4111-2222"}
	};
	
	String[] title = {"학번", "이름", "학급명", "연락처"}; // 테이블 컬럼 제목으로 사용될 데이터
	
	public JTableDemo() {
		super("::JTableDemo::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		p.setLayout(new BorderLayout());
		
		table = new JTable(); // View
		p.add(new JScrollPane(table));
		
		model = new DefaultTableModel(data, title); // Model
		
		// View와 Model연결
		table.setModel(model);
		
		table.setRowHeight(25);
		table.setSelectionBackground(Color.blue);
		table.setSelectionForeground(Color.white);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // 생성자------------------------------------

	public static void main(String[] args) {
		JTableDemo my = new JTableDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	} // 메인-------------------------------------

} // 클래스----------------------------------------
