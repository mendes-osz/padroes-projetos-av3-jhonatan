public class ImpressoraFatura {
    public static void imprimir(IFatura fatura) {
        System.out.println("--- Fatura do comprador ---");
        System.out.println(fatura.descricao());
        System.out.println("Total a pagar: R$ " + String.format("%.2f", fatura.total()));
    }
}
