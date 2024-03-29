/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orpheusclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class AlbumGUI extends javax.swing.JFrame {

    /**
     * Creates new form AlbumGUI
     */
    
    
    private static AlbumGUI l= createInstance();
    private Album a;
    private User u;
    public static AlbumGUI getInstance(){
        return l;
    }
    
    private static AlbumGUI createInstance(){
        AlbumGUI l=null;
        try {
            l= new AlbumGUI();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(l);
            l.pack();
            l.setVisible(true);
            l.setResizable(false);
        
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
        
    }
    
    private AlbumGUI() {
        initComponents();
    }
    
    public void setAlbum(Album a){
        this.a=a;
        updateView();
    }
    public void setUser(User u){
        this.u=u;
    }
    private void updateView(){
        this.labelAlbum.setText("Album: "+a.getNamaAlbum());
        this.labelArtist.setText("Artist : "+a.getArtist());
        this.labelHarga.setText("Harga: $"+a.getHarga());
        this.labelTgl.setText("Tanggal Rilis: "+a.getTgl_rilis());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butBuy = new javax.swing.JToggleButton();
        labelAlbum = new javax.swing.JLabel();
        labelArtist = new javax.swing.JLabel();
        labelHarga = new javax.swing.JLabel();
        labelTgl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        butBuy.setText("BUY");
        butBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuyActionPerformed(evt);
            }
        });

        labelAlbum.setText("Album:");

        labelArtist.setText("Artist:");

        labelHarga.setText("Harga: ");

        labelTgl.setText("Tanggal Rilis :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAlbum)
                            .addComponent(labelArtist)
                            .addComponent(labelHarga)
                            .addComponent(labelTgl)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(butBuy)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelArtist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelHarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTgl)
                .addGap(18, 18, 18)
                .addComponent(butBuy)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuyActionPerformed
        Client c = Client.getInstance();
        c.sendData("USERBUY "+a.getId_album()+" "+u.getEmail());
        int val = JOptionPane.showConfirmDialog(this, "Apakah anda ingin download sekarang?");
        if (val==JOptionPane.OK_OPTION){
            Downloading d = new Downloading();
            d.setVisible(true);
            d.setAlbum(a);
            d.setUser(u);
            d.startDownload();
            this.dispose();
        }
    }//GEN-LAST:event_butBuyActionPerformed

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
            java.util.logging.Logger.getLogger(AlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlbumGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlbumGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton butBuy;
    private javax.swing.JLabel labelAlbum;
    private javax.swing.JLabel labelArtist;
    private javax.swing.JLabel labelHarga;
    private javax.swing.JLabel labelTgl;
    // End of variables declaration//GEN-END:variables
}
