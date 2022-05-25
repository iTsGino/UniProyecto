
package Vista;

import Controlador.NegocioPasajero;
import Modelo.ClaseGetPasajero;
import Modelo.ClasePasajero;
import Modelo.ClaseViaje;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmPasajero extends javax.swing.JFrame {
    
    DefaultTableModel dt;
    //FrmRutas FrmRut = new FrmRutas();
    NegocioPasajero Np = new NegocioPasajero();
    ClasePasajero Cp;
    
    public FrmPasajero() {
        initComponents();
        setLocationRelativeTo(null);
        Cabecera();
        Cabecera2();
        MuestraImagen();
    }
    FrmRutas Rut = new FrmRutas();
    
    public void Cabecera(){
        dt = (DefaultTableModel) Tabla1.getModel();
        dt.setRowCount(0);
        LlenaCombo();
    }
    public void Cabecera2(){
        dt = (DefaultTableModel) Tabla2.getModel();
        dt.setRowCount(0);
    }
    
    public String NroBoleto(){
        return txtBol.getText();
    }
    public String NroViaje(){
        String CodVia = CmbVia.getSelectedItem().toString();
        if(!CodVia.equals("ELEGIR:"))
            CodVia = CodVia.substring(0, 6);
        return CodVia;
    }
    public String NombrePasajero(){
        return txtNom.getText();
    }
    public double NroAsiento(){
        return Double.parseDouble(txtAsi.getText());
    }
    public String TipoAsiento(){
        return txtTip.getText();
    }
    public double Pago(){
        return Double.parseDouble(txtPag.getText());
    }
    
    public void LlenaTabla(String Cod){
        Cabecera();
        for(ClaseGetPasajero x: Np.GetPasajeroRuta(Cod)){
            Object Vec[] = {x.getViaNro(), x.getNomPas(), x.getNroAsi(), x.getHroVia(), x.getFecVia(), x.getCosVia()};
            dt.addRow(Vec);
        }
    }
    public void LlenaCombo(){
        for(ClaseViaje x: Np.GetViaje()){
            CmbVia.addItem(x.NroViaje());
        }
    }
    public void MuestraImagen(){
        ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/Viaje.jpg"));
        Image Tam = Img.getImage().getScaledInstance(txtIma.getWidth(), txtIma.getHeight(), Image.SCALE_SMOOTH);
        txtIma.setIcon(new ImageIcon(Tam));
    }
    public void LlenaTablaPasajero(){
        Cabecera();
        for(ClasePasajero x: Np.ListadoPasajero()){
            Object Vec[] = {x.getNroBol(), x.getViaNro(), x.getNomPas(), x.getNroAsi(), x.getTipAsi(), x.getPagVia()};
            dt.addRow(Vec);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        btnReg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIma = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();

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

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO DE LOS PASAJEROS");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("EN BASE A UNA RUTA");

        txtIma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnVer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(txtIma, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIma, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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

        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° BOLETO", "N° VIAJE", "PASAJERO", "N° ASIENTO", "TIPO ASIENTO", "PAGO"
            }
        ));
        jScrollPane2.setViewportView(Tabla2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(btnEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
        //System.out.println("ERROORRR: "+Rut.NomRut);
        String Cod = Rut.NomRut;
        LlenaTabla(Cod);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegActionPerformed
        Rut.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRegActionPerformed

    private void btnAgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrActionPerformed
        Cp = new ClasePasajero(NroBoleto(), NroViaje(), NombrePasajero(), NroAsiento(), TipoAsiento(), Pago());
        Np.AgregaPasajero(Cp);
        JOptionPane.showMessageDialog(null, "¡REGISTRO AÑADIDO!");
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
    private javax.swing.JTable Tabla2;
    private javax.swing.JButton btnAgr;
    private javax.swing.JButton btnEdi;
    private javax.swing.JButton btnEli;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtAsi;
    private javax.swing.JTextField txtBol;
    private javax.swing.JLabel txtIma;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPag;
    private javax.swing.JTextField txtTip;
    // End of variables declaration//GEN-END:variables
}
