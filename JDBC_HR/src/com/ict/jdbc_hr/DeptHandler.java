package com.ict.jdbc_hr;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// DeptPanel이 가지고 있는 컴포넌트들의 이벤트를 처리하는 클래스
// 이벤트 핸들러를 외부 클래스로 별도로 구성할 경우
// ==> 꼭 인자 생성자를 구성해야 한다.(DeptPanel을 매개변수로 받는 생성자)
public class DeptHandler implements ActionListener{

	private DeptPanel deptP; // View
	private DeptDAO deptDao; // Model
	
	public DeptHandler(DeptPanel deptP) {
		this.deptP = deptP;
		this.deptDao = new DeptDAO();
		list();
	}//------------------------------------------------
	
	public void clearTf() {
		deptP.tfDeptno.setText("");
		deptP.tfLoc.setText("");
		deptP.tfDname.setText("");
		deptP.tfDname.requestFocus(); // 입력필드에 포커스 주기
	}//-----------------------------------------------
	
	public void show(String msg) {
		JOptionPane.showMessageDialog(deptP, msg);
	}//-----------------------------------------------
	
	public void add() {
		// 1. 부서명, 근무지 입력한 값 받아오기
		String dname = deptP.tfDname.getText();
		String loc = deptP.tfLoc.getText();
				
		// 2. 유효성 체크 // trim(): 앞뒤의 공백문자를 제거해줌
		if(dname == null || loc == null || dname.trim().equals("") || loc.trim().isEmpty()) {
			show("부서명과 부서위치를 입력해야 해요.");
			deptP.tfDname.requestFocus();
			return;
		}
		// 3. 입력받은 값을 DeptVO객체에 담아주기
		DeptVO vo = new DeptVO();
		vo.setDname(dname);
		vo.setLoc(loc);
		
		// 4. dao의 insertDept() 호출
		int n = deptDao.insertDept(vo);
		
		// 5. 실행 결과 메시지 처리
		String msg = (n>0)? "부서정보 등록 완료" : "부서정보 등록 실패";
		show(msg);
		clearTf();
		if(n>0) {
			list();
		}
	}//-----------------------------------------------
	
	public void list() {
		ArrayList<DeptVO> arr = deptDao.listDept();
		if(arr == null) return;
		deptP.showDeptList(arr);
	}//-----------------------------------------------
	
	public void delete() {
		String dno = JOptionPane.showInputDialog("삭제할 부서번호를 입력하세요");
		if(dno == null) return;
		int deptno = Integer.parseInt(dno.trim());
		
		int n = deptDao.deleteDept(deptno);
		String msg = (n>0) ? dno+"번 부서정보 삭제처리 완료" : "삭제 실패";
		show(msg);
		
		if(n>0) {
			list();
		}
	}//-----------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == deptP.btDeptAdd) {
			add();
		} else if(obj == deptP.btDeptDel) {
			delete();
		} else if(obj == deptP.btDeptReset) {
			clearTf();
		}
	}
	
}///////////////////////////////
