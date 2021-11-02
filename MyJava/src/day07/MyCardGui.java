package day07;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
// BorderLayoutm FlowLayout, GridLayout
// CardLayout
public class MyCardGui extends JFrame {

	JPanel p;
	CardLayout card;
	
	//카드레이아웃 적용할 JPanel
	JPanel p1;
	
	JButton b1, b2, b3;
	JLabel lb;
	JTextArea ta;
	JList lst;
	
	public MyCardGui() {
		super("::MyCardGui::");
		Container cp = this.getContentPane();
		p = new JPanel();
		p.setBackground(Color.white);
		cp.add(p, BorderLayout.CENTER);
		
		p.setLayout(new BorderLayout());
		JPanel pN = new JPanel();
		p.add(pN, BorderLayout.NORTH);
		
		p1 = new JPanel();
		p.add(p1, BorderLayout.CENTER);
		
		pN.setBackground(Color.DARK_GRAY);
		p1.setBackground(Color.yellow);
		
		pN.setLayout(new GridLayout(1, 0));
		// 행은 1행으로 고정, 열은 가변적으로 설정
		
		b1 = new JButton("Main");
		b2 = new JButton("Join");
		b3 = new JButton("Users");
		pN.add(b1);
		pN.add(b2);
		pN.add(b3);
		
		card = new CardLayout();
		p1.setLayout(card); //p1의 레이아웃을 카드레이아웃으로 설정
		
		// 첫번째 카드(컴포넌트, 컨테이너)
		lb = new JLabel(new ImageIcon("images/molang1.png"));
		// 두번째 카드
		ta = new JTextArea("::회원가입 페이지::");
		
		// 세번째 카드
		lst = new JList();
		
		p1.add(lb, "mainP"); // 카드를 구분할 문자열(alias)
		p1.add(new JScrollPane(ta), "joinP");
		p1.add(new JScrollPane(lst), "userP");
		
		//card.show(p1, "userP");
		//card.show(카드레이아웃이 적용된 컨테이너, 보여줄 카드의 별칭 문자열);
		// b1, b2, b3에 리스너 부착
		MyHandler handler = new MyHandler();
		
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // 생성자------------------------------------

	class MyHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			// b1 누르면 mainP 보여주기
			if(obj == b1) card.show(p1, "mainP");
			// b2, joinP
			if(obj == b2) card.show(p1, "joinP");
			// b3, userP
			if(obj == b3) card.show(p1, "userP");
		}
		
	}
	
	public static void main(String[] args) {
		MyCardGui my = new MyCardGui();
		my.setSize(480, 700);
		my.setVisible(true);
	} // 메인-------------------------------------

} // 클래스----------------------------------------