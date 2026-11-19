public class ComissaoEletronicos implements IRegraComissao {
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * 0.12, 50.00);
    }
}
