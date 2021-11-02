package day07;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
// Swing
// MFC ==> JFC
// MVC패턴 ==> UI Delegation모델
/* - M (Model) : 데이터를 가지고 있는 클래스
 * - V (View) : UI를 구성하는 클래스
 * - C (Controller) : UI와 Model 사이에서 제어하는 클래스
 * 
 */
public class JListDemo extends JFrame {

	JPanel p;
	
	JList<String> lst; // component => View에 속함
	JComboBox<String> combo;
	// JTable table;

	DefaultListModel<String> model1; // JList의 모델 Model
	DefaultComboBoxModel<String> model2; // JComboBox의 Model
	
	String[] data = {"김나나", "이일국", "이한빈", "현주홍"};
	
	public JListDemo() {
		super("::JListDemo::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);

		// Model 생성
		model1 = new DefaultListModel<>();
		for(String name:data) {
			model1.addElement(name);
		}
		
		// View 생성
		lst = new JList<>();
		
		// View와 Model을 연결해야 데이터가 View에 나타남
		lst.setModel(model1);
		p.setLayout(new BorderLayout());
		p.setBackground(Color.DARK_GRAY);
		p.add(new JScrollPane(lst));
		
		combo = new JComboBox<>(); // View
		p.add(combo, BorderLayout.NORTH);
		
		model2 = new DefaultComboBoxModel<>(data); // Model
		combo.setModel(model2); // View와 Model을 연결
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // 생성자------------------------------------

	public static void main(String[] args) {
		JListDemo my = new JListDemo();
		my.setSize(500, 500);
		my.setVisible(true);
	} // 메인-------------------------------------

} // 클래스----------------------------------------