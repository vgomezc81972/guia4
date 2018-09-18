/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author victorjulio
 */
public class clientes {

    private int DOCUMENTO;
    private String NOMBRES;
    private String APELLIDOS;
    private String SEXO; 
    private String FECHA_NACIMIENTO;

    public clientes(int DOCUMENTO, String NOMBRES, String APELLIDOS, String SEXO, String FECHA_NACIMIENTO) {
        this.DOCUMENTO = DOCUMENTO;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.SEXO = SEXO;
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }

    clientes(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDOCUMENTO() {
        return DOCUMENTO;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }
    
    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public String getSEXO() {
        return SEXO;
    }

    public String getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    @Override
    public String toString() {
        return "clientes{" + "DOCUMENTO=" + DOCUMENTO + ", NOMBRES=" + NOMBRES + ", APELLIDOS=" + APELLIDOS + ", SEXO=" + SEXO + ", FECHA_NACIMIENTO=" + FECHA_NACIMIENTO + '}';
    }

            
    
}
