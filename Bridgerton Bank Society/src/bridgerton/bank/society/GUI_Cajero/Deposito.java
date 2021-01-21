
package bridgerton.bank.society.GUI_Cajero;

import bridgerton.bank.society.BridgertonBankSociety;
import bridgerton.bank.society.Cliente;
import bridgerton.bank.society.Transaccion;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Deposito extends javax.swing.JFrame {
    private static String numero = "";
    // Herramienta para administrar transacciones previas
    private static ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
    
    // Herramientas para calcular la posición de la ventana
    private static int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private static int no_operacion = 0;
    private static int no_cajero;
    
    public Deposito(int noCajero) {
        no_cajero = noCajero; // Asignamos el número de cajero
        initComponents();
        generarOperacion(); // Generamos el número de operación
        
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);
    }
    
    private void generarOperacion(){
        // Para Número de depósito
        for(int i=0; i<10000; i++){ // Genera idc del 0 al 199 y busca alguno vacío
            if(isInTransacciones(i) == false){
                no_operacion = i;
                break;
            }
        }
    }
   
    private boolean isInTransacciones(int no_deposito){ // Función para identificar si el no. depósito está registrado entre los clientes 
        File file = new File(".\\src\\Files\\Transacciones.txt"); // Asignamos la ruta
        
        try {            
            if(file.exists()){ 
                // Primero leemos si no está vacío
                if(file.length() > 0){ 
                    FileInputStream fin = new FileInputStream(file); // Creamos flujo de lectura del archivo 
                    ObjectInputStream oin = new ObjectInputStream(fin); // Creamos flujo de lectura tipo objetos
                    transacciones = (ArrayList<Transaccion>) oin.readObject(); // Leemos el único objeto de tipo arraylist de transaccion del archivo con su cast para poderlo asignar
                    
                    for(Transaccion t: transacciones){ // Recorremos el arraylist en busca de transacciones que coincidan con el idc generado
                        if(t.getTrans() == no_deposito){
                            return true;
                        }
                    }
                    oin.close(); // Cerramos flujos de lectura
                    fin.close();
                }
                // Si está vacío devolvemos falso
                return false;
            }
            else{
                return false;
            }
            
        } catch (Exception e) { // Manejo de la exceción
            e.printStackTrace(); 
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMotivo = new javax.swing.JTextField();
        btnSig = new javax.swing.JButton();

        Error.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Error.setAlwaysOnTop(true);
        Error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Error.setResizable(false);
        Error.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ErrorWindowClosing(evt);
            }
        });

        message.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Depósito");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel3.setText("encabezado");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("DEPÓSITO A CUENTA O TARJETA ");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Ingrese el número de cuenta, clabe interbancaria, o No. de Cuenta:");

        txtCuenta.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCuenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(190, 109, 246), 2, true));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("*Comisión de 10.00 MXN en cualquier depósito de otro banco.  ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Ingrese la cantidad a depósitar en MXN:");

        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 109, 246), 2));
        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#.00"))));
        txtCantidad.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Motivo (32 carácteres máx.):");

        txtMotivo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtMotivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 109, 246), 2));

        btnSig.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSig.setText("SIGUIENTE");
        btnSig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(190, 109, 246), 1, true));
        btnSig.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(492, 492, 492)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(396, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSig, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(379, 379, 379))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(53, 53, 53)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnSig, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 148, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigActionPerformed
        boolean errors = false; // Variable para identificar los errores del algun dato
        float dato_cantidad = 0;
        String dato_motivo = "";
        
        // Para el no de cuenta
        if(txtCuenta.getText().isBlank() == false){
            try{
                numero =Long.toString(Long.valueOf(txtCuenta.getText()));
            }catch(Exception e){
                message.setText("Falta no. cuenta o está mal");
                errors = true;
            }
        }
        else{
            message.setText("Falta no. cuenta o está mal");
            errors = true;
        }
        
        // Para la cantidad
        if(txtCantidad.getText().isBlank() == false){
            try{
                dato_cantidad = Float.valueOf(txtCantidad.getText());
            }catch(Exception e){
                message.setText("Falta cantidad o está mal");
                errors = true;
            }
        }
        else{
            message.setText("Falta cantidad o está mal");
            errors = true;
        }
        
        // Para el motivo
        if(txtMotivo.getText().isBlank() == false){
            try{
                dato_motivo = txtMotivo.getText();
            }catch(Exception e){
                message.setText("Falta motivo o está mal");
                errors = true;
            }
        }
        else{
            message.setText("Falta motivo o está mal");
            errors = true;
        }
        // Checamos si hubo algún error
        if(errors){
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho/2 - 160, alto/2 - 45);
        }
        else{
            DepCon depc = new DepCon(this, numero, dato_cantidad, no_operacion, dato_motivo, no_cajero);
            depc.setVisible(true);
            this.setVisible(false);
            this.dispose();
            
        }
      
    }//GEN-LAST:event_btnSigActionPerformed

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();
    }//GEN-LAST:event_ErrorWindowClosing

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cajero cj = new Cajero();
        cj.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposito(10).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Error;
    private javax.swing.JButton btnSig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel message;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtMotivo;
    // End of variables declaration//GEN-END:variables
}
