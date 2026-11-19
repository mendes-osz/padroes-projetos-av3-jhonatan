public class EmbalagemEspecial extends DecoradorFatura {
    public EmbalagemEspecial(IFatura fatura) {
        super(fatura);
    }

    public String getNomeServico() {
        return "Embalagem especial";
    }

    public double getCusto() {
        return 180.00;
    }
}
