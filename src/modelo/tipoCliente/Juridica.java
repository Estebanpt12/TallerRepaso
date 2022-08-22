package modelo.tipoCliente;

import java.math.BigInteger;

public class Juridica {
    private String nit;
    private String numeroIdentificacionTributaria;

    public Juridica(){}

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNumeroIdentificacionTributaria() {
        return this.numeroIdentificacionTributaria;
    }

    public void setNumeroIdentificacionTributaria(String numeroIdentificacionTributaria) {
        this.numeroIdentificacionTributaria = numeroIdentificacionTributaria;
    }

}
