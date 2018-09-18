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
public class Menu_Movimiento extends javax.swing.JFrame {
    private DefaultTableModel model;
    int con =0;
    Double saldocliente =0.00;
    Double saldoclientef =0.00;
    Double valortra =0.00;
    String tipos= " ";
    int idtra =0;
    
    /**
     * Creates new form Menu_Movimiento
     */
    public Menu_Movimiento() {
        initComponents();
        Banco.abrirConexion();
  //      CargarGrilla();
        LlenarCombo();
        mostrarTransacciones();
        mostrarCuentas();
        calcularId();
        txtid.setEnabled(false);
        txtfecha.setEnabled(false);
        txtdocumento.setEnabled(false);
        txtcuenta.setEnabled(false);
        //cbotipo.setEnabled(false);
        txtbuscar.setEnabled(false);
        txtvalor.setEnabled(false);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
    }

    void mostrarTransacciones(){
            DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("IdTran");
            modelo.addColumn("Numero Cuenta");
            modelo.addColumn("Documento");
            modelo.addColumn("Tipo Movimiento");
            modelo.addColumn("Fecha Transaccion");
            modelo.addColumn("Valor");
                        
            lsttablaclientes.setModel(modelo);


            String sql = "select * from transacciones";
            String datos[] = new String[6];
            Statement st;
            try {
                 st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                       datos[0]=rs.getString("IDTRAN");
                       datos[1]=rs.getString("NUMERO_CUENTA");
                       datos[2]=rs.getString("DOCUMENTO");
                       datos[3]=rs.getString("TIPO_MOVIMIENTO");
                       datos[4]=rs.getString("FECHA_TRANSACCION");
                       datos[5]=rs.getString("VALOR");
                       modelo.addRow(datos);
                 }
                 lsttablaclientes.setModel(modelo);
                 rs.close();
             }catch (Exception ex) {
                      ex.printStackTrace();
              }
    }
    
    void calcularId(){
            
        String sql = "SELECT MAX( Idtran ) + 1 cant FROM TRANSACCIONES";
        Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
    //        idtra = rs;
     
            while (rs.next()) {
                     txtid.setText(rs.getString("cant"));
                           System.out.println("Maximo Id : " +rs.getString("cant"));
               }   

       } catch (Exception e){
          e.printStackTrace();
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
            lsttablacuentas.setModel(modelo);
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
                 lsttablacuentas.setModel(modelo);
                 rs.close();
             }catch (Exception ex) {
                      ex.printStackTrace();
              }
    }
    
    void mostrarCliente(){
            DefaultTableModel modelo=new DefaultTableModel();

            String sql = "select * from clientes";
            Statement st;
            try {
                 st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                            System.out.println("Cliente a buscar : " +rs.getString("NOMBRES"));
                     //  lblname.getText()=rs.getString("NOMBRES");
                 }
                 rs.close();
             }catch (Exception ex) {
                      ex.printStackTrace();
              }
    }
    
    
    void mostrarTipos(){
            DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo Transaccion");

            String sql = "select * from tipo_movimiento";
            String datos[] = new String[5];
            Statement st;
            try {
                 st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                       datos[0]=rs.getString("CODIGO");
                       datos[1]=rs.getString("NOMBRE");
                       datos[2]=rs.getString("TIPO_TRASACCION");
                       modelo.addRow(datos);
                 }
                 lsttablaclientes.setModel(modelo);
                 rs.close();
             }catch (Exception ex) {
                      ex.printStackTrace();
              }
    }
    
    void mostrarCuenta(){
            DefaultTableModel modelo=new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Tipo Transaccion");

            String sql = "select * from tipo_movimiento";
            String datos[] = new String[5];
            Statement st;
            try {
                 st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 while (rs.next()) {
                       datos[0]=rs.getString("CODIGO");
                       datos[1]=rs.getString("NOMBRE");
                       datos[2]=rs.getString("TIPO_TRASACCION");
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
    
        /*
    public static String fechaActual(){
    Date fecha=new Date();
    SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY/MM/dd");
    return formatoFecha.format(fecha);
    
    }
    
    */
    
    
    /*
    public void LimpiarCombo(){
        int ItemCount = cbotipo.getItemCount();
        for (i =0; i<ItemCount; i++) {
             cbotipo.remove();   
        }
        
    }
    */
    
    public void LlenarCombo(){
     //  LimpiarCombo();
        String sql = "select nombre from tipo_movimiento";
        Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cbotipo.addItem("Seleccione :");
               while (rs.next()) {
                     cbotipo.addItem(rs.getString("NOMBRE"));
               }   

       } catch (Exception e){
          e.printStackTrace();
        }
    }
    
    public void actualizarSaldo(cuenta p) {
		PreparedStatement ps;
                switch (tipos) {
                    case "Consignacion":  saldoclientef = (saldocliente+valortra); break;
                    case "Retiro":  saldoclientef = (saldocliente-valortra); break;
                    case "Nota Credito":  saldoclientef = (saldocliente+valortra); break;
                    case "Nota Debito":  saldoclientef = (saldocliente-valortra); break;
                    case "Devolucion":  saldoclientef = (saldocliente+valortra); break;
                }
                 String sql = "UPDATE CUENTA SET SALDO='"+saldoclientef+"'"+ "WHERE NUMERO_CUENTA='"+p.getNUMERO_CUENTA()+"'";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	    }
		catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
    public void eliminarTransacciones(cuenta p) {
		PreparedStatement ps;
                switch (tipos) {
                    case "Consignacion":  saldoclientef = (saldocliente-valortra); break;
                    case "Retiro":  saldoclientef = (saldocliente+valortra); break;
                    case "Nota Credito":  saldoclientef = (saldocliente-valortra); break;
                    case "Nota Debito":  saldoclientef = (saldocliente+valortra); break;
                    case "Devolucion":  saldoclientef = (saldocliente-valortra); break;
                }
                 String sql = "UPDATE CUENTA SET SALDO='"+saldoclientef+"'"+ "WHERE NUMERO_CUENTA='"+p.getNUMERO_CUENTA()+"'";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	    }
		catch (Exception ex) {
			ex.printStackTrace();
		}
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
    }
  
    void limpiar(){
        txtfecha.setText("");
        txtdocumento.setText("");
        txtcuenta.setText("");
        cbotipo.setToolTipText("");
        txtvalor.setText("");
    }
 
    public clientes asignar_valores(){
        clientes p = new clientes(Integer.parseInt(txtdocumento.getText()),
                    txtdocumento.getText(),
                    txtfecha.getText(),
                    (String)cbotipo.getSelectedItem(),
                    txtvalor.getText());
        return p;
    }
    
    public cuenta asignar_cuenta(){
        cuenta c = new cuenta(Integer.parseInt(txtcuenta.getText()),
                    " ",0," "," ",saldoclientef);
        return c;
    }
    
    public cuenta asignar_cuenta_eli(){
        valortra = Double.parseDouble(txtvalor.getText());
                
        cuenta c = new cuenta(Integer.parseInt(txtcuenta.getText()),
                    " ",0," "," ",0.00);
        return c;
    }
    
    public transaccion asignar_transaccion(){
        valortra = Double.parseDouble(txtvalor.getText());
        tipos = (String)cbotipo.getSelectedItem();
        transaccion c = new transaccion(Integer.parseInt(txtid.getText()),
                Integer.parseInt(txtcuenta.getText()),
                Integer.parseInt(txtdocumento.getText()),
                (String)cbotipo.getSelectedItem(),
                txtfecha.getText(),
                Double.parseDouble(txtvalor.getText()),
                9999);
        return c;
    }
    
    void cargar_txt(){
           int fila =   lsttablaclientes.getSelectedRow();
           if (fila>=0){
               txtfecha.setText(lsttablaclientes.getValueAt(fila, 0).toString());
               txtdocumento.setText(lsttablaclientes.getValueAt(fila, 1).toString());
               txtcuenta.setText(lsttablaclientes.getValueAt(fila, 2).toString());
               cbotipo.setToolTipText(lsttablaclientes.getValueAt(fila, 3).toString());
               txtvalor.setText(lsttablaclientes.getValueAt(fila, 4).toString());
           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no selecciona en la grilla");
            }
        
    }
    
    void cargar_txt_tran(){
           int fila =   lsttablaclientes.getSelectedRow();
           if (fila>=0){
               txtid.setText(lsttablaclientes.getValueAt(fila, 0).toString());
               txtcuenta.setText(lsttablaclientes.getValueAt(fila, 1).toString());
               txtdocumento.setText(lsttablaclientes.getValueAt(fila, 2).toString());
               cbotipo.setToolTipText(lsttablaclientes.getValueAt(fila, 3).toString());
               txtfecha.setText(lsttablaclientes.getValueAt(fila, 4).toString());
               txtvalor.setText(lsttablaclientes.getValueAt(fila, 5).toString());
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
              txtcuenta.setEnabled(true);
	   }
    }
    
    void validar_cuenta(){
         cuenta p = null;
         p=asignar_cuenta();
         List<cuenta> lascuentas = Banco.buscarCuenta(p);
	   for (cuenta result : lascuentas) {
              lbltipocuenta.setText(" ");
              int cuentae = (result.getNUMERO_CUENTA());
              int cuentap = Integer.parseInt(txtcuenta.getText());
              int documentoe = result.getDOCUMENTO();
              int documentop = Integer.parseInt(txtdocumento.getText());
              
              System.out.println("Cuenta  : " + cuentae);
              if (cuentae ==0 ){
                 JOptionPane.showMessageDialog(null,"Cuenta No existe");
              }else{
                 
              } 
              if (documentoe == documentop){
                    lbltipocuenta.setText(result.getTIPO_CUENTA());
                    cbotipo.setEnabled(true);
                    txtvalor.setEnabled(true);
                    btnguardar.setEnabled(true);
                    btncancelar.setEnabled(true);
                    txtdocumento.requestFocus();
                    btnnuevo.setEnabled(false);
                    btneliminar.setEnabled(false);
                    btnbuscar.setEnabled(false);
                    saldocliente = (result.getSALDO());
             }else{
                 JOptionPane.showMessageDialog(null,"Paciente No tiene esta Cuenta");
              } 
	   }
    }
    
    void validar_saldo(){
         cuenta p = null;
         p=asignar_cuenta();
         List<cuenta> lascuentas = Banco.buscarCuenta(p);
	   for (cuenta result : lascuentas) {
              lbltipocuenta.setText(" ");
              int cuentae = (result.getNUMERO_CUENTA());
              int cuentap = Integer.parseInt(txtcuenta.getText());
              int documentoe = result.getDOCUMENTO();
              int documentop = Integer.parseInt(txtdocumento.getText());
              
              System.out.println("Cuenta validar saldo   : " + cuentae);
              if (cuentae ==0 ){
                 JOptionPane.showMessageDialog(null,"Cuenta No existe");
              }else{
                 
              } 
              if (documentoe == documentop){
                    lbltipocuenta.setText(result.getTIPO_CUENTA());
                    saldocliente = (result.getSALDO());
                    System.out.println("saldo saldo   : " + saldocliente);
             }else{
                 JOptionPane.showMessageDialog(null,"Paciente No tiene esta Cuenta");
              } 
	   }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtdocumento = new javax.swing.JTextField();
        txtcuenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbotipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        lblname = new javax.swing.JLabel();
        lbltipocuenta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsttablacuentas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lsttablaclientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Transacciones"));

        jLabel1.setText("Fecha");

        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });
        txtfecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfechaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfechaKeyTyped(evt);
            }
        });

        jLabel2.setText("Documento");

        jLabel3.setText("Cuenta");

        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });
        txtdocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdocumentoKeyTyped(evt);
            }
        });

        txtcuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcuentaActionPerformed(evt);
            }
        });
        txtcuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcuentaKeyTyped(evt);
            }
        });

        jLabel4.setText("Tipo Transaccion");

        jLabel5.setText("Valor Transaccion");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
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

        lblname.setBackground(new java.awt.Color(0, 153, 153));
        lblname.setText(" ");

        lbltipocuenta.setBackground(new java.awt.Color(0, 153, 153));
        lbltipocuenta.setText(" ");

        jLabel6.setText("Nombre Cliente");

        jLabel7.setText("Tipo Cuenta");

        jLabel8.setText("Id");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(103, 103, 103)
                                                .addComponent(btncancelar)
                                                .addGap(201, 201, 201)
                                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addGap(35, 35, 35)))))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbltipocuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtcuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltipocuenta)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones Transacciones"));
        jPanel2.setLayout(new java.awt.GridLayout(1, 4, 6, 0));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnnuevo);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Cuentas"));

        lsttablacuentas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lsttablacuentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(lsttablacuentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listados de Transacciones"));

        lsttablaclientes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void txtfechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaKeyPressed

    private void txtfechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaKeyTyped

    }//GEN-LAST:event_txtfechaKeyTyped

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        transaccion p = null;
        cuenta s = null;
        p=asignar_transaccion();
        s=asignar_cuenta();
        Banco.nuevoTransaccion(p);
        actualizarSaldo(s);
   //     limpiar();
        txtfecha.setEnabled(false);
        txtdocumento.setEnabled(false);
        cbotipo.setEnabled(false);
        txtvalor.setEnabled(false);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);
        btnbuscar.setEnabled(true);
        mostrarTransacciones();
        mostrarCuentas();
        calcularId();
     //   JOptionPane.showMessageDialog(null,"Transaccion Grabada la BD");
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        limpiar();
        txtdocumento.setEnabled(false);
        txtfecha.setEnabled(false);
        txtcuenta.setEnabled(false);
        cbotipo.setEnabled(false);
        txtvalor.setEnabled(false);
        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btneliminar.setEnabled(true);                        
        btnbuscar.setEnabled(true);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        char tecla = evt.getKeyChar();
        if(tecla==KeyEvent.VK_ENTER){
      //      validar_documento();
            System.out.println("Cliente a buscar es : " +txtbuscar.getText());

        }
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        limpiar();
        txtfecha.setEnabled(true);
        txtdocumento.setEnabled(true);
        txtfecha.requestFocus();
        calcularId();
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        int fila =   lsttablaclientes.getSelectedRow();
        if (fila>=0){
            saldocliente =0.00;
            saldoclientef =0.00;
            transaccion p = null;
            cuenta s = null;
            validar_saldo();
            s=asignar_cuenta_eli();
            p=asignar_transaccion();

            int respuesta = JOptionPane.showConfirmDialog(null,"Seguro desea Eliminar a" + txtdocumento.getText() );
            if(respuesta==JOptionPane.YES_OPTION){
                 
                Banco.eliminarTransaccion(p);
                eliminarTransacciones(s);   
            }
            limpiar();
            //         mostrarClientes();
            JOptionPane.showMessageDialog(null,"Cliente Eliminado en la BD");
        }
        else{
            JOptionPane.showMessageDialog(null,"Fila no selecciona en la grilla");
        }
     
        mostrarTransacciones();
        mostrarCuentas();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        //mostrarClientes();
        txtbuscar.setVisible(true);
        txtbuscar.setEnabled(true);
        txtbuscar.requestFocus();

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void lsttablaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsttablaclientesMouseClicked
        boolean a=lsttablaclientes.isEditing();
        if (a==false){
            cargar_txt_tran();
            //JOptionPane.showMessageDialog(null,"No se puede Editar esta Lista");
        }

    }//GEN-LAST:event_lsttablaclientesMouseClicked

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtdocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocumentoKeyTyped
         char tecla = evt.getKeyChar();
       if(tecla==KeyEvent.VK_ENTER){
           validar_documento();
           System.out.println("Cliente a buscar es : " +txtbuscar.getText());
           
       }
    }//GEN-LAST:event_txtdocumentoKeyTyped

    private void txtcuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcuentaKeyTyped
          char tecla = evt.getKeyChar();
          if(tecla==KeyEvent.VK_ENTER){
            validar_cuenta();
          }
    }//GEN-LAST:event_txtcuentaKeyTyped

    private void txtcuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcuentaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Movimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Movimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbotipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lbltipocuenta;
    private javax.swing.JTable lsttablaclientes;
    private javax.swing.JTable lsttablacuentas;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcuenta;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
