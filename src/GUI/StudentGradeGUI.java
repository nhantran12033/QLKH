/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.OnsiteCourseBLL;
import BLL.StudentGradeBLL;
import DTO.OnsiteDTO;
import DTO.StudenGradeDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nhan
 */
public class StudentGradeGUI extends javax.swing.JPanel {

    /**
     * Creates new form StudentGradeGUI
     */
    public StudentGradeGUI() {
        initComponents();
        Load();
    }
    StudentGradeBLL spq = new StudentGradeBLL();
    public void Empty(){
        jTextField3.setText("");
        jTextField2.setText("");
       
    }
    public void Load() {
        
        List<StudenGradeDTO> listonl = spq.listonl();
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (StudenGradeDTO sp : listonl) {
            String EnrollmentID = sp.getEnrollmentID();
            String CourseID= sp.getCourseID();
            String StudentID = sp.getStudentID();
            String Grade = sp.getGrade();
            DFT.addRow(new Object[]{EnrollmentID,CourseID,StudentID,Grade});
        }
     }
     private void xuLySua() {
         String EnrollmentID = (String) jComboBox1.getSelectedItem();
         String CourseID = (String) jComboBox2.getSelectedItem();
         String StudentID = (String) jComboBox3.getSelectedItem();
         String grade = jTextField2.getText();
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (StudenGradeDTO nv : spq.TimKiem(EnrollmentID)) {
            if(nv.getEnrollmentID().equalsIgnoreCase(EnrollmentID)){               
                vitri = 1;
            }
           
        }
        if(vitri < 0){
            JOptionPane.showMessageDialog(null, "Không tìm thấy ID");
            spq.docListonl();
            Load();
            Empty();
        }
        else{
            String grade1="[a-zA-z]{0,1}";
            if(!grade.equalsIgnoreCase(grade1)){
                boolean flag = spq.ChinhSua(EnrollmentID, CourseID,StudentID,grade);
                spq.docListonl();
                Load();
                Empty();
            }
            else if(grade.isEmpty()){
                JOptionPane.showMessageDialog(null, "Không được bỏ trống ");
            }
            else{
                JOptionPane.showMessageDialog(null, "Nhập sai kí tự");
                          }    
        
        }
        
    }
    public void Load3() {       
        String Enrollment = jTextField3.getText();
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (StudenGradeDTO sp : spq.TimKiem(Enrollment)) {
            if(sp.getEnrollmentID().equalsIgnoreCase(Enrollment)){
            String EnrollmentID = sp.getEnrollmentID();
            String CourseID = sp.getCourseID();
            String StudentID = sp.getStudentID();
            String Grade = sp.getGrade();
            DFT.addRow(new Object[]{EnrollmentID,CourseID,StudentID,Grade});
            vitri = 1;
            }
        }
         if(vitri < 0){
            JOptionPane.showMessageDialog(null, "Không tìm thấy ID");
            spq.docListonl();
            Load();
            Empty();
        }
         
        else{
            JOptionPane.showMessageDialog(null, "Tìm thành công");
            Empty();
        }
    }
    private void xuLyThem() {    
        String Enrollment = (String) jComboBox1.getSelectedItem();
        String CourseID = (String) jComboBox2.getSelectedItem();
        String StudentID = (String) jComboBox3.getSelectedItem();
        String grade = jTextField2.getText();
        String grade1="[a-zA-z]{0,1}";
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (StudenGradeDTO nv : spq.TimKiem(Enrollment)) {
            if(nv.getEnrollmentID().equalsIgnoreCase(Enrollment)){               
                vitri = 1;
            }
           
        }
        if(vitri < 0){
            
            if(!grade.equalsIgnoreCase(grade1)){
            boolean flag = spq.them(Enrollment, CourseID,StudentID,grade);
            spq.docListonl();
            Load();
            Empty();
        }
        else if(grade.isEmpty()){
            JOptionPane.showMessageDialog(null, "Không được bỏ trống ");
        }
        else if(grade.equalsIgnoreCase(grade1)){
            JOptionPane.showMessageDialog(null, "Nhâp ");
        }
        else{
            JOptionPane.showMessageDialog(null, "Nhập sai kí tự");
                      }    
        }
        else{
           JOptionPane.showMessageDialog(null, "Trùng ID");
           Load();
           Empty();
        }
        
        
    }
    private void xuLyXoa() {
        String Enrollment = (String) jComboBox1.getSelectedItem();
        
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (StudenGradeDTO nv : spq.TimKiem(Enrollment)) {
            if(nv.getEnrollmentID().equalsIgnoreCase(Enrollment)){               
                vitri = 1;
            }
           
        }
        if(vitri < 0){
            JOptionPane.showMessageDialog(null, "Không tìm thấy ID");
            spq.docListonl();
            Load();
            Empty();
        }
        else{
           
           boolean flag = spq.xoa(Enrollment);   
           spq.docListonl();
           Load();
           Empty();
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        jPanel1.setPreferredSize(new java.awt.Dimension(730, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("COURSE INTRUCTOR");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Enrollment ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 102, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 100, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Enrollment ID", "Course ID", "Student ID", "Grade"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 320, 400));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("TÌM KIẾM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("THÊM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("SỬA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, -1));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("XÓA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Grade");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 102, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Course ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1045", "1061", "2021", "4061", "4041", "3141", "1050", "2030", "2042", "4022" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 102, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Student ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Student ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 712, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String id1 = model.getValueAt(row,0).toString();
        String id2 = model.getValueAt(row,1).toString();
        String id3 = model.getValueAt(row,2).toString();
        String grade = model.getValueAt(row,3).toString();
        int i =0;
        int h=0;
        int t=0;
        while(true){
            String id4 = jComboBox1.getItemAt(i).toString();
            if(id4.equalsIgnoreCase(id1)){
                jComboBox1.setSelectedIndex(i);
                break;
            }
            i++;
        }
        while(true){
            String id5 = jComboBox2.getItemAt(h).toString();
            if(id5.equalsIgnoreCase(id2)){
                jComboBox2.setSelectedIndex(h);
                break;
            }
            h++;
        }
        while(true){
            String id6 = jComboBox3.getItemAt(t).toString();
            if(id6.equalsIgnoreCase(id3)){
                jComboBox3.setSelectedIndex(t);
                break;
            }
            t++;
        }
        jTextField2.setText(grade);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        xuLySua();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        xuLyThem();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        xuLyXoa();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTextField3.getText().isEmpty()){
            spq.docListonl();
            Load();
        }
        else
            Load3();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
