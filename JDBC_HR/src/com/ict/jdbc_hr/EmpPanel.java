/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ict.jdbc_hr;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.*;

/**
 *
 * @author LeeHanBin
 */
public class EmpPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmpPanel
     */
	EmpHandler handler;
	DefaultTableModel empModel;
	String[] title = {"사번","사원명","부서명","담당업무","입사일"};
	
	
    public EmpPanel() {
        initComponents();
        //리스너 부착----------------
        handler = new EmpHandler(this);
        btEmpAdd.addActionListener(handler);
        btEmpDel.addActionListener(handler);
        btEmpEdit.addActionListener(handler);
        btEmpList.addActionListener(handler);
        btEmpRest.addActionListener(handler);
        
        empTable.addMouseListener(handler);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfEname = new javax.swing.JTextField();
        comboDname = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfEmpno = new javax.swing.JTextField();
        tfJob = new javax.swing.JTextField();
        tfHiredate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        btEmpAdd = new javax.swing.JButton();
        btEmpList = new javax.swing.JButton();
        btEmpDel = new javax.swing.JButton();
        btEmpEdit = new javax.swing.JButton();
        btEmpRest = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("휴먼매직체", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("::사원정보 등록::");

        comboDname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SALES", "ACCOUNTING", "RESEARCH", "OPERATION" }));

        jLabel2.setText("사원명");

        jLabel3.setText("사번");

        jLabel4.setText("부서명");

        jLabel5.setText("입사일");

        jLabel6.setText("담당업무");

        tfEmpno.setEditable(false);

        tfHiredate.setEditable(false);
        tfHiredate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHiredateActionPerformed(evt);
            }
        });

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "사번", "사원명", "부서명", "담당업무", "입사일"
            }
        ));
        empTable.setEnabled(true);
        jScrollPane1.setViewportView(empTable);

        btEmpAdd.setText("사원정보 등록");
        btEmpAdd.setBorder(null);
        btEmpAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpAddActionPerformed(evt);
            }
        });

        btEmpList.setText("사원목록 보기");
        btEmpList.setBorder(null);
        btEmpList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpListActionPerformed(evt);
            }
        });

        btEmpDel.setText("사원정보 삭제");
        btEmpDel.setBorder(null);
        btEmpDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpDelActionPerformed(evt);
            }
        });

        btEmpEdit.setText("사원정보 수정");
        btEmpEdit.setBorder(null);
        btEmpEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpEditActionPerformed(evt);
            }
        });

        btEmpRest.setText("Reset");
        btEmpRest.setBorder(null);
        btEmpRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmpRestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfEname, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboDname, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfHiredate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfJob, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btEmpAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEmpList, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEmpDel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEmpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEmpRest, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfHiredate, tfJob});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDname, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEname, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(tfJob, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(tfHiredate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEmpAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEmpList, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEmpDel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEmpEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEmpRest, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfHiredate, tfJob});

    }// </editor-fold>//GEN-END:initComponents

    private void tfHiredateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHiredateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHiredateActionPerformed

    private void btEmpAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmpAddActionPerformed

    private void btEmpListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmpListActionPerformed

    private void btEmpDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpDelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmpDelActionPerformed

    private void btEmpEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmpEditActionPerformed

    private void btEmpRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmpRestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEmpRestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btEmpAdd;
    javax.swing.JButton btEmpDel;
    javax.swing.JButton btEmpEdit;
    javax.swing.JButton btEmpList;
    javax.swing.JButton btEmpRest;
    javax.swing.JComboBox<String> comboDname;
    javax.swing.JTable empTable;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTextField tfEmpno;
    javax.swing.JTextField tfEname;
    javax.swing.JTextField tfHiredate;
    javax.swing.JTextField tfJob;
    // End of variables declaration//GEN-END:variables

	public void showEmpTable(List<EmpVO> arr) {
		if(arr == null) return;
		Object[][] data = new Object[arr.size()][title.length];
		for(int i = 0; i < arr.size(); i++) {
			EmpVO emp = arr.get(i);
			data[i][0] = emp.getEmpno();
			data[i][1] = emp.getEname();
			data[i][2] = emp.getDname();
			data[i][3] = emp.getJob();
			data[i][4] = emp.getHiredate();	
		}// for----------------------------
		
		empModel = new DefaultTableModel(data, title);
		empTable.setModel(empModel);
	}
}