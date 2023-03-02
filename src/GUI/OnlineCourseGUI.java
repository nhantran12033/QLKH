/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.OnlineCourseBLL;
import DAL.OnlineCourseDAL;
import DTO.OnlineCourseDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nhan
 */
public class OnlineCourseGUI extends javax.swing.JPanel {

    /**
     * Creates new form OnlineCourseGUI
     */
    public OnlineCourseGUI() {
        initComponents();
        Load();
    }
    OnlineCourseBLL spq = new OnlineCourseBLL();
    public void Empty(){
        jTextField3.setText("");
        jTextField2.setText("");
        
    }
    public void Load() {
       
        List<OnlineCourseDTO> listonl = spq.listonl();
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnlineCourseDTO sp : listonl) {
            String CourseID = sp.getCourseID();
            String url = sp.getUrl();
            
            DFT.addRow(new Object[]{CourseID, url});
        }
     }
     private void xuLySua() {
         String CourseID = (String) jComboBox1.getSelectedItem();
        
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnlineCourseDTO nv : spq.TimKiem(CourseID)) {
            if(nv.getCourseID().equalsIgnoreCase(CourseID)){               
                vitri = 1;
            }
           
        }
        if(vitri < 0){
            JOptionPane.showMessageDialog(null, "Không tìm thấy ID");
            Load();
            Empty();
        }
        else{
           
        String url1 = "^http://www+\\.[a-zA-Z]{0,}+\\.[a-zA-Z]{2,4}";
        String url = jTextField3.getText();
        if(!url.isEmpty()){
            if(!url.matches(url1)){
            JOptionPane.showMessageDialog(null, "Nhập sai url");
            spq.docListonl();
            Load();Empty();
        }
            else{
            boolean flag = spq.ChinhSua(CourseID,url);
            spq.docListonl();
            Load();Empty();}
        }
        else{
            JOptionPane.showMessageDialog(null, "Không được để rỗng");
            spq.docListonl();
            Load();
            Empty();
        }
           
        
    }
 }
    public void Load3() {       
        String CourseID = jTextField2.getText();
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnlineCourseDTO nv : spq.TimKiem(CourseID)) {
            if(nv.getCourseID().equalsIgnoreCase(CourseID)){
                String course = nv.getCourseID();
                String url = nv.getUrl();
                DFT.addRow(new Object[]{course, url});
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
        String CourseID = (String) jComboBox1.getSelectedItem();
        String url1 = "^http://www+\\.[a-zA-Z]{0,}+\\.[a-zA-Z]{2,4}";
        String url = jTextField3.getText(); 
        if(!url.isEmpty()){
            if(!url.matches(url1)){
            JOptionPane.showMessageDialog(null, "Nhập sai url");
            spq.docListonl();
            Load();Empty();
        }
            else{
            boolean flag = spq.them(CourseID,url);
            spq.docListonl();
            Load();Empty();}
        }
        else{
            JOptionPane.showMessageDialog(null, "Không được để rỗng");
            spq.docListonl();
            Load();
            Empty();
        }
           
           
        
    }
    private void xuLyXoa() {
        String CourseID = (String) jComboBox1.getSelectedItem();
        
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnlineCourseDTO nv : spq.TimKiem(CourseID)) {
            if(nv.getCourseID().equalsIgnoreCase(CourseID)){               
                vitri = 1;
            }
           
        }
        if(vitri < 0){
            JOptionPane.showMessageDialog(null, "Không tìm thấy ID");
            Load();
            Empty();
        }
        else{
           boolean flag = spq.xoa(CourseID);           
           Load();
           Empty();
        }
    }
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(730, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("ONLINE COURSE");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Course ID");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1045", "1061", "2021", "4061", "4041", "3141", "1050", "2030", "2042", "4022" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 102, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("URL");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 150, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course ID", "URL"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 330, 400));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("TÌM KIẾM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("THÊM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("SỬA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, -1));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("XÓA");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 480, -1, -1));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 102, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      
        
            Load3();
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        xuLyThem();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            // TODO add your handling code here:
            xuLyXoa();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        xuLySua();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String id1 = model.getValueAt(row,0).toString();
        int i =0;
        while(true){
            String id = jComboBox1.getItemAt(i).toString();
            if(id.equalsIgnoreCase(id1)){
                jComboBox1.setSelectedIndex(i);
                break;
            }
            i++;
        }
        jTextField3.setText(model.getValueAt(row,1).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField3KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

  
}
