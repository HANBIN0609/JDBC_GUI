package day06;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/*이벤트 소스  : 버튼, JTextField
* 이벤트     : ActionEvent
* 이벤트 핸들러: ActionListener 인터페이스를 상속
* 이벤트 처리 절차에 따라 구성하고
*=> 버튼 누르면 setTitle("버튼 클릭")
*[1] tf에 입력한 값 얻어오기 
*[2] ta에 얻어온 값을 붙이기
* */
public class MyChatGui extends JFrame {
    
   JTextField tf;
   JButton bt;
   JTextArea ta;
   JPanel p;
   
   public MyChatGui() {
      super("::MyChatGui::");
      p=new JPanel();
      add(p,"North");
      ta=new JTextArea();
      add(new JScrollPane(ta),"Center");
      
      tf=new JTextField(20);
      bt=new JButton("입력");
      
      p.setLayout(new BorderLayout(10,10));
      p.add(tf,"Center");
      p.add(bt,"East");
      
      setBackground(Color.DARK_GRAY);
      //리스너 부착
      MyEventHandler handler=new MyEventHandler();
      bt.addActionListener(handler);
      tf.addActionListener(handler);
      
      //ta는 편집하지 못하도록
      ta.setEditable(false);
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//생성자------
   
   class MyEventHandler implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent e)       
      {
         //setTitle("###");
         Object obj=e.getSource();
         if(obj==bt || obj==tf) {
            //tf에 입력한 값 얻어오기
            String input=tf.getText();
            //String=> int indexOf(char ch) : 특정 문자가 있는 곳의 인덱스 번호를 반환한다.
            //            검색하는 문자가 없으면 -1을 반환한다.
            int index=input.indexOf('콩');
            setTitle("index: "+index);
            try {
               if(index>-1) {
                  throw new NotSupportedNameException("메시지 중에 '콩'이란 문자가 있으면 안돼요!!");
               }
            }catch(NotSupportedNameException ex) {
               ta.append(ex.getMessage()+"\n");
               return;
            }
            //ta.setText(input);
            //ta에 대화내용 덧붇이기 void append(String str)
            ta.append(input+"\n");
            tf.setText("");
         }
         
      }
      
   }//inner class/////////////
   
   
   public static void main(String[] args) {
      MyChatGui my = new MyChatGui();
      my.setSize(500, 500);
      my.setVisible(true);
   }

}