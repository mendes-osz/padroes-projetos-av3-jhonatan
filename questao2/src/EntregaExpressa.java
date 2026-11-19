public class EntregaExpressa extends DecoradorFatura {
    public EntregaExpressa(IFatura fatura) {
        super(fatura);
    }

    public String getNomeServico() {
        return "Entrega expressa";
    }

    public double getCusto() {
        return 450.00;
    }
}
