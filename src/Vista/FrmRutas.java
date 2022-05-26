
package Vista;
import Controlador.NegocioRuta;
import Modelo.ClaseRuta;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmRutas extends javax.swing.JFrame {
    
    //Atrbituos para el Formulario
    DefaultTableModel dt;
    NegocioRuta ObjRut = new NegocioRuta();
    ClaseRuta Cr;
    
    //Metodo Constructor
    public FrmRutas() {
        initComponents();
        setLocationRelativeTo(null);
        Cabecera();
        LlenaTabla();
    }
    //Atributo que toma el Valor del Nombre de la Ruta
    public static String NomRut = "";
    
    //Metodo para la Cabecera de la Tabla
    public void Cabecera(){
        dt = (DefaultTableModel) Tabla1.getModel();
        dt.setRowCount(0);
    }
    //Metodo que retorna el Codigo
    public String Codigo(){
        return txtCod.getText();
    }
    //Metodo que retorna el Nombre de la Ruta
    public String NombreRuta(){
        return txtRut.getText();
    }
    //Metodo que retorna el Pago
    public double Pago(){
        return Double.parseDouble(txtPag.getText());
    }
    
    //Metodo que Llena la tabla de Rutas
    public void LlenaTabla(){
        for(ClaseRuta x: ObjRut.ListaRutas()){  //Inicio For
            Object Vec[] = {x.getCodRut(), x.getNomRut(), x.getPagCho()};
            dt.addRow(Vec);
        }   //Fin For
    }
    //Metodo para Leer los datos y llenar datos
    public void LeerDatos(){
        Cr = new ClaseRuta(Codigo(), NombreRuta(), Pago());
        ObjRut.AgregaRuta(Cr);
        JOptionPane.showMessageDialog(null, "¡REGISTRO AÑADIDO!");
        Cabecera();
        LlenaTabla();
    }
    //Metodo para Listar los Pasajeros segun la Ruta
    public String GetNombreRuta(){  //Inicio GetNombreRuta
        FrmPasajero FrmPas = new FrmPasajero(); //Creamos un Objeto FrmPasajero
        int Filas = Tabla1.getSelectedRowCount();   //Para saber si seleccionamos una fila
        if(Filas == 0){
            JOptionPane.showMessageDialog(null, "¡Error, Seleccione una Fila!");
        } else {    //Inicio Else
            int Fila = Tabla1.getSelectedRow(); //Guardamos el valor de la fila selecinoada
            NomRut = Tabla1.getValueAt(Fila, 1).toString(); //Guardamos el valor de la celda
            FrmPas.setVisible(true);    //Para ver el FOrmulario
            this.setVisible(false); //Ocultamos este Formulario
        }   //Fin Else
        return NomRut;
    }   //Fin GetNombreRuta
    
    //Metodo para Limpiar los campos
    public void Limpia(){
        txtCod.setText("");
        txtRut.setText("");
        txtPag.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        LblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        LblNom = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        LblPag = new javax.swing.JLabel();
        txtPag = new javax.swing.JTextField();
        btnAgr = new javax.swing.JButton();
        btnPas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(240, 255, 253));
        jPanel2.setForeground(new java.awt.Color(153, 255, 255));

        Tabla1.setBackground(new java.awt.Color(240, 255, 253));
        Tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO RUTA", "NOMBRE RUTA", "PAGO CHOFER"
            }
        ));
        jScrollPane1.setViewportView(Tabla1);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO DE RUTAS");

        jPanel1.setBackground(new java.awt.Color(240, 255, 253));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2));

        LblCod.setBackground(new java.awt.Color(240, 255, 253));
        LblCod.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        LblCod.setText(" CODIGO RUTA:");
        jPanel1.add(LblCod);
        jPanel1.add(txtCod);

        LblNom.setBackground(new java.awt.Color(240, 255, 253));
        LblNom.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        LblNom.setText(" NOMBRE RUTA:");
        jPanel1.add(LblNom);
        jPanel1.add(txtRut);

        LblPag.setBackground(new java.awt.Color(240, 255, 253));
        LblPag.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        LblPag.setText(" PAGO CHOFER: ");
        jPanel1.add(LblPag);
        jPanel1.add(txtPag);

        btnAgr.setBackground(new java.awt.Color(204, 204, 204));
        btnAgr.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnAgr.setForeground(new java.awt.Color(51, 51, 255));
        btnAgr.setText("AGREGAR");
        btnAgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrActionPerformed(evt);
            }
        });

        btnPas.setBackground(new java.awt.Color(204, 204, 204));
        btnPas.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btnPas.setForeground(new java.awt.Color(51, 51, 255));
        btnPas.setText("LISTA PASAJEROS");
        btnPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPas)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrActionPerformed
        LeerDatos();
        Limpia();
    }//GEN-LAST:event_btnAgrActionPerformed

    private void btnPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasActionPerformed
        GetNombreRuta();
    }//GEN-LAST:event_btnPasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRutas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblCod;
    private javax.swing.JLabel LblNom;
    private javax.swing.JLabel LblPag;
    private javax.swing.JTable Tabla1;
    private javax.swing.JButton btnAgr;
    private javax.swing.JButton btnPas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtPag;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
