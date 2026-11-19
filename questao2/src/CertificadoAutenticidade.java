public class CertificadoAutenticidade extends DecoradorFatura {
    public CertificadoAutenticidade(IFatura fatura) {
        super(fatura);
    }

    public String getNomeServico() {
        return "Certificado de autenticidade";
    }

    public double getCusto() {
        return 300.00;
    }
}
