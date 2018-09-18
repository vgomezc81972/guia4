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
public class transaccion {
    
    private int IDTRAN;
    private int NUMERO_CUENTA;
    private int DOCUMENTO;
    private String TIPO_MOVIMIENTO;
    private String FECHA_TRANSACCION;
    private Double VALOR;
    private int CODIGO_EMPLEADO;

    public transaccion(int IDTRAN, int NUMERO_CUENTA, int DOCUMENTO, String TIPO_MOVIMIENTO, String FECHA_TRANSACCION, Double VALOR, int CODIGO_EMPLEADO) {
        this.IDTRAN = IDTRAN;
        this.NUMERO_CUENTA = NUMERO_CUENTA;
        this.DOCUMENTO = DOCUMENTO;
        this.TIPO_MOVIMIENTO = TIPO_MOVIMIENTO;
        this.FECHA_TRANSACCION = FECHA_TRANSACCION;
        this.VALOR = VALOR;
        this.CODIGO_EMPLEADO = CODIGO_EMPLEADO;
    }

    public int getIDTRAN() {
        return IDTRAN;
    }

    public int getNUMERO_CUENTA() {
        return NUMERO_CUENTA;
    }

    public int getDOCUMENTO() {
        return DOCUMENTO;
    }

    public String getTIPO_MOVIMIENTO() {
        return TIPO_MOVIMIENTO;
    }

    public String getFECHA_TRANSACCION() {
        return FECHA_TRANSACCION;
    }

    public Double getVALOR() {
        return VALOR;
    }

    public int getCODIGO_EMPLEADO() {
        return CODIGO_EMPLEADO;
    }

    @Override
    public String toString() {
        return "transaccion{" + "IDTRAN=" + IDTRAN + ", NUMERO_CUENTA=" + NUMERO_CUENTA + ", DOCUMENTO=" + DOCUMENTO + ", TIPO_MOVIMIENTO=" + TIPO_MOVIMIENTO + ", FECHA_TRANSACCION=" + FECHA_TRANSACCION + ", VALOR=" + VALOR + ", CODIGO_EMPLEADO=" + CODIGO_EMPLEADO + '}';
    }

    
        
    
}
