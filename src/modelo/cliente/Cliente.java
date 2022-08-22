package modelo.cliente;

import java.math.BigInteger;
import java.util.Date;

import modelo.tipoCliente.Juridica;
import modelo.tipoCliente.Natural;

public class Cliente {
    private String nombres;
    private String apellidos;
    private String numeroIdentificacion;
    private String direccion;
    private String numeroTelefono;
    private String tipoCliente;
    public Juridica juridica;
    public Natural natural;
    
    public Cliente (){
    	natural = new Natural();
    	juridica = new Juridica();
    }


    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroIdentificacion() {
        return this.numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return this.numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getTipoCliente() {
        return this.tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setJuridica(String nit, String numeroIdentificacionT){
        juridica.setNit(nit);
        juridica.setNumeroIdentificacionTributaria(numeroIdentificacionT);
    }

    public void setNatural(String fechaNacimiento, String email){
        natural.setEmail(email);
        natural.setFechaNacimiento(fechaNacimiento);
    }
}
