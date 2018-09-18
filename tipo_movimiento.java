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
public class tipo_movimiento {
 
    private int CODIGO;
    private String NOMBRE;
    private int TIPO_TRASACCION;

    public tipo_movimiento(int CODIGO, String NOMBRE, int TIPO_TRASACCION) {
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.TIPO_TRASACCION = TIPO_TRASACCION;
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public int getTIPO_TRASACCION() {
        return TIPO_TRASACCION;
    }

    @Override
    public String toString() {
        return "tipo_movimiento{" + "CODIGO=" + CODIGO + ", NOMBRE=" + NOMBRE + ", TIPO_TRASACCION=" + TIPO_TRASACCION + '}';
    }
    
    
    
}
