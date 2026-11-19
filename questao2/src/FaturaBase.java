public class FaturaBase implements IFatura {
    public String nomeLote;
    public double valorVenda;

    public FaturaBase(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    public String descricao() {
        return "Lote: " + nomeLote + "\nValor de venda: R$ " + String.format("%.2f", valorVenda);
    }

    public double total() {
        return valorVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }
}
