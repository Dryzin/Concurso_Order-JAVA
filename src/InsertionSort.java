public class InsertionSort {

    private void insert(Comparable<Candidato>[] v, int i) {
        Comparable<Candidato> eleito = v[i]; // elemento de comparacao
        int comp = i - 1; // inicia antes do eleito, posicao ja ordenada do arry

        while (comp >= 0 && eleito.compareTo((Candidato) v[comp]) > 0) {
            v[comp + 1] = v[comp];
            comp--;
        }
        v[comp + 1] = eleito;
    }

    public void sort(Comparable<Candidato>[] v) {
        for (int i = 1; i < v.length; i++) {
            insert(v, i);  // percorre o array e para cada posição, chama o metodo insert()
        }
    }
}
