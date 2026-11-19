public abstract class DecoradorFatura implements IFatura {
    public IFatura fatura;

    public DecoradorFatura(IFatura fatura) {
        this.fatura = fatura;
    }

    public abstract String getNomeServico();

    public abstract double getCusto();

    public String descricao() {
        return fatura.descricao() + "\n  + " + getNomeServico() + ": R$ " + String.format("%.2f", getCusto());
    }

    public double total() {
        return fatura.total() + getCusto();
    }

    public double getValorVenda() {
        return fatura.getValorVenda();
    }
}
