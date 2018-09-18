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
public class Menu_Cuenta extends javax.swing.JFrame {
    private DefaultTableModel model;
    int con =0;

    public Menu_Cuenta() {
        initComponents();
        Banco.abrirConexion();
  //    mostrarClientes();
        CargarGrilla();
        LlenarCombo();
        txtcuenta.setEnabled(false);
        txtdocumento.setEnabled(false);
  //      txtapellidos.setEnabled(false);
        cbotipo.setEnabled(false);
        txtbuscar.setEnabled(false);
 //       txtbuscar.setVisible(false);
        txtfechaapertura.setEnabled(false);
        btnguardar.setEnabled(false);
        btnactualizar.setEnabled(false);
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
    
    void mostrarCuentas(){
            DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("Numero Cuenta");
            modelo.addColumn("Tipo Cuenta");
            modelo.addColumn("Documento");
            modelo.addColumn("Codigo Oficina");
            modelo.addColumn("Fecha Apertura");
            modelo.addColumn("Saldo");
            lsttablaclientes.setModel(modelo);
            String sql = "select * from cuenta";
            String datos[] = new String[6];
            Statement st;
            try {
                 st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                       datos[0]=rs.getString("NUMERO_CUENTA");
                       datos[1]=rs.getString("TIPO_CUENTA");
                       datos[2]=rs.getString("DOCUMENTO");
                       datos[3]=rs.getString("CODIGO_OFICINA");
                       datos[4]=rs.getString("FECHA_APERTURA");
                       datos[5]=rs.getString("SALDO");
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
    
    public void MostrarDatosCuenta(cuenta c)
    {
        model.insertRow(con,new Object[]{});
        model.setValueAt(c.getNUMERO_CUENTA(),con,0);
        model.setValueAt(c.getTIPO_CUENTA(),con,1);
        model.setValueAt(c.getDOCUMENTO(),con,2);
        model.setValueAt(c.getCODIGO_OFICINA(),con,3);
        model.setValueAt(c.getFECHA_APERTURA(),con,4);
        model.setValueAt(c.getSALDO(),con,5);
        con++;
        lsttablaclientes.setModel(model);
        
    }
    
    public void CargarGrilla(){
     String data[][] = {};
     String col[]= {"Numero Cuenta","Tipo Cuenta","Documento","Codigo Oficina","Fecha Apertura","Saldo"};
     model = new DefaultTableModel(data,col);
     lsttablaclientes.setModel(model);
     List<cuenta> lascuentas = Banco.obtenerCuenta();
	for (cuenta p : lascuentas) {
	    MostrarDatosCuenta(p);
	} 
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
        txtcuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtfechaapertura = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        cbooficina = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Cuentas"));
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cuentas"));

        jLabel1.setText("Cuenta");

        txtcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcuentaActionPerformed(evt);
            }
        });
        txtcuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcuentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcuentaKeyTyped(evt);
            }
        });

        jLabel2.setText("Documento");

        jLabel3.setText("Nombre Cliente");

        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyTyped(evt);
            }
        });

        jLabel4.setText("Tipo Cuenta");

        cbotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ahorros", "Cuenta Corriente" }));
        cbotipo.setToolTipText("");

        jLabel5.setText("Fecha Apertura :");

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

        lblname.setText(" ");

        jLabel6.setText("Oficina");

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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtfechaapertura, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbooficina, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblname))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtfechaapertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbooficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
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
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiar();
        txtcuenta.setEnabled(true);
        txtdocumento.setEnabled(true);
        cbotipo.setEnabled(true);
        txtfechaapertura.setEnabled(true);
        cbooficina.setEnabled(true);
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        txtcuenta.requestFocus();
        btnmodificar.setEnabled(false);
        btnnuevo.setEnabled(false);
        btneliminar.setEnabled(false);                        
        btnbuscar.setEnabled(false);
    }//GEN-LAST:event_btnnuevoActionPerformed

    
    void limpiar(){
        txtcuenta.setText("");
        txtdocumento.setText("");
        cbotipo.setToolTipText("");
        txtfechaapertura.setText("");
        cbooficina.setToolTipText("");
    }
    
    
    public clientes asignar_valores(){
        clientes p = new clientes(Integer.parseInt(txtdocumento.getText()),
                    txtdocumento.getText(),
                    txtfechaapertura.getText(),
                    (String)cbotipo.getSelectedItem(),
                    "");
        return p;
    }
    
    
    public cuenta asignar_valores_cuenta(){
        cuenta c = new cuenta(Integer.parseInt(txtcuenta.getText()),
                    (String)cbotipo.getSelectedItem(),
                    Integer.parseInt(txtdocumento.getText()),
                    (String)cbooficina.getSelectedItem(),
                    txtfechaapertura.getText(),
                    0.00);
        return c;
    }
    
    
    void cargar_txt(){
           int fila =   lsttablaclientes.getSelectedRow();
           if (fila>=0){
               txtcuenta.setText(lsttablaclientes.getValueAt(fila, 0).toString());
               cbotipo.setToolTipText(lsttablaclientes.getValueAt(fila, 1).toString());
               txtdocumento.setText(lsttablaclientes.getValueAt(fila, 2).toString());
                cbooficina.setToolTipText(lsttablaclientes.getValueAt(fila, 3).toString());
               txtfechaapertura.setText(lsttablaclientes.getValueAt(fila, 4).toString());
           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no selecciona en la grilla");
            }
        
    }
    
     void validar_documento(){
         clientes p = null;
         p=asignar_valores();
         List<clientes> losclientes = Banco.buscarCliente(p);
                      
	   for (clientes result : losclientes) {
              lblname.setText(result.getNOMBRES()+" " +result.getAPELLIDOS() );
            //  txtcuenta.setEnabled(true);
	   }
    }
    
    public void LlenarCombo(){
     //  LimpiarCombo();
        String sql = "select nombre from oficinas";
        Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cbooficina.addItem("Seleccione :");
               while (rs.next()) {
                     cbooficina.addItem(rs.getString("NOMBRE"));
               }   

       } catch (Exception e){
          e.printStackTrace();
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
        cuenta p = null;
        p=asignar_valores_cuenta();
        Banco.actualizarCuenta(p);
        limpiar();
        mostrarCuentas();
        txtcuenta.setEnabled(false);
        txtdocumento.setEnabled(false);
        cbotipo.setEnabled(false);
        txtfechaapertura.setEnabled(false);
        btnguardar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);                        
        btnbuscar.setEnabled(true);
        JOptionPane.showMessageDialog(null,"Cuenta Actualizada Guardado en la BD");
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        int fila =   lsttablaclientes.getSelectedRow();
        if (fila>=0){
                txtcuenta.setEnabled(false);
                txtdocumento.setEnabled(true);
                cbotipo.setEnabled(true);
                txtfechaapertura.setEnabled(true);
                cbooficina.setEnabled(true);
                btnguardar.setEnabled(false);
                btnactualizar.setEnabled(true);
                txtcuenta.requestFocus();
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
                cuenta p = null;
                p=asignar_valores_cuenta();
                int respuesta = JOptionPane.showConfirmDialog(null,"Seguro desea Eliminar cuenta : " + txtcuenta.getText() );
                if(respuesta==JOptionPane.YES_OPTION){
                    Banco.eliminarCuenta(p);
                }
                limpiar();
                mostrarCuentas();
                JOptionPane.showMessageDialog(null,"CUENTA Eliminado en la BD");
           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no selecciona en la grilla");
            }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        cuenta c = null;
        c=asignar_valores_cuenta();
        Banco.nuevaCuenta(c);
        limpiar();
        txtcuenta.setEnabled(false);
        txtdocumento.setEnabled(false);
        cbotipo.setEnabled(false);
        txtfechaapertura.setEnabled(false);
        cbooficina.setEnabled(false);
        btnguardar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);                        
        btnbuscar.setEnabled(true);
        mostrarCuentas();
        JOptionPane.showMessageDialog(null,"Cuenta Insertada en la BD");
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
        txtcuenta.setEnabled(false);
        txtdocumento.setEnabled(false);
     //   txtapellidos.setEnabled(false);
        cbotipo.setEnabled(false);
        txtfechaapertura.setEnabled(false);
        btnguardar.setEnabled(false);
        btnactualizar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnmodificar.setEnabled(true);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);                        
        btnbuscar.setEnabled(true);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcuentaActionPerformed

    private void txtcuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcuentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcuentaKeyPressed

    private void txtcuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcuentaKeyTyped

    }//GEN-LAST:event_txtcuentaKeyTyped

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
       char tecla = evt.getKeyChar();
       if(tecla==KeyEvent.VK_ENTER){
           validar_documento();
           System.out.println("Cliente a buscar es : " +txtbuscar.getText());
           
       }
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void txtdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyTyped
          char tecla = evt.getKeyChar();
       if(tecla==KeyEvent.VK_ENTER){
           validar_documento();
           System.out.println("Cliente a buscar es : " +txtbuscar.getText());
       }
    }//GEN-LAST:event_txtdocumentoKeyTyped


    public static void main(String args[]) {
        Banco.abrirConexion();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Cuenta().setVisible(true);
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
    private javax.swing.JComboBox<String> cbooficina;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblname;
    private javax.swing.JTable lsttablaclientes;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcuenta;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtfechaapertura;
    // End of variables declaration//GEN-END:variables

    private void getText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
