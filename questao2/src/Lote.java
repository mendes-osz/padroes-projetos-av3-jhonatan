import java.util.ArrayList;

public class Lote {
    public String nome;
    public String categoria;
    public double precoInicial;
    public double precoReserva;
    public double lanceAtual;
    public boolean aberto = true;
    public boolean vendido = false;
    public double valorVenda;
    public double comissao;
    public IInteressado comprador;
    public IRegraComissao regra;
    public ArrayList<Lance> lances = new ArrayList<>();
    public ArrayList<IInteressado> interessados = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, IRegraComissao regra) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regra = regra;
    }

    public void adicionarInteressado(IInteressado i) {
        interessados.add(i);
    }

    public void removerInteressado(IInteressado i) {
        interessados.remove(i);
    }

    public void notificar(Lance lance) {
        for (IInteressado i : interessados) {
            if (i != lance.autor) {
                i.atualizar(this, lance);
            }
        }
    }

    public boolean darLance(IInteressado autor, double valor) {
        if (!aberto) {
            System.out.println("Lance de " + autor.getNome() + " RECUSADO: o lote " + nome + " esta encerrado");
            return false;
        }
        if (valor < lanceAtual * 1.05) {
            System.out.println("Lance de " + autor.getNome() + " (R$ " + String.format("%.2f", valor) + ") RECUSADO: precisa ser pelo menos 5% maior que R$ "
                    + String.format("%.2f", lanceAtual));
            return false;
        }
        lanceAtual = valor;
        Lance lance = new Lance(autor, valor);
        lances.add(lance);
        System.out.println("Lance de " + autor.getNome() + " ACEITO no lote " + nome + ": R$ " + String.format("%.2f", valor));
        notificar(lance);
        return true;
    }

    public void trocarRegra(IRegraComissao novaRegra) {
        if (aberto) {
            regra = novaRegra;
        }
    }

    public void encerrar() {
        aberto = false;
        if (!lances.isEmpty() && lanceAtual >= precoReserva) {
            vendido = true;
            valorVenda = lanceAtual;
            comprador = lances.get(lances.size() - 1).autor;
            comissao = regra.calcular(valorVenda);
            System.out.println("Lote " + nome + " VENDIDO para " + comprador.getNome() + " por R$ " + String.format("%.2f", valorVenda));
        } else {
            System.out.println("Lote " + nome + " NAO VENDIDO (reserva de R$ " + String.format("%.2f", precoReserva) + " nao atingida)");
        }
    }

    public void imprimirAcerto() {
        System.out.println("--- Acerto do vendedor: " + nome + " ---");
        System.out.println("Valor de venda: R$ " + String.format("%.2f", valorVenda));
        System.out.println("Comissao cobrada: R$ " + String.format("%.2f", comissao));
        System.out.println("Valor liquido a repassar: R$ " + String.format("%.2f", valorVenda - comissao));
    }
}
