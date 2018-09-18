/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Banco {

    	static Connection conexion;
	public static void abrirConexion() {
		try {
			Class.forName("org.h2.Driver");
			conexion = DriverManager.getConnection("jdbc:h2:c:/ean/banco",
					   "sa", "");
		}
		catch (Exception ex) {
			conexion = null;
			System.err.println("Error de conexion con la BD");
			ex.printStackTrace();
		}
	}
	
	public static void cerrarConexion() {
		try {
			if (conexion != null);{
			   conexion.close();
			}
		}	
		catch (Exception ex) {}
	}
	
	public static void nuevoCliente(clientes p) {
		PreparedStatement ps;
		String sql = "INSERT INTO CLIENTES VALUES(?,?,?,?,?)";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.setInt(1, p.getDOCUMENTO());
		    ps.setString(2, p.getNOMBRES());
                    ps.setString(3, p.getAPELLIDOS());
		    ps.setString(4, p.getSEXO());
		    ps.setString(5, p.getFECHA_NACIMIENTO());
		    ps.executeUpdate();
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        public static void nuevoTransaccion(transaccion p) {
		PreparedStatement ps;
		String sql = "INSERT INTO TRANSACCIONES VALUES(?,?,?,?,?,?)";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.setInt(0, p.getNUMERO_CUENTA());
                    ps.setInt(1, p.getDOCUMENTO());
		    ps.setString(2, p.getTIPO_MOVIMIENTO());
                    ps.setString(3, p.getFECHA_TRANSACCION());
		    ps.setDouble(4, p.getVALOR());
		    ps.setInt(5, p.getCODIGO_EMPLEADO());
		    
		    ps.executeUpdate();
		    System.out.println("Clientes Insertados en la BD");
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        
        public static void nuevaCuenta(cuenta p) {
		PreparedStatement ps;
		String sql = "INSERT INTO cuenta VALUES(?,?,?,?,?,?)";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.setInt(1, p.getNUMERO_CUENTA());
                    ps.setString(2, p.getTIPO_CUENTA());
                    ps.setInt(3, p.getDOCUMENTO());
		    ps.setString(4, p.getCODIGO_OFICINA());
                    ps.setString(5, p.getFECHA_APERTURA());
		    ps.setDouble(6, p.getSALDO());
		    ps.executeUpdate();
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        public static void actualizarCliente(clientes p) {
		PreparedStatement ps;
		               
                String sql = "UPDATE clientes SET NOMBRES='"+p.getNOMBRES()+ "',"+"ApellidoS='"+p.getAPELLIDOS()+"'"+ "WHERE documento='"+p.getDOCUMENTO()+"'";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	    }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        public static void actualizarCuenta(cuenta p) {
		PreparedStatement ps;
		               
                String sql = "UPDATE CUENTA SET TIPO_CUENTA='"+p.getTIPO_CUENTA()+ "',"+"CODIGO_OFICINA='"+p.getCODIGO_OFICINA()+"'"+ "WHERE NUMERO_CUENTA='"+p.getNUMERO_CUENTA()+"'";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	    }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        public static void actualizarSaldo(clientes p) {
		PreparedStatement ps;
		               
                String sql = "UPDATE clientes SET NOMBRES='"+p.getNOMBRES()+ "',"+"ApellidoS='"+p.getAPELLIDOS()+"'"+ "WHERE documento='"+p.getDOCUMENTO()+"'";
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	    }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        public static List<clientes> buscarCliente(clientes p) {
		List<clientes> clientes = new ArrayList<>();
                try {
                    Statement st;
                    String sql = "SELECT * FROM clientes WHERE documento='"+p.getDOCUMENTO()+"'";
             	    st = conexion.createStatement();
		    ResultSet rs = st.executeQuery(sql);
                   if (rs.next()) {
                        int documento = rs.getInt("DOCUMENTO");
                        String nombres = rs.getString("NOMBRES");
                        String apellidos = rs.getString("APELLIDOS");
                        String sexo = rs.getString("SEXO");
                        String fecha_nacimiento = rs.getString("FECHA_NACIMIENTO");
                        clientes clien = new clientes(documento,nombres,apellidos,sexo,fecha_nacimiento);
                        clientes.add(clien);
                    }
                    
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
               return clientes;
        }
        
        public static List<cuenta> buscarCuenta(cuenta p) {
		List<cuenta> cuenta = new ArrayList<>();
                try {
                    Statement st;
                    String sql = "SELECT * FROM cuenta WHERE NUMERO_CUENTA='"+p.getNUMERO_CUENTA()+"'";
             	    st = conexion.createStatement();
		    ResultSet rs = st.executeQuery(sql);
                   if (rs.next()) {
                        int cuentas = rs.getInt("NUMERO_CUENTA");
                        String tipo = rs.getString("TIPO_CUENTA");
                        int documento = rs.getInt("DOCUMENTO");
                        String oficina = rs.getString("CODIGO_OFICINA");
                        String fecha = rs.getString("FECHA_APERTURA");
                        Double saldo = rs.getDouble("SALDO");
                        cuenta clien = new cuenta(cuentas,tipo,documento,oficina,fecha,saldo);
                        cuenta.add(clien);
                    }
                    
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
               return cuenta;
        }
        
        public static void eliminarCliente(clientes p) {
		PreparedStatement ps;
	        String sql = "DELETE FROM CLIENTES WHERE documento='"+p.getDOCUMENTO()+"'";
                
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        public static void eliminarCuenta(cuenta p) {
		PreparedStatement ps;
	        String sql = "DELETE FROM CUENTA WHERE NUMERO_CUENTA='"+p.getNUMERO_CUENTA()+"'";
                
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
        
        public static void eliminarTransaccion(transaccion p) {
		PreparedStatement ps;
	        String sql = "DELETE FROM transacciones WHERE idtran='"+p.getIDTRAN()+"'";
                
		try {
		    ps = conexion.prepareStatement(sql);
		    ps.executeUpdate();
	        }
		catch (Exception ex) {
			ex.printStackTrace();
		}
        }
	
	public static List<clientes> obtenerCliente(){
		List<clientes> clientes = new ArrayList<>();
		try {
		    Statement st;
		    String sql = "select * from clientes";
		    
		    st = conexion.createStatement();
		    ResultSet rs = st.executeQuery(sql);
		    
		    while (rs.next()) {
                        int documento = rs.getInt("DOCUMENTO");
                        String nombres = rs.getString("NOMBRES");
                        String apellidos = rs.getString("APELLIDOS");
                        String sexo = rs.getString("SEXO");
                        String fecha_nacimiento = rs.getString("FECHA_NACIMIENTO");

                        clientes clien = new clientes(documento,nombres,apellidos,sexo,fecha_nacimiento);
                        clientes.add(clien);
		    }
		    rs.close();
		 }
		 catch (Exception ex) {
			ex.printStackTrace();
		}
		return clientes;
	}
        
        public static List<cuenta> obtenerCuenta(){
		List<cuenta> cuentas = new ArrayList<>();
		try {
		    Statement st;
		    String sql = "select * from cuenta";
		    
		    st = conexion.createStatement();
		    ResultSet rs = st.executeQuery(sql);
		    
		    while (rs.next()) {
                        int cuenta = rs.getInt("NUMERO_CUENTA");
                        String tipo = rs.getString("TIPO_CUENTA");
                        int documento = rs.getInt("DOCUMENTO");
                        String oficina = rs.getString("CODIGO_OFICINA");
                        String fechaa = rs.getString("FECHA_APERTURA");
                        Double saldo = rs.getDouble("SALDO");

                        cuenta cuen = new cuenta(cuenta,tipo,documento,oficina,fechaa,saldo);
                        cuentas.add(cuen);
		    }
		    rs.close();
		 }
		 catch (Exception ex) {
			ex.printStackTrace();
		}
		return cuentas;
	}
        
        public static List<tipo_movimiento> obtenerTipo(){
		List<tipo_movimiento> tipo_movimiento = new ArrayList<>();
		try {
		    Statement st;
		    String sql = "select nombre from tipo_movimiento";
		    
		    st = conexion.createStatement();
		    ResultSet rs = st.executeQuery(sql);
		    
		    while (rs.next()) {
                        int codigo = rs.getInt("CODIGO");
                        String nombre = rs.getString("NOMBRE");
                        int tipo_trasaccion = rs.getInt("TIPO_TRASACCION");

                        tipo_movimiento tipo = new tipo_movimiento(codigo,nombre,tipo_trasaccion);
                        tipo_movimiento.add(tipo);
		    }
		    rs.close();
		 }
		 catch (Exception ex) {
			ex.printStackTrace();
		}
		return tipo_movimiento;
	}
    
}
