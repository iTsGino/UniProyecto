
package Vista;

import Controlador.NegocioUsuario;
import Modelo.ClaseUsuario;
import javax.swing.JOptionPane;

public class FrmPrincipal extends javax.swing.JFrame {
    
    ClaseUsuario Cu = new ClaseUsuario();
    NegocioUsuario Obj = new NegocioUsuario();
    
    public FrmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
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
            System.out.println("Bienvenido, "+Cu.getNomUsu());
            fr.setVisible(true);
            
        } else {
            LblAle.setText("¡Hubo un Problema con su Inicio de Sesión!");
        }
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
        btnReg = new javax.swing.JButton();
        LblAle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        LblUsu.setText(" USUARIO:");
        jPanel1.add(LblUsu);
        jPanel1.add(txtUsu);

        LblPas.setText(" CONTRASEÑA:");
        jPanel1.add(LblPas);
        jPanel1.add(txtPas);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, 340, 100));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGENCIA DE VIAJES");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 220, 40));

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        btnIng.setText("INGRESAR");
        btnIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngActionPerformed(evt);
            }
        });
        jPanel2.add(btnIng);
        jPanel2.add(jLabel2);

        btnReg.setText("REGISTRAR");
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });
        jPanel2.add(btnReg);

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 205, 310, 60));

        LblAle.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(LblAle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 230, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngActionPerformed
        LeerDatos();
        Limpia();
    }//GEN-LAST:event_btnIngActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblAle;
    private javax.swing.JLabel LblPas;
    private javax.swing.JLabel LblUsu;
    private javax.swing.JButton btnIng;
    private javax.swing.JButton btnReg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField txtPas;
    private javax.swing.JTextField txtUsu;
    // End of variables declaration//GEN-END:variables
}
