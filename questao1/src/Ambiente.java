import java.util.ArrayList;

public class Ambiente {
    public String nome;
    public String provedor;
    public ArrayList<IRecurso> recursos = new ArrayList<>();

    public Ambiente(String nome, String provedor) {
        this.nome = nome;
        this.provedor = provedor;
    }

    public double custoMensal() {
        double total = 0;
        for (IRecurso r : recursos) {
            total += r.custoMensal();
        }
        return total;
    }

    public String resumo(String regiao) {
        String texto = "Ambiente: " + nome + "\n";
        texto += "Provedor: " + provedor + "\n";
        texto += "Regiao: " + regiao + "\n";
        for (IRecurso r : recursos) {
            texto += "Recurso: " + r.getId() + "\n";
        }
        texto += "Custo mensal estimado: R$ " + String.format("%.2f", custoMensal()) + "\n";
        return texto;
    }
}
