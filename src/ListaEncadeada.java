public class ListaEncadeada {

    private No inicio;

    public void inserir(String creche, double distancia) {

        No novo = new No(creche, distancia);

        if (inicio == null) {
            inicio = novo;
            return;
        }

        No atual = inicio;

        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        atual.proximo = novo;
    }

    public int quantidade() {

        int cont = 0;
        No atual = inicio;

        while (atual != null) {
            cont++;
            atual = atual.proximo;
        }

        return cont;
    }

    public Double buscarDistancia(String destino) {

        No atual = inicio;

        while (atual != null) {

            if (atual.creche.equals(destino)) {
                return atual.distancia;
            }

            atual = atual.proximo;
        }

        return null;
    }

    public void listarOrdenado() {

        for (No i = inicio; i != null; i = i.proximo) {

            No menor = i;

            for (No j = i.proximo; j != null; j = j.proximo) {

                if (j.distancia < menor.distancia) {
                    menor = j;
                }
            }

            double d = i.distancia;
            String c = i.creche;

            i.distancia = menor.distancia;
            i.creche = menor.creche;

            menor.distancia = d;
            menor.creche = c;
        }

        No atual = inicio;

        while (atual != null) {

            System.out.println(
                    atual.creche + " - "
                            + atual.distancia + " km"
            );

            atual = atual.proximo;
        }
    }
}