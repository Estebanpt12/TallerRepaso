package modelo.tipoProducto;


public class Envasados {
    private String fechaEnvasado;
    private float pesoEnvase;
    private String paisEnvase;

    public Envasados() {
    }

    public String getFechaEnvasado() {
        return this.fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public float getPesoEnvase() {
        return this.pesoEnvase;
    }

    public void setPesoEnvase(float pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public String getPaisEnvase() {
        return this.paisEnvase;
    }

    public void setPaisEnvase(String paisEnvase) {
        this.paisEnvase = paisEnvase;
    }
}
