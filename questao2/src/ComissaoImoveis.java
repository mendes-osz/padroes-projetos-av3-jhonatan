public class ComissaoImoveis implements IRegraComissao {
    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + 1500.00;
    }
}
