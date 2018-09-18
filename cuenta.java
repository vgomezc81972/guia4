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
public class cuenta {
   
    private int NUMERO_CUENTA;
    private String TIPO_CUENTA;
    private int DOCUMENTO;
    private String CODIGO_OFICINA;
    private String FECHA_APERTURA;
    private Double SALDO;

    public cuenta(int NUMERO_CUENTA, String TIPO_CUENTA, int DOCUMENTO, String CODIGO_OFICINA, String FECHA_APERTURA, Double SALDO) {
        this.NUMERO_CUENTA = NUMERO_CUENTA;
        this.TIPO_CUENTA = TIPO_CUENTA;
        this.DOCUMENTO = DOCUMENTO;
        this.CODIGO_OFICINA = CODIGO_OFICINA;
        this.FECHA_APERTURA = FECHA_APERTURA;
        this.SALDO = SALDO;
    }

    public int getNUMERO_CUENTA() {
        return NUMERO_CUENTA;
    }

    public String getTIPO_CUENTA() {
        return TIPO_CUENTA;
    }

    public int getDOCUMENTO() {
        return DOCUMENTO;
    }

    public String getCODIGO_OFICINA() {
        return CODIGO_OFICINA;
    }

    public String getFECHA_APERTURA() {
        return FECHA_APERTURA;
    }

    public Double getSALDO() {
        return SALDO;
    }

    @Override
    public String toString() {
        return "cuenta{" + "NUMERO_CUENTA=" + NUMERO_CUENTA + ", TIPO_CUENTA=" + TIPO_CUENTA + ", DOCUMENTO=" + DOCUMENTO + ", CODIGO_OFICINA=" + CODIGO_OFICINA + ", FECHA_APERTURA=" + FECHA_APERTURA + ", SALDO=" + SALDO + '}';
    }
    
        
}
