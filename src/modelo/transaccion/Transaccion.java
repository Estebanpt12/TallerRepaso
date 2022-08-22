package modelo.transaccion;

public class Transaccion {
    private String codigo;
    private String fecha;
    private String cliente;
    private int total;
    private float iva;
    private DetalleTransaccion detalleTransaccion;

    public Transaccion() {
        detalleTransaccion = new DetalleTransaccion();
    }
    
    public String getTotalString(){
        return String.valueOf(total);
    }

    public String getDetalleCantidad(){
        return String.valueOf(detalleTransaccion.getCantidadProductos());
    }

    public String getDetalleSubtotal(){
        return String.valueOf(detalleTransaccion.getSubTotal());
    }

    public String getDetalleCodigo(){
        return detalleTransaccion.getCodigoProducto();
    }

    public String getIvaString(){
        return String.valueOf(iva);
    }

    public void setDetalleCantidad(short cantidad){
        detalleTransaccion.setCantidadProductos(cantidad);
    }

    public void setDetalleSubtotal(int subTotal){
        detalleTransaccion.setSubTotal(subTotal);;
    }

    public void setDetalleProducto(String codigoProducto){
        detalleTransaccion.setCodigoProducto(codigoProducto);
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getIva() {
        return this.iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }
}
