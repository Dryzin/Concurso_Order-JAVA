public class InsertionSort {

    private void insert(Comparable<Candidato>[] v, int i) {
        Comparable<Candidato> eleito = v[i];
        int comp = i - 1;

        while (comp >= 0 && eleito.compareTo((Candidato) v[comp]) > 0) {
            v[comp + 1] = v[comp];
            comp--;
        }
        v[comp + 1] = eleito;
    }

    public void sort(Comparable<Candidato>[] v) {
        for (int i = 1; i < v.length; i++) {
            insert(v, i);
        }
    }
}
