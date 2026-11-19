import java.time.LocalDateTime;

public class Registro {
    public LocalDateTime dataHora;
    public String ambiente;
    public String provedor;
    public String resultado;

    public Registro(String ambiente, String provedor, String resultado) {
        this.dataHora = LocalDateTime.now();
        this.ambiente = ambiente;
        this.provedor = provedor;
        this.resultado = resultado;
    }

    public String toString() {
        return dataHora + " | " + ambiente + " | " + provedor + " | " + resultado;
    }
}
