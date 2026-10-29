
public class Gasto {

    private String concepto;
    private double importe;
    private String categoria;

    public Gasto(String concepto, double importe, String categoria) {
        this.concepto = concepto;
        this.importe = importe;
        this.categoria = categoria;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getImporte() {
        return importe;
    }

    public String getCategoria() {
        return categoria;
    }
}
