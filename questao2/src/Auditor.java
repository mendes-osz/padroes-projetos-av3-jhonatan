import java.time.LocalDateTime;
import java.util.ArrayList;

public class Auditor implements IInteressado {
    public ArrayList<String> registros = new ArrayList<>();

    public String getNome() {
        return "Auditor";
    }

    public void atualizar(Lote lote, Lance lance) {
        String registro = LocalDateTime.now() + " | " + lote.nome + " | " + lance.autor.getNome()
                + " | R$ " + String.format("%.2f", lance.valor);
        registros.add(registro);
        System.out.println("[Auditor] " + registro);
    }
}
