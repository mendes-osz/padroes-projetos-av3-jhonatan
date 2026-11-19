

public class SeguroTransporte extends DecoradorFatura {
    public SeguroTransporte(IFatura fatura) {
        super(fatura);
    }

    public String getNomeServico() {
        return "Seguro de transporte";
    }

    public double getCusto() {
        return getValorVenda() * 0.015;
    }
}
