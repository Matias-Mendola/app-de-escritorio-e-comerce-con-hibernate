
package view;

import controller.ClienteController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.SessionUsuario;
import model.Cliente;
import model.Empleado;

public class OpcionesDeEmplead extends javax.swing.JFrame {

    public OpcionesDeEmplead() {
        this.setLocationRelativeTo(null);
        Empleado empleado = SessionUsuario.empleadoLogueado;
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.lblNombre.setText(empleado.getNombre()+ " "+empleado.getApellido());
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        btnMisVentas = new javax.swing.JButton();
        btnListaDeVentas = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnMisDatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnCerrar.setText("Cerrar Session");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblNombre.setText("nombre apellido");

        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnMisVentas.setText("Mis Ventas");
        btnMisVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisVentasActionPerformed(evt);
            }
        });

        btnListaDeVentas.setText("Todas las Ventas");
        btnListaDeVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDeVentasActionPerformed(evt);
            }
        });

        btnProductos.setText("Lista de Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnMisDatos.setText("Mis Datos");
        btnMisDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisDatosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMisVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListaDeVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(btnMisDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCerrar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addComponent(btnVender)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMisVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListaDeVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMisDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       JOptionPane.showMessageDialog(this, 
        "Para salir del sistema de forma segura, por favor utilice el botón 'Cerrar Sesión'.", 
        "Acción no permitida", 
        JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_formWindowClosing

    private void btnMisVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisVentasActionPerformed
        MisVentas misVentas = new MisVentas();
        misVentas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMisVentasActionPerformed

    private void btnListaDeVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDeVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListaDeVentasActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
       Productos p = new Productos();
       p.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnMisDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisDatosActionPerformed
        MisDatos misDatos =new MisDatos();
        misDatos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMisDatosActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        SessionUsuario.lagout();
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        String dni = JOptionPane.showInputDialog(null,"ingrese El DNI Del Cliente");
       int DNI = Integer.parseInt(dni);
       ClienteController clienteController = new ClienteController();
       Cliente cliente;
       JTextField txtDni = new JTextField(12);
       JPanel panel = new JPanel();
       panel.add(new JLabel("Ingrese El DNI Del CLiente"));
       panel.add(txtDni);
       String []opciones ={"buscar","Regitro","cancelar"};
       int seleccion = JOptionPane.showOptionDialog(null,
               panel,
               "Idebntificacion Del Cliente",
               JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones, 
                opciones[0]);
        switch (seleccion) {
            case 0 -> {
                cliente = clienteController.buscarCliente(DNI);
                if(cliente!=null){
                    Venta venta = new Venta(cliente);
                    venta.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this,"El dni es incorrecto");
                    
                }
            }
            case 1 -> {
                RegistroCliente registro = new RegistroCliente();
                registro.setVisible(true);
                this.dispose();
            }
            case 2 -> this.repaint();
            default -> {
            }
        }
    }//GEN-LAST:event_btnVenderActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnListaDeVentas;
    private javax.swing.JButton btnMisDatos;
    private javax.swing.JButton btnMisVentas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnVender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
