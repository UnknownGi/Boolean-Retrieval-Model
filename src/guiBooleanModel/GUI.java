package guiBooleanModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {
    String[] array;
    
    private static Tokenizer t = new Tokenizer();
    private static QueryHandler q = new QueryHandler();
    private static BooleanModel bm = new BooleanModel();
    private static InvertedIndex ii = new InvertedIndex();
    private static PositionalIndex pi = new PositionalIndex();
    private static ArrayList<String> query = new ArrayList<String>();
    private static ArrayList<String> collection = new ArrayList<String>();
    
    public GUI() throws FileNotFoundException {
        query = bm.fetchQuery();
        
        array = new String[query.size()];
        for ( int i=0; i<query.size(); ++i ) array[i] = query.get(i);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(475, 400));
        setResizable(false);

        jButton1.setText("Fetch Documents");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Construct Indexes");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Open Inverted Index");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Open Positional Index");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jLabel1.setText("Boolean Retrieval Model");

        jButton5.setText("Phrase Query Search");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(array));

        jButton6.setText("Search");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(176, 176, 176))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField1))
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Fetch Documents Clicked!
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ResultTextPanel rtp = new ResultTextPanel(null, collection);
        rtp.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    // Construct Indexes Clicked!
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
    }//GEN-LAST:event_jButton2MouseClicked

    // Open Positional Index!
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try {
            ii.OpenFile();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    // Open Inverted Index!
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        try {
            pi.OpenFile();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4MouseClicked

    // Search For Phrase Queries
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        String sQuery = jTextField1.getText();
        ArrayList<Integer> result = q.processPhrase(sQuery, ii, collection);
        
        if ( result.size() > 0 ) {
            ResultTextPanel rtp = new ResultTextPanel(result, collection);
            rtp.setVisible(true);
            JOptionPane.showMessageDialog(null, result.size() + " Documents Fetched!");
        } else JOptionPane.showMessageDialog(null, "No Results For Such Phrase Query!");
    }//GEN-LAST:event_jButton5MouseClicked

    // Search For Boolean or Proximity Queries
    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        String sQuery = (String) jComboBox1.getSelectedItem();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if ( sQuery.contains("/") ) result = q.processProximity(sQuery, pi, collection); 
        else result = q.processBoolean(sQuery, ii, collection);
        
        if ( result.size() > 0 ) {
            ResultTextPanel rtp = new ResultTextPanel(result, collection);
            rtp.setVisible(true);
            JOptionPane.showMessageDialog(null, result.size() + " Documents Fetched!");
        } else JOptionPane.showMessageDialog(null, "No Results Exist For Such Query!");
    }//GEN-LAST:event_jButton6MouseClicked
    
    
    public static void main(String args[]) throws IOException {
        if ( collection.isEmpty() ) {
            try {
                collection = bm.fetchDocuments();
                
                ii = ii.constructIndex(bm, collection, t);
                
                File file = new File("dataset/Inverted-Index.txt");
                if ( !file.exists() ) ii.writeIndexToFile();
                
                pi = pi.constructIndex(bm, collection, t);
                
                file = new File("dataset/Positional-Index.txt");
                if ( !file.exists() ) pi.writeIndexToFile();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                    JOptionPane.showMessageDialog(null, collection.size() + " Documents Retrieved!");
                    JOptionPane.showMessageDialog(null, "Inverted and Positional Index Constructed!");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
