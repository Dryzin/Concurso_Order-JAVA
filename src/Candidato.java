import java.time.LocalDate;

public class Candidato implements Comparable<Candidato> {

    private int id;
    private String nome;
    private LocalDate dataNasc;
    private Integer nota;

    public Candidato(int id, String nome, LocalDate dataNasc, int nota) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Nome: " + nome + ", Data Nascimento: " + dataNasc + ", Nota: " + nota + '.';
    }

    @Override
    public int compareTo(Candidato candidato) {
        int comparaNota = this.nota.compareTo(candidato.getNota());
        if (comparaNota == 0) {
            return candidato.getDataNasc().compareTo(this.dataNasc);
        }
        return comparaNota;
    }

}
