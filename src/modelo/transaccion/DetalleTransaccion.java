package modelo.transaccion;

public class DetalleTransaccion {
    private short cantidadProductos;
    private int subTotal;
    private String codigoProducto;

    public DetalleTransaccion(){
    }


    public short getCantidadProductos() {
        return this.cantidadProductos;
    }

    public void setCantidadProductos(short cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getSubTotal() {
        return this.subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

}
