/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SearchController;
import Model.Room;
import javax.swing.JFrame;

/**
 *
 * @author Notandi
 */
public class SearchForm extends javax.swing.JFrame {

    boolean checkBoxes[];
    private SearchController search;
    /**
     * Creates new form SearchController
     */
    public SearchForm() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSearch = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jCheckBoxWiFi = new javax.swing.JCheckBox();
        jCheckBoxMorgunmatur = new javax.swing.JCheckBox();
        searchButton = new javax.swing.JButton();
        jCheckBoxMidbae = new javax.swing.JCheckBox();
        jCheckBoxTv = new javax.swing.JCheckBox();
        jCheckBoxSturta = new javax.swing.JCheckBox();
        jCheckBoxAirport = new javax.swing.JCheckBox();
        jCheckBoxSpa = new javax.swing.JCheckBox();
        jCheckBoxLikamsraekt = new javax.swing.JCheckBox();
        jCheckBoxGonguleid = new javax.swing.JCheckBox();
        jCheckBoxFotlun = new javax.swing.JCheckBox();
        jButtonInnskraning = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelSearch.setText("Hotel name:");

        jCheckBoxWiFi.setText("Frítt wi-fi");

        jCheckBoxMorgunmatur.setText("Morgunmatur innifalinn");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jCheckBoxMidbae.setText("Nálægt miðbæ");

        jCheckBoxTv.setText("Tv");

        jCheckBoxSturta.setText("Sturta");

        jCheckBoxAirport.setText("Airport pickup/drop off");

        jCheckBoxSpa.setText("Spa");

        jCheckBoxLikamsraekt.setText("Líkamsrækt");

        jCheckBoxGonguleid.setText("Göngu/Hjólaleiðir");

        jCheckBoxFotlun.setText("Aðstaða fyrir fólk með fötlun");

        jButtonInnskraning.setText("Innskráning");
        jButtonInnskraning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInnskraningActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0-24", "25-49", "50-74", "75-99", "100+" }));

        jLabel1.setText("Room size:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxFotlun)
                            .addComponent(searchButton))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBoxAirport)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelSearch)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jCheckBoxLikamsraekt)
                                .addComponent(jCheckBoxWiFi)
                                .addComponent(jCheckBoxGonguleid)))
                        .addGap(59, 59, 59)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxMorgunmatur)
                    .addComponent(jCheckBoxSpa)
                    .addComponent(jCheckBoxSturta)
                    .addComponent(jCheckBoxTv)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonInnskraning)
                        .addComponent(jCheckBoxMidbae)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSearch)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxFotlun)
                    .addComponent(jCheckBoxMorgunmatur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxAirport)
                    .addComponent(jCheckBoxMidbae))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxSpa)
                    .addComponent(jCheckBoxWiFi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxGonguleid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxLikamsraekt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxSturta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTv)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(jButtonInnskraning))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        checkBoxes = new boolean[] {
            jCheckBoxFotlun.isSelected(), jCheckBoxAirport.isSelected(), jCheckBoxWiFi.isSelected(), jCheckBoxGonguleid.isSelected(), jCheckBoxLikamsraekt.isSelected(), 
            jCheckBoxMorgunmatur.isSelected(), jCheckBoxMidbae.isSelected(), jCheckBoxSpa.isSelected(), jCheckBoxSturta.isSelected(), jCheckBoxTv.isSelected()
        };       
        String searchString = jTextFieldSearch.getText();
        search = new SearchController();
        Room[] room = SearchController.search(checkBoxes, searchString);
        showRooms(room);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void jButtonInnskraningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInnskraningActionPerformed
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
        lf.pack();
        lf.setLocationRelativeTo(null);
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButtonInnskraningActionPerformed
    
    private void showRooms(Room[] room) {
        for(int i = 0; i < room.length; i++) {
            System.out.print(room[i].getRoomid() + ", ");
        }
    }
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
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInnskraning;
    private javax.swing.JCheckBox jCheckBoxAirport;
    private javax.swing.JCheckBox jCheckBoxFotlun;
    private javax.swing.JCheckBox jCheckBoxGonguleid;
    private javax.swing.JCheckBox jCheckBoxLikamsraekt;
    private javax.swing.JCheckBox jCheckBoxMidbae;
    private javax.swing.JCheckBox jCheckBoxMorgunmatur;
    private javax.swing.JCheckBox jCheckBoxSpa;
    private javax.swing.JCheckBox jCheckBoxSturta;
    private javax.swing.JCheckBox jCheckBoxTv;
    private javax.swing.JCheckBox jCheckBoxWiFi;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables


}
