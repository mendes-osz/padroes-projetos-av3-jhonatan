import java.io.FileInputStream;
import java.util.Properties;

public class Configuracao {
    private static Configuracao instance = new Configuracao();

    public String regiao;
    public double orcamento;

    private Configuracao() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("config.properties"));
            regiao = p.getProperty("regiao");
            orcamento = Double.parseDouble(p.getProperty("orcamento"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler config.properties", e);
        }
    }

    public static Configuracao getInstance() {
        return instance;
    }
}
