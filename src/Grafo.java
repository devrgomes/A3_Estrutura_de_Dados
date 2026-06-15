import java.io.BufferedReader;
import java.io.FileReader;

public class Grafo {

    private final int MAX = 50;

    private String[] creches = new String[MAX];

    private int quantidadeCreches = 0;

    private int[][] matrizAdj = new int[MAX][MAX];

    private ListaEncadeada[] listas =
            new ListaEncadeada[MAX];

    public Grafo() {

        for (int i = 0; i < MAX; i++) {
            listas[i] = new ListaEncadeada();
        }
    }

    private int obterIndice(String nome) {

        for (int i = 0; i < quantidadeCreches; i++) {

            if (creches[i].equals(nome)) {
                return i;
            }
        }

        creches[quantidadeCreches] = nome;

        return quantidadeCreches++;
    }

    private int buscarIndice(String nome) {

        for (int i = 0; i < quantidadeCreches; i++) {

            if (creches[i].equals(nome)) {
                return i;
            }
        }

        return -1;
    }

    public void carregarArquivo(String arquivo)
            throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new FileReader(arquivo));

        String linha;

        while ((linha = br.readLine()) != null) {

            String[] dados = linha.split(";");

            String origem = dados[0];
            String destino = dados[1];
            double distancia =
                    Double.parseDouble(dados[2]);

            adicionarConexao(
                    origem,
                    destino,
                    distancia
            );
        }

        br.close();
    }

    public void adicionarConexao(
            String origem,
            String destino,
            double distancia) {

        int i = obterIndice(origem);
        int j = obterIndice(destino);

        matrizAdj[i][j] = 1;
        matrizAdj[j][i] = 1;

        listas[i].inserir(destino, distancia);
        listas[j].inserir(origem, distancia);
    }

    public void mostrarQuantidadeConexoes() {

        System.out.println(
                "\nQuantidade de conexões:"
        );

        for (int i = 0; i < quantidadeCreches; i++) {

            System.out.println(
                    creches[i]
                            + " -> "
                            + listas[i].quantidade()
                            + " conexões"
            );
        }
    }

    public void listarConexoes(String creche) {

        int indice = buscarIndice(creche);

        if (indice == -1) {

            System.out.println(
                    "Creche não encontrada."
            );

            return;
        }

        System.out.println(
                "\nConexões de " + creche
        );

        listas[indice].listarOrdenado();
    }

    public void distanciaEntre(
            String origem,
            String destino) {

        int indice = buscarIndice(origem);

        if (indice == -1) {

            System.out.println(
                    "Creche não encontrada."
            );

            return;
        }

        Double distancia =
                listas[indice]
                        .buscarDistancia(destino);

        if (distancia == null) {

            System.out.println(
                    "Não existe ligação direta."
            );

        } else {

            System.out.println(
                    "\nDistância entre "
                            + origem
                            + " e "
                            + destino
                            + ": "
                            + distancia
                            + " km"
            );
        }
    }

    public void mostrarMatriz() {

        System.out.println(
                "\nMatriz de Adjacência"
        );

        for (int i = 0; i < quantidadeCreches; i++) {

            for (int j = 0; j < quantidadeCreches; j++) {

                System.out.print(
                        matrizAdj[i][j] + " "
                );
            }

            System.out.println();
        }
    }
}