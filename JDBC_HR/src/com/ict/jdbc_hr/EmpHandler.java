package com.ict.jdbc_hr;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
/*MouseEvent 처리
 * - 이벤트 소스 : JTable => empTable
 * - 이벤트 : MouseEvent
 * - 이벤트 핸들러 : MouseListener 인터페이스를 상속받아 구현 -> 가지고 있는 추상메소드 5개를 모두 오버라이드 해야함
 * 							또는
 * 				 MouseAdapter 추상클래스를 상속받아 구현
 * */
public class EmpHandler extends MouseAdapter implements ActionListener{

	private EmpPanel empP; // View
	private EmpDAO empDao; // Model
	
	public EmpHandler(EmpPanel empP) {
		this.empP = empP;
		this.empDao = new EmpDAO();
	}
	
	public void clearTf() {
		empP.tfEmpno.setText("");
		empP.tfEname.setText("");
		empP.tfJob.setText("");
		empP.tfHiredate.setText("");
		empP.tfEname.requestFocus();
	}//-------------------------------
	
	public void addEmp() {
		// 1. 부서명, 부서번호 선택값 알아내기
		Object obj = empP.comboDname.getSelectedItem();
		String str = obj.toString();
		
		int deptno = 0;
		switch(str) {
			case "ACCOUNTING": deptno = 10; break;
			case "RESEARCH": deptno = 20; break;
			case "SALES": deptno = 30; break;
			case "OPERATION": deptno = 40; break;
		}
		// 2. 사원명, 담당업무 입력값 받아오기
		String ename = empP.tfEname.getText();
		String job = empP.tfJob.getText();
		
		// 3. 유효성 체크(null, 빈 문자열 체크)
		if(ename == null || job == null || ename.trim().equals("") || job.trim().isEmpty()) {
			show("부서명과 부서위치를 입력해야 해요.");
			empP.tfEname.requestFocus();
			return;
		}
		// 4. EmpVO를 생성해서 EmpVO에 부서번호, 부서명, 사원명, 담당업무 담아주기
		EmpVO vo = new EmpVO();
		vo.setDeptno(deptno);
		vo.setDname(str);
		vo.setEname(ename);
		vo.setJob(job);
		
		// 5. EmpDAO 의 insertEmp() 호출하기
		int n = empDao.insertEmp(vo);
		
		// 6. 그 결과 메시지 처리
		String msg = (n>0)? "사원정보 등록 완료" : "사원정보 등록 실패";
		show(msg);
		clearTf();
		
	}//-------------------------------
	
	public void show(String msg) {
		JOptionPane.showMessageDialog(empP, msg);
	}//-------------------------------
	
	
	public void listEmp() {
		java.util.List<EmpVO> arr = empDao.listEmp();
		empP.showEmpTable(arr);
	}
	
	public void deleteEmp() {
		String eno = JOptionPane.showInputDialog("삭제할 사원번호를 입력하세요");
		if(eno == null) return;
		int yn = JOptionPane.showConfirmDialog(empP, 
				eno+"번 사원정보를 정말 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION);
		System.out.println("yn: " + yn);
		if(yn == JOptionPane.YES_OPTION) {
			int empno = Integer.parseInt(eno.trim());
			int n = empDao.deleteEmp(empno);
			
			String msg = (n>0) ? eno+"번 사원정보 삭제처리 완료" : "삭제 실패";
			show(msg);
			if(n>0) {
				listEmp();
			}
		}
	}//-----------------------------------------------
	
	private void updateEmp() {
		//1. 사용자가 수정한 값 얻어오기
		String dname = empP.comboDname.getSelectedItem().toString();
		String empno = empP.tfEmpno.getText();
		String ename = empP.tfEname.getText();
		String job = empP.tfJob.getText();
		String hiredate = empP.tfHiredate.getText();
	
		//2. 유효성 체크
		if(empno == null || empno.trim().equals("") 
				|| ename == null || ename.trim().equals("") 
				|| job == null || job.trim().equals("")) {
			show("사원테이블의 사원을 선택하거나 수정할 값들을 모두 입력해야 해요.");
			empP.tfEname.requestFocus();
			return;
		}
		//3. 수정한 값들을 EmpVO에 담아주기
		EmpVO emp 
		= new EmpVO(Integer.parseInt(empno), ename, job, null, dname, 0);
		
		//4. empDao의 updateEmp(vo객체) 호출하기
		int n = empDao.updateEmp(emp);
		
		//5. 그 실행 결과 메시지 보여주기
		String msg = (n>0) ? "사원정보 수정 완료" : "수정 실패";
		show(msg);
		
		//6. 전체 목록 가져오기
		listEmp();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == empP.btEmpAdd) {
			addEmp(); // 등록 처리
			listEmp(); // 전체목록 가져오기
		} else if(obj == empP.btEmpList) {
			listEmp();
		} else if(obj == empP.btEmpDel) {
			deleteEmp(); // 삭제 처리
			listEmp(); // 전체목록 가져오기
		} else if(obj == empP.btEmpEdit) {
			updateEmp();
		} else if(obj == empP.btEmpRest) {
			clearTf();
		}
	}

	// 클릭하는 행위 : Pressed > Released > Clicked
	public void mousePressed(MouseEvent e) {
		setEmpData();
	}
	
	public void setEmpData() {
		//System.out.println("Pressed");
		//1. empTable에서 선택한 행의 인덱스 번호 알아내기
		int row = empP.empTable.getSelectedRow();
		System.out.println("row: "+row);
		//선택한 행이 없을 때는 -1을 반환한다.
		
		if(row < 0) return;
		//2. 해당 행의 사번, 이름, 부서명, 담당업무, 입사일 데이터를 추출하기
		String empno = empP.empModel.getValueAt(row, 0).toString();
		String ename = empP.empModel.getValueAt(row, 1).toString();
		String dname = empP.empModel.getValueAt(row, 2).toString();
		String job = empP.empModel.getValueAt(row, 3).toString();
		String hiredate = empP.empModel.getValueAt(row, 4).toString();
		
		//3. tfEname, tfJob, tfHiredate에 셋팅하기
		empP.tfEmpno.setText(empno);
		empP.tfEname.setText(ename);
		empP.tfJob.setText(job);
		empP.tfHiredate.setText(hiredate);
		empP.comboDname.setSelectedItem(dname);
	}
}///////////////////////////////////////////////////
