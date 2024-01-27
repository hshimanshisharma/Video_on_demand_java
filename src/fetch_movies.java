
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Himanshi
 */
public class fetch_movies extends javax.swing.JFrame {

    /**
     * Creates new form fetch_movies
     */
    String catname;
    public fetch_movies(String name) {
        initComponents();
        setSize(850,500);
        catname=name;
        loadmovies();
        
        
    }
    
    void loadmovies()
    {
        heading.setText(catname);
         mainpanel.removeAll();
        mainpanel.repaint();
        if(tf.getText().equals(""))
        {
        String ans = myClient.fetchmovies(catname);
        System.out.println("--->"+ans);
        StringTokenizer st = new StringTokenizer(ans,";;");
        int n= st.countTokens();
        JButton arr[] = new JButton[n];
        JLabel arr1[]=new JLabel[n];
        int x=10,y=50;
        int k=20,j=260;
        for(int i=0 ;i<n;i++)
        {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(st1.nextToken());
            String mname = st1.nextToken();
            String photo = st1.nextToken();
             arr[i] = new JButton(mname);
             arr1[i]=new JLabel(mname);
             
             arr[i].setBounds(x, y, 250, 200);
             arr1[i].setBounds(k, j, 250, 50);
             
             ImageIcon ic = new ImageIcon(photo);
            Image img = ic.getImage().getScaledInstance(255,196,Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            arr[i].setIcon(ic1);
             
             arr[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                  movie_detail obj = new movie_detail(id);
                  obj.setVisible(true);
                  dispose();
                }
            });
             
             mainpanel.add(arr[i]);
             mainpanel.add(arr1[i]);
             mainpanel.repaint();
            if(x<=780)
            {
                  x = x+260;
                  k=k+270;
            }
            else
            {
                x=10;
                k=10;
                j=j+270;
                y=y+270;
            }
        }
        
        mainpanel.setPreferredSize(new Dimension(790,n*80));
        }
        
        else
        {
           mainpanel.removeAll();
        mainpanel.repaint();
        System.out.println("text----"+tf.getText());
        String ans = myClient.search(tf.getText());
            
        System.out.println("--->"+ans);
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        int n = st.countTokens();
        
        JButton arr[] = new JButton[n];
        JLabel arr1[]=new JLabel[n];
        
        int x=10,y=50;
        int k=20,j=260;
        
        for (int i = 0; i < n; i++) 
        {
            String row = st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            String photo = st1.nextToken();
            
            
           arr[i] = new JButton(name);
             arr1[i]=new JLabel(name);
             
             arr[i].setBounds(x, y, 250, 200);
             arr1[i].setBounds(k, j, 250, 50);
            
          ImageIcon ic = new ImageIcon(photo);
            Image img = ic.getImage().getScaledInstance(255,196,Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            arr[i].setIcon(ic1);
          
          
         
         arr[i].addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                  movie_detail obj = new movie_detail(id);
                  obj.setVisible(true);
                  dispose();
                }
            });
          
          
          mainpanel.add(arr[i]);
             mainpanel.add(arr1[i]);
             mainpanel.repaint();
            if(x<=780)
            {
                  x = x+260;
                  k=k+270;
            }
            else
            {
                x=10;
                k=10;
                j=j+270;
                y=y+270;
            }
        }
        
        mainpanel.setPreferredSize(new Dimension(790,n*80));
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

        searchbt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(-3, 48, 850, 450);

        heading.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(heading);
        heading.setBounds(20, 10, 390, 30);

        tf.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                tfCaretUpdate(evt);
            }
        });
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        getContentPane().add(tf);
        tf.setBounds(450, 10, 380, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_tfCaretUpdate
        // TODO add your handling code here:
         loadmovies();
    }//GEN-LAST:event_tfCaretUpdate

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

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
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fetch_movies.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new fetch_movies("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton searchbt;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
}
