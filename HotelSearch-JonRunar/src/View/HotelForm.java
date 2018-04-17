package View;

import Model.Hotel;
import Model.Room;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
public final class HotelForm extends javax.swing.JFrame {
    private static ArrayList<Room> herbergi;
    private static ArrayList<Hotel> hotel;
    private static ArrayList<Date> dates;
    private static int userId;
    private int sida;
    private static Hotel theHotel;
    /**
     * Creates new form HotelForm
     * @param room
     * @param hotel
     * @param dates
     * @throws java.io.IOException
     */

    public HotelForm(ArrayList<Room> room, ArrayList<Hotel> hotel, ArrayList<Date> dates, int userId) throws IOException {

        initComponents();
        HotelForm.userId = userId;
        HotelForm.herbergi = room;
        HotelForm.hotel = hotel;
        HotelForm.dates = dates;
        sida = 1;
        HotelForm.theHotel = hotel.get(sida-1);
        stillaSidu();
        fyrra.setEnabled(false);
    }
    
    public void stillaSidu() throws IOException {
        if(hotel == null) throw new IllegalArgumentException("Upphafstilla þarf hótel!");
        else {
            theHotel = HotelForm.hotel.get(sida-1);  
            
            if(sida>hotel.size()) {
                sida = sida-hotel.size();
            }
            if(sida == 0) {
                sida = hotel.size();
            }
            if(sida==1) {
                fyrra.setEnabled(false);
            }   
            if(sida==hotel.size()) {
                naesta.setEnabled(false);
            }
            if(sida==2) {
                fyrra.setEnabled(true);
            }
            if(sida==hotel.size()-1) {
                naesta.setEnabled(true);
            }
            stillaConv();
            stillaMynd();
            stillaNafn();
            stillaStjornur();
            stillaStads();
            stillaNR();
            stillaAvailableRooms();
        
    }
    private void stillaNR() {
        stadsSida.setText(sida + "/" + hotel.size());
    }
    
    private void stillaMynd() throws MalformedURLException, IOException {
        Hotel theHotel = hotel.get(sida-1);
        String photo = theHotel.getPhoto_URL();
        URL url = new URL(photo);
        Image image = ImageIO.read(url);
        myndLabel.setIcon(new ImageIcon(image));
    }
    
    private void stillaStads() {
        Hotel theHotel = hotel.get(sida-1);
        String stads = theHotel.getLocation();
        nafnStadsetning.setText(stads);
    }
    
    private void stillaStjornur() {
        int stars = theHotel.getStars();
        switch (stars) {
            case 1:
                hotelStjornur.setText("*");
                break;
            case 2:
                hotelStjornur.setText("**");
                break;
            case 3:
                hotelStjornur.setText("***");
                break;
            case 4:
                hotelStjornur.setText("****");
                break;
            case 5:
                hotelStjornur.setText("*****");
                break;
            default:
                break;
        }
    }
    
    private void stillaNafn() {
        String name = theHotel.getName();
        heitiHotel.setText(name);
    }
    
    private void stillaConv() {
        System.out.print(hotel.size());
        String[] convinience = theHotel.getConveniences();
        for(int i = 0; i < convinience.length; i++) {
            switch (i) {
                case 0:
                    conv0.setText(convinience[i]);
                    break;
                case 1:
                    conv1.setText(convinience[i]);
                    break;
                case 2:
                    conv2.setText(convinience[i]);
                    break;
                case 3:
                    conv3.setText(convinience[i]);
                    break;
                case 4:
                    conv4.setText(convinience[i]);
                    break;
                case 5:
                    conv5.setText(convinience[i]);
                    break;
                case 6:
                    conv6.setText(convinience[i]); 
                    break;
                case 7:
                    conv7.setText(convinience[i]);
                    break;
                case 8:
                    conv8.setText(convinience[i]);
                    break;
                case 9:
                    conv9.setText(convinience[i]);
                    break;
                default:
                    break;
            }
        }
        for(int i = 0; i < (10-convinience.length); i++) {
            switch (i) {
                case 0:
                    conv9.setText("");
                    break;
                case 1:
                    conv8.setText("");
                    break;
                case 2:
                    conv7.setText("");
                    break;
                case 3:
                    conv6.setText("");
                    break;
                case 4:
                    conv5.setText("");
                    break;
                case 5:
                    conv4.setText("");
                    break;
                case 6:
                    conv3.setText("");
                    break;
                case 7:
                    conv2.setText("");
                    break;
                case 8:
                    conv1.setText("");
                    break;
                case 9:
                    conv0.setText("");
                    break;
                default:
                    break;
            }
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
        heitiHotel = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        skodaHerb = new javax.swing.JButton();
        stadsSida = new javax.swing.JLabel();
        haettaVid = new javax.swing.JButton();
        fyrra = new javax.swing.JButton();
        naesta = new javax.swing.JButton();
        stadsetning = new javax.swing.JLabel();
        nafnStadsetning = new javax.swing.JLabel();
        myndLabel = new javax.swing.JLabel();
        conv1 = new javax.swing.JLabel();
        conv0 = new javax.swing.JLabel();
        conv = new javax.swing.JLabel();
        conv3 = new javax.swing.JLabel();
        conv4 = new javax.swing.JLabel();
        conv2 = new javax.swing.JLabel();
        conv6 = new javax.swing.JLabel();
        conv7 = new javax.swing.JLabel();
        conv8 = new javax.swing.JLabel();
        stjornur = new javax.swing.JLabel();
        hotelStjornur = new javax.swing.JLabel();
        conv9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        RoomsNumber = new javax.swing.JLabel();
        conv5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(75, 119, 190));

        heitiHotel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        heitiHotel.setForeground(new java.awt.Color(255, 255, 255));
        heitiHotel.setText("heitiHotel");

        jLabelExit.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabelExit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelExit.setText("X");
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });

