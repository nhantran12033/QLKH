/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.OnsiteCourseBLL;
import DAL.OnlineCourseDAL;
import DAL.OnsiteCourseDAL;
import DTO.OnlineCourseDTO;
import DTO.OnsiteDTO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nhan
 */
public class OnsiteCourseGUI extends javax.swing.JPanel {

    /**
     * Creates new form OnsiteCourseGUI
     */
    public OnsiteCourseGUI() {
        initComponents();
        Load();
    }
    OnsiteCourseBLL spq = new OnsiteCourseBLL();
    public void Empty(){
        jTextField3.setText("");
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
    }
    public void Load() {
        
        List<OnsiteDTO> listonl = spq.listonl();
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnsiteDTO sp : listonl) {
            String CourseID = sp.getCourseID();
            String url = sp.getLocation();
            String days = sp.getDays();
            String time = sp.getTime();
            DFT.addRow(new Object[]{CourseID, url, days, time});
        }
     }
     private void xuLySua() {
        String CourseID = (String) jComboBox1.getSelectedItem();
       int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnsiteDTO nv : spq.TimKiem(CourseID)) {
            if(nv.getCourseID().equalsIgnoreCase(CourseID)){               
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
          
            String url1="[0-9]{2,3}+\s[a-zA-Z]{0,}";
            String day="[A-Z]{2,4}";
            String time123="[0-9]{2,2}+\\:[0-9]{2,2}+\\:[0-9]{2,2}";
            String url = jTextField4.getText();
            String days = jTextField5.getText();
            String time = jTextField3.getText();
            if(!url.isEmpty() && !days.isEmpty() && !time.isEmpty()){
                if(!url.matches(url1)){
                    JOptionPane.showMessageDialog(null, "Nhập sai location");

                }
                if(!days.matches(day)){
                    JOptionPane.showMessageDialog(null, "Nhập sai days");            
                }
                if(!time.matches(time123)){
                    JOptionPane.showMessageDialog(null, "Nhập sai time");            
                }
                else{
                    boolean flag = spq.ChinhSua(CourseID, url,days,time);
                    spq.docListonl();
                    Load();
                    Empty();
                }
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
        for (OnsiteDTO nv : spq.TimKiem(CourseID)) {
            if(nv.getCourseID().equalsIgnoreCase(CourseID)){
            String course = nv.getCourseID();
            String location = nv.getLocation();
            String days = nv.getDays();
            String time = nv.getTime();
            DFT.addRow(new Object[]{course,location,days,time});
            vitri = 1;
            }
        }
         if(vitri < 0){
            JOptionPane.showMessageDialog(null, "Không tìm thấy ID");
        }
        else{
            JOptionPane.showMessageDialog(null, "Tìm thành công");
            Empty();
        }
    }
    private void xuLyThem() {
       String CourseID = (String) jComboBox1.getSelectedItem();
       int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnsiteDTO nv : spq.TimKiem(CourseID)) {
            if(nv.getCourseID().equalsIgnoreCase(CourseID)){               
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
          
            String url1="[0-9]{2,3}+\s[a-zA-Z]{0,}";
            String day="[A-Z]{2,4}";
            String time123="[0-9]{2,2}+\\:[0-9]{2,2}+\\:[0-9]{2,2}";
            String url = jTextField4.getText();
            String days = jTextField5.getText();
            String time = jTextField3.getText();
            if(!url.isEmpty() && !days.isEmpty() && !time.isEmpty()){
                if(!url.matches(url1)){
                    JOptionPane.showMessageDialog(null, "Nhập sai location");

                }
                if(!days.matches(day)){
                    JOptionPane.showMessageDialog(null, "Nhập sai days");            
                }
                if(!time.matches(time123)){
                    JOptionPane.showMessageDialog(null, "Nhập sai time");            
                }
                else{
                    boolean flag = spq.them(CourseID, url,days,time);
                    spq.docListonl();
                    Load();
                    Empty();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Không được để rỗng");  
                spq.docListonl();
                    Load();
                    Empty();
            }
        }
        
        
        
        
    }
    private void xuLyXoa() {
        String CourseID = (String) jComboBox1.getSelectedItem();
        
        int vitri=-1;
        DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
        DFT.setRowCount(0);
        for (OnsiteDTO nv : spq.TimKiem(CourseID)) {
            if(nv.getCourseID().equalsIgnoreCase(CourseID)){               
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
           boolean flag = spq.xoa(CourseID);   
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
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        jPanel1.setPreferredSize(new java.awt.Dimension(730, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("ONSITE COURSE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Course ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Time");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 150, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course ID", "Location", "Days", "Time"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 330, 400));

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
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 102, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Location");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 102, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Days");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 102, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1045", "1061", "2021", "4061", "4041", "3141", "1050", "2030", "2042", "4022" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 102, -1));

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        xuLyThem();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        xuLySua();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        xuLyXoa();
        Load();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String CourseID = jTextField2.getText();
        if(CourseID.isEmpty()){
            Load();
        }
        else if(!CourseID.isEmpty()){
            Load3();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        jTextField4.setText(model.getValueAt(row,1).toString());
        jTextField5.setText(model.getValueAt(row,2).toString());
        jTextField3.setText(model.getValueAt(row,3).toString());
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
