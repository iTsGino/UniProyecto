
package Vista;
import Controlador.NegocioPasajero;
import Modelo.ClaseGetPasajero;
import Modelo.ClasePasajero;
import Modelo.ClaseViaje;
import Modelo.ClasePlantillaPdf;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class FrmPasajero extends javax.swing.JFrame {
    
    //Atributos para el formulario
    DefaultTableModel dt;
    DefaultTableModel dt2;
    //FrmRutas FrmRut = new FrmRutas();
    NegocioPasajero Np = new NegocioPasajero();
    ClasePasajero Cp;
    List<ClaseGetPasajero> Lis = new ArrayList();;
    SimpleDateFormat Df = new SimpleDateFormat("yyyy-MM-dd");   //Para dar formato a la fecha
    
    //Metodo Constructor
    public FrmPasajero() {
        initComponents();
        setLocationRelativeTo(null);
        MuestraImagen();
        Cabecera();
        Cabecera2();
        LlenaCombo();
        LlenaTablaPasajero();
        CapturaFila();
    }
    FrmRutas Rut = new FrmRutas();  //Para recuperar la Ruta selecionada en el 'FrmRutas'
    
    //Metodo para la cabecera de la tabla PasajeroRuta
    public void Cabecera(){
        dt = (DefaultTableModel) Tabla1.getModel();
        dt.setRowCount(0);
    }
    //Metodo para la cabecera de la tabla Pasajero
    public void Cabecera2(){
        dt2 = (DefaultTableModel) Tabla2.getModel();
        dt2.setRowCount(0);
    }
    //Metodo para retornar el NroBoleto
    public String NroBoleto(){
        return txtBol.getText();
    }
    //Metodo para retornar el NroViaje y llenar el combo con datos
    public String NroViaje(){
        String CodVia = CmbVia.getSelectedItem().toString();
        if(!CodVia.equals("ELEGIR:"))
            CodVia = CodVia.substring(0, 6);
        return CodVia;
    }
    //Metodo para retornar el Nombre del Pasajero
    public String NombrePasajero(){
        return txtNom.getText();
    }
    //Metodo para retornar el NroAsiento
    public double NroAsiento(){
        return Double.parseDouble(txtAsi.getText());
    }
    //Metodo para retornar el TipoAsiento
    public String TipoAsiento(){
        return txtTip.getText();
    }
    //Metodo para retornar el Pago
    public double Pago(){
        return Double.parseDouble(txtPag.getText());
    }
    //Metodo llenar la tabla PasajeroRuta
    public void LlenaTabla(String Cod){
        Cabecera();
        for(ClaseGetPasajero x: Np.GetPasajeroRuta(Cod)){
            Object Vec[] = {x.getViaNro(), x.getNomPas(), x.getNroAsi(), x.getHroVia(), x.getFecVia(), x.getCosVia()};
            Lis.add(x);
            dt.addRow(Vec);
        }
    }
    //Metodo llenar la tabla Pasajero
    public void LlenaTablaPasajero(){
        Cabecera2();
        for(ClasePasajero x: Np.ListadoPasajero()){
            Object Vec[] = {x.getNroBol(), x.getViaNro(), x.getNomPas(), x.getNroAsi(), x.getTipAsi(), x.getPagVia()};
            dt2.addRow(Vec);
        }
    }
    //Metodo para llenar el combo con el Codigo de Viaje y la fecha del Viaje
    public void LlenaCombo(){
        for(ClaseViaje x: Np.GetViaje()){
            CmbVia.addItem(x.NroViaje());
        }
    }
    //Metodo para Eliminar los datos de la tabla
    public void EliminaDatos(){ //Inicio Metodo EliminaDatos
        int Filas = Tabla2.getSelectedRowCount();
        String Cod;
        if(Filas == 0){
            JOptionPane.showMessageDialog(null, "¡Error, Seleccione una Fila!");
        } else {    //Inicio Else
            int Fila = Tabla2.getSelectedRow();
            Cod = Tabla2.getValueAt(Fila, 0).toString();
            Np.EliminaPasajero(Cod);
            JOptionPane.showMessageDialog(null, "¡Registro Eliminado!");
            dt2.removeRow(Fila);
        }   //Fin Else
    }   //Fin Metodo EliminaDatos
    
    //Metodo para Mostrar una Imagen
    public void MuestraImagen(){
        ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/Viaje.jpg"));   //Cargar la Imagen
        Image Tam = Img.getImage().getScaledInstance(txtIma.getWidth(), txtIma.getHeight(), Image.SCALE_SMOOTH);    //Ajustar el tamño
        txtIma.setIcon(new ImageIcon(Tam)); //Mandar la Imagen al Label
    }
    //Metodo para Capturar la Fila Seleccionada de la Tabla Pasajero
    public void CapturaFila() {
        Tabla2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int Fil;
                if (Tabla2.getSelectedRow() != -1) {    //Inicio If
                    Fil = Tabla2.getSelectedRow();
                    txtBol.setText(Tabla2.getValueAt(Fil, 0).toString());
                    CmbVia.setSelectedItem(Tabla2.getValueAt(Fil, 1));
                    txtNom.setText(Tabla2.getValueAt(Fil, 2).toString());
                    txtAsi.setText(Tabla2.getValueAt(Fil, 3).toString());
                    txtTip.setText(Tabla2.getValueAt(Fil, 4).toString());
                    txtPag.setText(Tabla2.getValueAt(Fil, 5).toString());
                }   //Fin If
            }
        });
    }
    //Metodo para limpiar los campos
    public void Limpia(){
        txtBol.setText("");
        CmbVia.setSelectedIndex(0);
        txtNom.setText("");
        txtAsi.setText("");
        txtTip.setText("");
        txtPag.setText("");
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
        btnExpPdf = new javax.swing.JButton();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        btnIni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(240, 255, 253));

        jTabbedPane1.setBackground(new java.awt.Color(240, 255, 253));

        jPanel1.setBackground(new java.awt.Color(240, 255, 253));

        Tabla1.setBackground(new java.awt.Color(240, 255, 253));
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

        btnExpPdf.setBackground(new java.awt.Color(204, 204, 204));
        btnExpPdf.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnExpPdf.setForeground(new java.awt.Color(51, 51, 255));
        btnExpPdf.setText("EXPORTAR PDF");
        btnExpPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnVer)
                .addGap(72, 72, 72)
                .addComponent(btnExpPdf)
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
                .addContainerGap(28, Short.MAX_VALUE))
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
                    .addComponent(btnReg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExpPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        Tabla2.setBackground(new java.awt.Color(240, 255, 253));
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
        jScrollPane3.setViewportView(Tabla2);

        btnIni.setBackground(new java.awt.Color(204, 204, 204));
        btnIni.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnIni.setForeground(new java.awt.Color(51, 51, 255));
        btnIni.setText("INICIALIZAR");
        btnIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniActionPerformed(evt);
            }
        });

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
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIni, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEli, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIni, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        LlenaTablaPasajero();
        Limpia();
    }//GEN-LAST:event_btnAgrActionPerformed

    private void btnEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliActionPerformed
        EliminaDatos();
    }//GEN-LAST:event_btnEliActionPerformed

    private void btnEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdiActionPerformed
        Cp = new ClasePasajero(NroBoleto(), NroViaje(), NombrePasajero(), NroAsiento(), TipoAsiento(), Pago());
        Np.EditaPasajero(Cp);
        JOptionPane.showMessageDialog(null, "¡REGISTRO MODIFICADO!");
        Limpia();
        LlenaTablaPasajero();
    }//GEN-LAST:event_btnEdiActionPerformed

    private void btnIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniActionPerformed
        Limpia();
        LlenaTablaPasajero();
    }//GEN-LAST:event_btnIniActionPerformed

    private void btnExpPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpPdfActionPerformed
        Date Fch = new Date();
        String Nom = JOptionPane.showInputDialog("Ingrese su Nombre:");
        ClasePlantillaPdf Pp = new ClasePlantillaPdf(Nom, Df.format(Fch), Lis);
        Pp.CrearPlantilla();
    }//GEN-LAST:event_btnExpPdfActionPerformed

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
    private javax.swing.JButton btnExpPdf;
    private javax.swing.JButton btnIni;
    private javax.swing.JButton btnReg;
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtAsi;
    private javax.swing.JTextField txtBol;
    private javax.swing.JLabel txtIma;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPag;
    private javax.swing.JTextField txtTip;
    // End of variables declaration//GEN-END:variables
}