        jLabelMin.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText("-");
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(heitiHotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelExit)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(heitiHotel)
                    .addComponent(jLabelExit)
                    .addComponent(jLabelMin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(228, 241, 254));

        skodaHerb.setText("Look at rooms");
        skodaHerb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skodaHerbActionPerformed(evt);
            }
        });

        stadsSida.setText("3/4");

        haettaVid.setText("Cancel");
        haettaVid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                haettaVidActionPerformed(evt);
            }
        });

        fyrra.setText("Previous");
        fyrra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fyrraActionPerformed(evt);
            }
        });

        naesta.setText("Next");
        naesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naestanaestButton(evt);
            }
        });

        stadsetning.setText("Location:");

        nafnStadsetning.setText("nafnStadsetning");

        conv1.setText("2");

        conv0.setText("1");

        conv.setText("Conveniences:");

        conv3.setText("4");

        conv4.setText("5");

        conv2.setText("3");

        conv6.setText("7");

        conv7.setText("8");

        conv8.setText("9");

        stjornur.setText("Stars:");

        hotelStjornur.setText("hotelStjornur");

        jLabel1.setText("Available rooms:");

        RoomsNumber.setText("number");

        conv5.setText("6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(myndLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(stadsetning)
                                        .addComponent(stjornur))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nafnStadsetning)
                                        .addComponent(hotelStjornur))
                                    .addGap(86, 86, 86))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(conv0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(conv1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(conv2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(conv9))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(conv4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(conv5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(conv6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(conv7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(conv8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGap(89, 89, 89)
                                            .addComponent(conv3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(113, 113, 113)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(conv)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(stadsSida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skodaHerb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(haettaVid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(fyrra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(naesta)
                        .addContainerGap(9, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RoomsNumber)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(myndLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nafnStadsetning)
                            .addComponent(stadsetning))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stjornur)
                            .addComponent(hotelStjornur))
                        .addGap(20, 20, 20)
                        .addComponent(conv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conv0)
                            .addComponent(conv3)
                            .addComponent(conv1))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conv2)
                            .addComponent(conv4)
                            .addComponent(conv5)
                            .addComponent(conv6))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conv7)
                            .addComponent(conv8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(myndLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(RoomsNumber))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skodaHerb)
                    .addComponent(stadsSida)
                    .addComponent(haettaVid)
                    .addComponent(fyrra)
                    .addComponent(naesta))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void naestanaestButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naestanaestButton
        try {
            // TODO add your handling code here:
            naestaSida();
        } catch (IOException ex) {
            Logger.getLogger(HotelForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_naestanaestButton

    private void fyrraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fyrraActionPerformed
        try {
            // TODO add your handling code here:
            fyrriSida();
        } catch (IOException ex) {
            Logger.getLogger(HotelForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fyrraActionPerformed

    private void haettaVidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_haettaVidActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_haettaVidActionPerformed

    private void skodaHerbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skodaHerbActionPerformed
        ArrayList<Room> theHotelRooms = new ArrayList<>();
        for(int i = 0; i < herbergi.size(); i++) {
            if( theHotel.getHotelId() == herbergi.get(i).getHotel().getHotelId()) {
                theHotelRooms.add(herbergi.get(i));
            }
        }
        RoomForm rf = new RoomForm(theHotelRooms, theHotel, dates, userId);
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_skodaHerbActionPerformed

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

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
            java.util.logging.Logger.getLogger(HotelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HotelForm(herbergi, hotel, dates, userId).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(HotelForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RoomsNumber;
    private javax.swing.JLabel conv;
    private javax.swing.JLabel conv0;
    private javax.swing.JLabel conv1;
    private javax.swing.JLabel conv2;
    private javax.swing.JLabel conv3;
    private javax.swing.JLabel conv4;
    private javax.swing.JLabel conv5;
    private javax.swing.JLabel conv6;
    private javax.swing.JLabel conv7;
    private javax.swing.JLabel conv8;
    private javax.swing.JLabel conv9;
    private javax.swing.JButton fyrra;
    private javax.swing.JButton haettaVid;
    private javax.swing.JLabel heitiHotel;
    private javax.swing.JLabel hotelStjornur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel myndLabel;
    private javax.swing.JButton naesta;
    private javax.swing.JLabel nafnStadsetning;
    private javax.swing.JButton skodaHerb;
    private javax.swing.JLabel stadsSida;
    private javax.swing.JLabel stadsetning;
    private javax.swing.JLabel stjornur;
    // End of variables declaration//GEN-END:variables

      private void naestaSida() throws IOException {
        sida++;
        hreinsaSidu();
        stillaSidu();
    }

    private void fyrriSida() throws IOException {
        sida--;
        hreinsaSidu();
        stillaSidu();
    }
    
    private void hreinsaSidu() {
        conv0.setText("");
        conv1.setText("");
        conv2.setText("");
        conv3.setText("");
        conv4.setText("");
        conv5.setText("");
        conv6.setText("");
        conv7.setText("");
        conv8.setText("");
        conv9.setText("");
        hotelStjornur.setText("");
        RoomsNumber.setText("");
        nafnStadsetning.setText("");
        
    }

    private void stillaAvailableRooms() {
        int roomNumber = 0;
        for(int i = 0; i < herbergi.size(); i++) {
            if (theHotel.getHotelId() == herbergi.get(i).getHotel().getHotelId()) {
                roomNumber++;
            }
        }
        
        RoomsNumber.setText(Integer.toString(roomNumber));
    }

}