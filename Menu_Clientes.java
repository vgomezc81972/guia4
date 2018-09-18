/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Banco.conexion;
import com.sun.glass.events.KeyEvent;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victorjulio
 */
public class Menu_Clientes extends javax.swing.JFrame {
    private DefaultTableModel model;
    int con =0;

    public Menu_Clientes() {
        initComponents();
        Banco.abrirConexion();
  //    mostrarClientes();
        CargarGrilla();
        
        txtdocumento.setEnabled(false);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        cbosexo.setEnabled(false);
        txtbuscar.setEnabled(false);
 //       txtbuscar.setVisible(false);
        txtfechanacimiento.setEnabled(false);
        btnguardar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btnbuscar.setEnabled(false);
        btncancelar.setEnabled(false);
    }
    
    void mostrarClientes(){
            DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("Documento");
            modelo.addColumn("Nombres");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Sexo");
            modelo.addColumn("Fecha Nacimiento");
            lsttablaclientes.setModel(modelo);


            String sql = "select * from clientes";
            String datos[] = new String[5];
            Statement st;
            try {
                 st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                       datos[0]=rs.getString("DOCUMENTO");
                       datos[1]=rs.getString("NOMBRES");
                       datos[2]=rs.getString("APELLIDOS");
                       datos[3]=rs.getString("SEXO");
                       datos[4]=rs.getString("FECHA_NACIMIENTO");
                       modelo.addRow(datos);
                 }
                 lsttablaclientes.setModel(modelo);
                 rs.close();
             }catch (Exception ex) {
                      ex.printStackTrace();
              }
    }
    
    public void MostrarDatos(clientes c)
    {
        model.insertRow(con,new Object[]{});
        model.setValueAt(c.getDOCUMENTO(),con,0);
        model.setValueAt(c.getNOMBRES(),con,1);
        model.setValueAt(c.getAPELLIDOS(),con,2);
        model.setValueAt(c.getSEXO(),con,3);
        model.setValueAt(c.getFECHA_NACIMIENTO(),con,4);
        con++;
        lsttablaclientes.setModel(model);
        
    }
    
    public void CargarGrilla(){
     String data[][] = {};
     String col[]= {"Documento","Nombres","Apellidos","Sexo","Fecha Nacimiento"};
     model = new DefaultTableModel(data,col);
     lsttablaclientes.setModel(model);
     List<clientes> losclientes = Banco.obtenerCliente();
	for (clientes p : losclientes) {
	    MostrarDatos(p);
	} 
    //Banco.cerrarConexion();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsttablaclientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbosexo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtfechanacimiento = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Clientes"));
        jPanel2.setLayout(new java.awt.GridLayout(1, 4, 6, 0));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnnuevo);

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnmodificar);

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminar);

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnbuscar);

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnsalir);

        lsttablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        lsttablaclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsttablaclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lsttablaclientes);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Clientes"));

        jLabel1.setText("Documento :");

        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });
        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombres :");

        jLabel3.setText("Apellidos :");

        jLabel4.setText("Sexo :");

        cbosexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar :", "Masculino", "Femenino" }));

        jLabel5.setText("Fecha Nacimiento :");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnactualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar)
                        .addGap(201, 201, 201)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(28, 28, 28)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombres)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtfechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnactualizar)
                    .addComponent(btncancelar)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiar();
        txtdocumento.setEnabled(true);
        txtnombres.setEnabled(true);
        txtapellidos.setEnabled(true);
        cbosexo.setEnabled(true);
        txtfechanacimiento.setEnabled(true);
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        txtdocumento.requestFocus();
        btnmodificar.setEnabled(false);
        btnnuevo.setEnabled(false);
        btneliminar.setEnabled(false);                        
        btnbuscar.setEnabled(false);
      //  lsttablaclientes.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    
    void limpiar(){
        txtdocumento.setText("");
        txtnombres.setText("");
        txtapellidos.setText("");
        cbosexo.setToolTipText("");
        txtfechanacimiento.setText("");
    }
    
    public clientes asignar_valores(){
        if(txtbuscar.getText().length()>0){
            int docu = Integer.parseInt(txtbuscar.getText());
        }
            int docu =  Integer.parseInt(txtdocumento.getText());
        
                System.out.println("Cliente a buscar : " +txtbuscar.getText());
                        System.out.println("Cliente a buscar : " +docu);
        
        clientes p = new clientes(docu,
                    txtnombres.getText(),
                    txtapellidos.getText(),
                    (String)cbosexo.getSelectedItem(),
                    txtfechanacimiento.getText());
        System.out.println("Cliente a buscar : " +txtdocumento.getText());
        System.out.println("Cliente a buscar : " +p);
    
        
        return p;
    }
    
    void cargar_txt(){
           int fila =   lsttablaclientes.getSelectedRow();
           if (fila>=0){
               txtdocumento.setText(lsttablaclientes.getValueAt(fila, 0).toString());
               txtnombres.setText(lsttablaclientes.getValueAt(fila, 1).toString());
               txtapellidos.setText(lsttablaclientes.getValueAt(fila, 2).toString());
               cbosexo.setToolTipText(lsttablaclientes.getValueAt(fila, 3).toString());
               txtfechanacimiento.setText(lsttablaclientes.getValueAt(fila, 4).toString());
           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no selecciona en la grilla");
            }
        
    }
    
    void validar_documento(){
        
                 System.out.println("Cliente antes al ciclo a BD : " +txtbuscar.getText());  
	   clientes p = null;
           p=asignar_valores();
           System.out.println("Cliente antes al ciclo a BD : " +p); 
           
           System.out.println("Cliente a entrar a BD : " +txtbuscar.getText());
           List<clientes> losclientes = Banco.buscarCliente(p);
                      
	   for (clientes result : losclientes) {
              System.out.println("Cliente Encontrado despues : " +result.getNOMBRES());
              txtnombres.setText(result.getNOMBRES());
              txtapellidos.setText(result.getAPELLIDOS());
              cbosexo.setToolTipText(result.getSEXO());
              txtfechanacimiento.setText(result.getFECHA_NACIMIENTO());
	   }
         
               
    }
    
    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
         System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
       //mostrarClientes();
        txtbuscar.setVisible(true);
        txtbuscar.setEnabled(true);
        txtbuscar.requestFocus();
    
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        clientes p = null;
        p=asignar_valores();
        Banco.actualizarCliente(p);
        limpiar();
        mostrarClientes();
        txtdocumento.setEnabled(false);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        cbosexo.setEnabled(false);
        txtfechanacimiento.setEnabled(false);
        btnguardar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);                        
        btnbuscar.setEnabled(true);
        JOptionPane.showMessageDialog(null,"Cliente Guardado en la BD");
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        int fila =   lsttablaclientes.getSelectedRow();
        if (fila>=0){
                txtdocumento.setEnabled(false);
                txtnombres.setEnabled(true);
                txtapellidos.setEnabled(true);
                cbosexo.setEnabled(true);
                txtfechanacimiento.setEnabled(true);
                btnguardar.setEnabled(false);
                btnactualizar.setEnabled(true);
                txtnombres.requestFocus();
                btnmodificar.setEnabled(false);
                btnnuevo.setEnabled(false);
                btneliminar.setEnabled(false);                        
                btnbuscar.setEnabled(false);
           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no selecciona en la grilla");
            }
   
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int fila =   lsttablaclientes.getSelectedRow();
        if (fila>=0){
                clientes p = null;
                p=asignar_valores();
                int respuesta = JOptionPane.showConfirmDialog(null,"Seguro desea Eliminar a" + txtdocumento.getText() );
                if(respuesta==JOptionPane.YES_OPTION){
                    Banco.eliminarCliente(p);
                }
                limpiar();
                mostrarClientes();
                JOptionPane.showMessageDialog(null,"Cliente Eliminado en la BD");
           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no selecciona en la grilla");
            }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
 /*       clientes p = new clientes(Integer.parseInt(txtdocumento.getText()),
                txtnombres.getText(),
                txtapellidos.getText(),
                (String)cbosexo.getSelectedItem(),
                txtfechanacimiento.getText());
        */
        clientes p = null;
        p=asignar_valores();
        Banco.nuevoCliente(p);
        limpiar();
        txtdocumento.setEnabled(false);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        cbosexo.setEnabled(false);
        txtfechanacimiento.setEnabled(false);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);                        
        btnbuscar.setEnabled(true);
        mostrarClientes();
        JOptionPane.showMessageDialog(null,"Cliente Insertado en la BD");
    }//GEN-LAST:event_btnguardarActionPerformed

    private void lsttablaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsttablaclientesMouseClicked
        boolean a=lsttablaclientes.isEditing();
        if (a==false){
           cargar_txt();
           //JOptionPane.showMessageDialog(null,"No se puede Editar esta Lista"); 
        }
                
    }//GEN-LAST:event_lsttablaclientesMouseClicked

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        txtdocumento.setEnabled(false);
        txtnombres.setEnabled(false);
        txtapellidos.setEnabled(false);
        cbosexo.setEnabled(false);
        txtfechanacimiento.setEnabled(false);
        btnguardar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);                        
        btnbuscar.setEnabled(true);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtdocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoKeyPressed

    private void txtdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyTyped

    }//GEN-LAST:event_txtdocumentoKeyTyped

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
       char tecla = evt.getKeyChar();
       if(tecla==KeyEvent.VK_ENTER){
           validar_documento();
           System.out.println("Cliente a buscar es : " +txtbuscar.getText());
           
       }
    }//GEN-LAST:event_txtbuscarKeyTyped


    public static void main(String args[]) {
        Banco.abrirConexion();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Clientes().setVisible(true);
            }
        });
     //   Banco.cerrarConexion();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbosexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lsttablaclientes;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtfechanacimiento;
    private javax.swing.JTextField txtnombres;
    // End of variables declaration//GEN-END:variables

    private void getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
