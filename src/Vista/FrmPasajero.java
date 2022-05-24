
package Vista;

import Controlador.NegocioPasajero;
import Modelo.ClaseGetPasajero;
import javax.swing.table.DefaultTableModel;

public class FrmPasajero extends javax.swing.JFrame {
    
    DefaultTableModel dt;
    //FrmRutas FrmRut = new FrmRutas();
    NegocioPasajero ObjPas = new NegocioPasajero();
    
    public FrmPasajero() {
        initComponents();
        setLocationRelativeTo(null);
        Cabecera();
    }
    FrmRutas Rut = new FrmRutas();
    
    public void Cabecera(){
        dt = (DefaultTableModel) Tabla1.getModel();
        dt.setRowCount(0);
    }
//    public void LlenaTabla(){
//        for(ClaseGetPasajero x: ObjPas.GetPasajeroRuta(Cod)){
//            Object Vec[] = {};
//        }
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        btnReg = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        LblBol = new javax.swing.JLabel();
        txtBol = new javax.swing.JTextField();
        LblNumVia = new javax.swing.JLabel();
        CmbVia = new javax.swing.JComboBox<>();
        LblNom = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        LblAsi = new javax.swing.JLabel();
        txtAsi = new javax.swing.JTextField();
        LblTip = new javax.swing.JLabel();
        txtTip = new javax.swing.JTextField();
        LblPag = new javax.swing.JLabel();
        txtPag = new javax.swing.JTextField();
        btnAgr = new javax.swing.JButton();
        btnEli = new javax.swing.JButton();
        btnEdi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(240, 255, 253));

        jTabbedPane1.setBackground(new java.awt.Color(240, 255, 253));

        jPanel1.setBackground(new java.awt.Color(240, 255, 253));

        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° VIAJE", "NOMBRE PAS.", "N° ASIENTO", "HORA VIAJE", "FECHA VIAJE", "COSTO VIAJE"
            }
        ));
        jScrollPane1.setViewportView(Tabla1);

        btnVer.setBackground(new java.awt.Color(204, 204, 204));
        btnVer.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnVer.setForeground(new java.awt.Color(51, 51, 255));
        btnVer.setText("VER PASAJEROS");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnReg.setBackground(new java.awt.Color(204, 204, 204));
        btnReg.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnReg.setForeground(new java.awt.Color(51, 51, 255));
        btnReg.setText("REGRESAR");
        btnReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnVer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("LECTURA", jPanel1);

        jPanel2.setBackground(new java.awt.Color(240, 255, 253));

        jPanel3.setBackground(new java.awt.Color(240, 255, 253));
        jPanel3.setLayout(new java.awt.GridLayout(3, 4));

        LblBol.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        LblBol.setText(" N° BOLETO:");
        jPanel3.add(LblBol);
        jPanel3.add(txtBol);

        LblNumVia.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        LblNumVia.setText(" N° VIAJE:");
        jPanel3.add(LblNumVia);

        CmbVia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ELEGIR:" }));
        jPanel3.add(CmbVia);

        LblNom.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        LblNom.setText(" NOMBRE PASAJERO:");
        jPanel3.add(LblNom);
        jPanel3.add(txtNom);

        LblAsi.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        LblAsi.setText(" N° ASIENTO:");
        jPanel3.add(LblAsi);
        jPanel3.add(txtAsi);

        LblTip.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        LblTip.setText(" TIPO ASIENTO:");
        jPanel3.add(LblTip);
        jPanel3.add(txtTip);

        LblPag.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 13)); // NOI18N
        LblPag.setText(" PAGO:");
        jPanel3.add(LblPag);
        jPanel3.add(txtPag);

        btnAgr.setBackground(new java.awt.Color(204, 204, 204));
        btnAgr.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnAgr.setForeground(new java.awt.Color(51, 51, 255));
        btnAgr.setText("AGREGAR");
        btnAgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrActionPerformed(evt);
            }
        });

        btnEli.setBackground(new java.awt.Color(204, 204, 204));
        btnEli.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnEli.setForeground(new java.awt.Color(51, 51, 255));
        btnEli.setText("ELIMINAR");
        btnEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliActionPerformed(evt);
            }
        });

        btnEdi.setBackground(new java.awt.Color(204, 204, 204));
        btnEdi.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnEdi.setForeground(new java.awt.Color(51, 51, 255));
        btnEdi.setText("EDITAR");
        btnEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REGISTRO", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        System.out.println("ERROORRR: "+Rut.NomRut);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        //dispose();
    }//GEN-LAST:event_btnRegActionPerformed

    private void btnAgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgrActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliActionPerformed

    private void btnEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEdiActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPasajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPasajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbVia;
    private javax.swing.JLabel LblAsi;
    private javax.swing.JLabel LblBol;
    private javax.swing.JLabel LblNom;
    private javax.swing.JLabel LblNumVia;
    private javax.swing.JLabel LblPag;
    private javax.swing.JLabel LblTip;
    private javax.swing.JTable Tabla1;
    private javax.swing.JButton btnAgr;
    private javax.swing.JButton btnEdi;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnVer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtAsi;
    private javax.swing.JTextField txtBol;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPag;
    private javax.swing.JTextField txtTip;
    // End of variables declaration//GEN-END:variables
}
