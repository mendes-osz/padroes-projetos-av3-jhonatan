public class ComissaoVeiculos implements IRegraComissao {
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * 0.08, 5000.00);
    }
}
