public class PainelLeiloeiro implements IInteressado {
    public String getNome() {
        return "Painel do leiloeiro";
    }

    public void atualizar(Lote lote, Lance lance) {
        System.out.println("[Painel] Lote " + lote.nome + " | maior lance: R$ " + String.format("%.2f", lote.lanceAtual)
                + " | total de lances: " + lote.lances.size());
    }
}
