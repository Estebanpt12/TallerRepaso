package modelo.producto;

import java.util.Date;

import modelo.tipoProducto.Envasados;
import modelo.tipoProducto.Perecederos;
import modelo.tipoProducto.Refrigerados;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int valorUnitario;
    private int cantidadExistencia;
    private String tipoProducto;
    private Envasados envasados;
    private Perecederos perecederos;
    private Refrigerados refrigerados;

    public Producto() {
        perecederos = new Perecederos();
        envasados = new Envasados();
        refrigerados = new Refrigerados();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValorUnitario() {
        return this.valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidadExistencia() {
        return this.cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public String getTipoProducto() {
        return this.tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setEnvasado(String fechaEnvasado,float pesoEnvase, String paisEnvase){
        envasados.setFechaEnvasado(fechaEnvasado);
        envasados.setPaisEnvase(paisEnvase);
        envasados.setPesoEnvase(pesoEnvase);
    }

    public void setEnvasadoFecha(String fechaEnvasado){
        envasados.setFechaEnvasado(fechaEnvasado);
    }
    
    public String getEnvasadoFecha(){
        return envasados.getFechaEnvasado();
    }
    
    public void setEnvasadoPeso(float pesoEnvase){
        envasados.setPesoEnvase(pesoEnvase);
    }
    
    public String getEnvasadoPeso(){
        return String.valueOf(envasados.getPesoEnvase());
    }
    
    public void setEnvasadoPais(String paisEnvase){
        envasados.setPaisEnvase(paisEnvase);
    }
    
    public String getEnvasadoPais(){
        return envasados.getPaisEnvase();
    }
    
    public void setPerecederos(String fechaVencimiento){
        perecederos.setFechaVencimiento(fechaVencimiento);
    }
    
    public String getPerecederos(){
        return perecederos.getFechaVencimiento();
    }

    public void setRefrigerados(String codigoAprobacion, float temperaturaRecomendada){
        refrigerados.setCodigoAprobacion(codigoAprobacion);
        refrigerados.setTemperaturaRecomendada(temperaturaRecomendada);
    }
    
    public void setRefrigeradosCodigo(String codigoAprobacion){
        refrigerados.setCodigoAprobacion(codigoAprobacion);
    }
    
    public String getRefrigeradosCodigo(){
        return refrigerados.getCodigoAprobacion();
    }
    
    public String getRefrigeradosTemperatura(){
        return String.valueOf(refrigerados.getTemperaturaRecomendada());
    }
    
    public void setRefrigeradosTemperatura(float temperaturaRecomendada){
        refrigerados.setTemperaturaRecomendada(temperaturaRecomendada);
    }
}
