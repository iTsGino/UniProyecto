
package Vista;

import Controlador.NegocioUsuario;
import Modelo.ClaseUsuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmLogueo extends javax.swing.JFrame {
    
    ClaseUsuario Cu = new ClaseUsuario();
    NegocioUsuario Obj = new NegocioUsuario();
    
    public FrmLogueo() {
        initComponents();
        setLocationRelativeTo(null);
        MuestraImagen();
    }
    
    public String Usuario(){
        return txtUsu.getText();
    }
    public String Password(){
        return txtPas.getText();
    }
    public void LeerDatos(){
        FrmRutas fr = new FrmRutas();
        Cu.setUsu(Usuario());
        Cu.setPasUsu(Password());
        int Res = Obj.GetUsuario(Cu);
        if(Res == 1){
            System.out.println("Bienvenido, "+Cu.getUsu());
            fr.setVisible(true);
            dispose();
        } else {
            LblAle.setText("¡Hubo un Problema con su Inicio de Sesión!");
        }
    }
    public void MuestraImagen(){
        ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/Login.jpg"));
        Image Tam = Img.getImage().getScaledInstance(txtImg.getWidth(), txtImg.getHeight(), Image.SCALE_SMOOTH);
        txtImg.setIcon(new ImageIcon(Tam));
    }
    public void Limpia(){
        txtUsu.setText("");
        txtPas.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        LblUsu = new javax.swing.JLabel();
        txtUsu = new javax.swing.JTextField();
        LblPas = new javax.swing.JLabel();
        txtPas = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnIng = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSal = new javax.swing.JButton();
        LblAle = new javax.swing.JLabel();
        txtImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(240, 255, 253));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 255, 253));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        LblUsu.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        LblUsu.setText(" USUARIO:");
        jPanel1.add(LblUsu);
        jPanel1.add(txtUsu);

        LblPas.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        LblPas.setText(" CONTRASEÑA:");
        jPanel1.add(LblPas);
        jPanel1.add(txtPas);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 310, 100));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGENCIA DE VIAJES");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 220, 40));

        jPanel2.setBackground(new java.awt.Color(240, 255, 253));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        btnIng.setBackground(new java.awt.Color(204, 204, 204));
        btnIng.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnIng.setForeground(new java.awt.Color(51, 51, 255));
        btnIng.setText("INGRESAR");
        btnIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngActionPerformed(evt);
            }
        });
        jPanel2.add(btnIng);
        jPanel2.add(jLabel2);

        btnSal.setBackground(new java.awt.Color(204, 204, 204));
        btnSal.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnSal.setForeground(new java.awt.Color(51, 51, 255));
        btnSal.setText("SALIR");
        btnSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalActionPerformed(evt);
            }
        });
        jPanel2.add(btnSal);

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 310, 50));

        LblAle.setFont(new java.awt.Font("Bodoni MT", 0, 13)); // NOI18N
        LblAle.setForeground(new java.awt.Color(255, 51, 51));
        LblAle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(LblAle, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 270, 30));

        txtImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.add(txtImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 150, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngActionPerformed
        LeerDatos();
        Limpia();
    }//GEN-LAST:event_btnIngActionPerformed

    private void btnSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblAle;
    private javax.swing.JLabel LblPas;
    private javax.swing.JLabel LblUsu;
    private javax.swing.JButton btnIng;
    private javax.swing.JButton btnSal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtImg;
    private javax.swing.JPasswordField txtPas;
    private javax.swing.JTextField txtUsu;
    // End of variables declaration//GEN-END:variables
}
