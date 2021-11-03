package com.blue.jdbc_hr;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class BlueMainFrame extends JFrame{

	
		JPanel p;
		JTabbedPane tp;
		
		
		public BlueMainFrame() {
			super("::BlueMainFrame::");
			Container cp = this.getContentPane();
			p = new JPanel();
			p.setBackground(Color.white);
			cp.add(p, BorderLayout.CENTER);
			p.setLayout(new BorderLayout());
			
			tp = new JTabbedPane();
			p.add(tp);
			
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}// 持失切------------------------------------

		public static void main(String[] args) {
			BlueMainFrame my = new BlueMainFrame();
			my.setSize(770, 650);
			my.setVisible(true);
		} // 五昔-------------------------------------

}


