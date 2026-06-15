public class Main {

    public static void main(String[] args)
            throws Exception {

        Grafo grafo = new Grafo();

        grafo.carregarArquivo("dados/dados.txt");

        grafo.mostrarQuantidadeConexoes();

        grafo.listarConexoes(
                "JoaoGama"
        );

        grafo.distanciaEntre(
                "PedroFernandes",
                "HerculanoDeMelo"
        );

        grafo.adicionarConexao(
                "JoseVicente",
                "PedroFernandes",
                8.0
        );

        System.out.println(
                "\nNova conexão adicionada."
        );

        grafo.distanciaEntre(
                "JoseVicente",
                "PedroFernandes"
        );

        grafo.mostrarMatriz();
    }
}
