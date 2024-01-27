
import java.awt.Image;
import java.io.File;
import javax.swing.*;


public class usersignup extends javax.swing.JFrame {
    JFileChooser jfc;
    File ph;

    
    public usersignup() {
        jfc = new JFileChooser();
        
        initComponents();
         lb.setVisible(false);
        tf.setVisible(false);
        verify.setVisible(false);
        setSize(600,600);
        
        ImageIcon ic = new ImageIcon("src/photos/login_background3.jpg");
        Image im = ic.getImage().getScaledInstance(background.getWidth(),background.getHeight(), Image.SCALE_SMOOTH);
        background.setIcon(new ImageIcon(im));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pf = new javax.swing.JPasswordField();
        mobile = new javax.swing.JTextField();
        preview = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();
        verify = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 100, 90, 24);

        jLabel3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 136, 90, 20);

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Mobile");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 190, 90, 24);

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Address");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 260, 90, 24);

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("Photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 340, 90, 24);
        getContentPane().add(email1);
        email1.setBounds(140, 90, 230, 30);

        jButton1.setText("Choose Photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(300, 340, 110, 23);

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 510, 110, 40);
        getContentPane().add(pf);
        pf.setBounds(140, 130, 230, 30);

        mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileActionPerformed(evt);
            }
        });
        getContentPane().add(mobile);
        mobile.setBounds(140, 180, 230, 30);
        getContentPane().add(preview);
        preview.setBounds(170, 310, 110, 100);

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        getContentPane().add(address);
        address.setBounds(140, 240, 230, 40);

        lb.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        lb.setForeground(new java.awt.Color(204, 255, 204));
        lb.setText("Enter OTP sent to your mail");
        getContentPane().add(lb);
        lb.setBounds(10, 450, 260, 24);
        getContentPane().add(tf);
        tf.setBounds(240, 450, 150, 22);

        verify.setBackground(new java.awt.Color(204, 255, 204));
        verify.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        verify.setForeground(new java.awt.Color(102, 102, 102));
        verify.setText("Verify");
        verify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyActionPerformed(evt);
            }
        });
        getContentPane().add(verify);
        verify.setBounds(190, 510, 110, 40);
        getContentPane().add(background);
        background.setBounds(0, 0, 600, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String email = email1.getText();
       String password = pf.getText();
       String phone = mobile.getText();
       String add = address.getText();
       if(email.equals("")||password.equals("")||phone.equals("")||add.equals("")||ph==null)
       {
           JOptionPane.showMessageDialog(rootPane, "All Fields are Mandatory");
       }
        else
        {
            String ans = myClient.otpsend(email,  phone);
            if(ans.equals("exists"))   
         {
              JOptionPane.showMessageDialog(rootPane, "Email already Taken!");
            
         }
         else if(ans.equals("mobile"))
         {
             JOptionPane.showMessageDialog(rootPane, "Mobile Number is invalid or already taken");
         }
         else 
         {
            lb.setVisible(true);
            tf.setVisible(true);
            jButton2.setVisible(false);
            verify.setVisible(true);
        }
        }
       
       userlogin obj1 = new userlogin();
       obj1.setVisible(true);
       dispose();
       
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        int ans = jfc.showOpenDialog(this);
        if(ans== JFileChooser.APPROVE_OPTION)
        {
            ph=jfc.getSelectedFile();
            
            ImageIcon ic = new ImageIcon(ph.getPath());
            Image img = ic.getImage().getScaledInstance(preview.getWidth(),preview.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            preview.setIcon(ic1);
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyActionPerformed
        String email = email1.getText();
       String password = pf.getText();
       String phone = mobile.getText();
       String add = address.getText();
       String uotp = tf.getText();
       
       String ans1 = myClient.usersignup(email, password, phone, add,uotp,ph);
        
            if(ans1.equals("success"))
         {
             JOptionPane.showMessageDialog(rootPane, "Signup Success");
             
         }
         else
         {
              JOptionPane.showMessageDialog(rootPane, "Signup Failed");
            
         }
    }//GEN-LAST:event_verifyActionPerformed

   
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
            java.util.logging.Logger.getLogger(usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usersignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usersignup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel background;
    private javax.swing.JTextField email1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb;
    private javax.swing.JTextField mobile;
    private javax.swing.JPasswordField pf;
    private javax.swing.JLabel preview;
    private javax.swing.JTextField tf;
    private javax.swing.JButton verify;
    // End of variables declaration//GEN-END:variables
}
