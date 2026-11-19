import java.util.ArrayList;

public class HistoricoAuditoria {
    private static HistoricoAuditoria instance = new HistoricoAuditoria();

    public ArrayList<Registro> registros = new ArrayList<>();

    private HistoricoAuditoria() {
    }

    public static HistoricoAuditoria getInstance() {
        return instance;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(new Registro(ambiente, provedor, resultado));
    }

    public synchronized void imprimir() {
        for (Registro r : registros) {
            System.out.println(r);
        }
    }
}
