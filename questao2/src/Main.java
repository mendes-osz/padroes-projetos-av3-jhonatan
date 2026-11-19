public class Main {
    public static void main(String[] args) {
        Lote escultura = new Lote("Escultura", "Arte", 1000, 1200, new ComissaoArte());
        Lote sintetizador = new Lote("Sintetizador", "Eletronicos", 2000, 3000, new ComissaoEletronicos());

        Participante lukas = new Participante("Lukas");
        Participante nicole = new Participante("Nicole");
        Participante marcos = new Participante("Marcos");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        escultura.adicionarInteressado(lukas);
        escultura.adicionarInteressado(nicole);
        escultura.adicionarInteressado(marcos);
        escultura.adicionarInteressado(painel);
        escultura.adicionarInteressado(auditor);

        sintetizador.adicionarInteressado(lukas);
        sintetizador.adicionarInteressado(marcos);
        sintetizador.adicionarInteressado(painel);
        sintetizador.adicionarInteressado(auditor);

        System.out.println("=== Lances na Escultura ===");
        escultura.darLance(lukas, 1100);
        escultura.darLance(nicole, 1120);
        escultura.darLance(nicole, 1200);
        System.out.println("\n(Marcos deixa de acompanhar a Escultura)");
        escultura.removerInteressado(marcos);
        escultura.darLance(lukas, 1300);

        System.out.println("\n=== Campanha: Escultura passa a usar a regra de Eletronicos ===");
        escultura.trocarRegra(new ComissaoEletronicos());

        System.out.println("\n=== Encerramento da Escultura ===");
        escultura.encerrar();

        System.out.println("\n=== Lances no Sintetizador ===");
        sintetizador.darLance(marcos, 2200);
        sintetizador.darLance(lukas, 2500);

        System.out.println("\n=== Encerramento do Sintetizador ===");
        sintetizador.encerrar();
        sintetizador.darLance(nicole, 2800);

        System.out.println("\n=== Fatura da Escultura (comprador: " + escultura.comprador.getNome() + ") ===");
        IFatura fatura = new FaturaBase(escultura.nome, escultura.valorVenda);
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);
        ImpressoraFatura.imprimir(fatura);

        System.out.println();
        escultura.imprimirAcerto();
    }
}
