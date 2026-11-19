public class Participante implements IInteressado {
    public String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void atualizar(Lote lote, Lance lance) {
        System.out.println("[" + nome + "] Novo lance no lote " + lote.nome + ": R$ " + String.format("%.2f", lance.valor));
    }
}
