/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kbcgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DEEPAK
 */
public class EditUser extends javax.swing.JFrame {

    String clicked_email;
    
    /**
     * Creates new form EditUser
     */
    public EditUser() {
        initComponents();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S No", "Email ID", "Name", "Password", "Gender", "City"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 19, 552, 328));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 35, -1, -1));

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 82, -1, -1));

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Gender");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 136, -1, -1));

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("City");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 191, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 32, 173, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 82, 173, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 136, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(831, 136, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Delhi", "Noida", "Faridabad", "Gurgaon", "Chandigarh", "Nalagarh", "Hisar" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(728, 188, -1, -1));

        jButton1.setText("Update User");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 408, -1, -1));

        jButton2.setText("Delete User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 408, -1, -1));

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 408, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Home\\Documents\\NetBeansProjects\\KBC mysql\\src\\images\\hee.jpg")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 550));

        setSize(new java.awt.Dimension(1036, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        String email1;
        String name1;
        String password1;
        String gender1;
        String city1;
        
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        
        int sno=0;
        try
        {
            Connection con=DbConnectivity.connect();
            PreparedStatement ps=con.prepareStatement("select * from KBC_REGISTRATION");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                sno=sno+1;
                email1=rs.getString("EMAIL_ID");
                name1=rs.getString("NAME");
                password1=rs.getString("PASSWORD");
                gender1=rs.getString("GENDER");
                city1=rs.getString("CITY");
                dtm.addRow(new Object[]{sno,email1, name1, password1, gender1, city1});
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
        try
        {
            int row=jTable1.getSelectedRow();
            clicked_email=(jTable1.getModel().getValueAt(row, 1).toString());
            
            
            String name11=null;
            String gender11=null;
            String password11=null;
            String city11=null;
            
            Connection con=DbConnectivity.connect();
            PreparedStatement ps=con.prepareStatement("select * from KBC_REGISTRATION where EMAIL_ID='"+clicked_email+"'");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                    name11=rs.getString("NAME");
                    password11=rs.getString("PASSWORD");
                    gender11=rs.getString("GENDER");
                    city11=rs.getString("CITY");
            }
            
            jTextField1.setText(name11);
            jTextField2.setText(password11);
            if(gender11.equals("Male"))
            {
                jRadioButton1.setSelected(true);
            }
            if(gender11.equals("Female"))
            {
                jRadioButton2.setSelected(true);
            }
            jComboBox1.setSelectedItem(city11);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String name=jTextField1.getText();
        String password=jTextField2.getText();
        String gender="";
        if(jRadioButton1.isSelected())
        {
            gender="Male";
        }
        if(jRadioButton2.isSelected())
        {
            gender="Female";
        }
        String city=(String)jComboBox1.getSelectedItem();
        
        try
        {
            Connection con=DbConnectivity.connect();
            PreparedStatement ps=con.prepareStatement("update KBC_REGISTRATION set NAME='"+name+"', PASSWORD='"+password+"', GENDER='"+gender+"', CITY='"+city+"' where EMAIL_ID='"+clicked_email+"'");
            int i=ps.executeUpdate();
            
            if(i>0)
            {
                JOptionPane.showMessageDialog(this, "User updated successfully");
                
                EditUser eu=new EditUser();
                eu.setVisible(true);
                setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "User not updated due to some error");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try
        {
            Connection con=DbConnectivity.connect();
            PreparedStatement ps=con.prepareStatement("delete from KBC_REGISTRATION where EMAIL_ID='"+clicked_email+"'");
            int i=ps.executeUpdate();
            
            if(i>0)
            {
                JOptionPane.showMessageDialog(this, "User deleted successfully");
                
                EditUser eu=new EditUser();
                eu.setVisible(true);
                setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "User not deleted due to some error");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        AdminPanel ap=new AdminPanel();
        ap.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditUser().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
