import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Candidato> carregarCSV(String filePath) {
        List<Candidato> candidatos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { // trata de finalizar mesmo com excecao
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formatar data

                String[] v = line.split(",");

                // criacao de um candidato
                int id = Integer.parseInt(v[0]);
                String nome = v[1];
                LocalDate dataNasc = LocalDate.parse(v[2], formatter);
                int nota = Integer.parseInt(v[3]);

                candidatos.add(new Candidato(id, nome, dataNasc, nota));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return candidatos;
    }

    public static void main(String[] args) {
        String filePath = "..//Concurso_Order-JAVA/dadosConcurso.csv";
        List<Candidato> candidatos = carregarCSV(filePath);

        InsertionSort iSort = new InsertionSort();
        Candidato[] vetC = candidatos.toArray(new Candidato[0]); // converte para array para insertSort

        iSort.sort(vetC);

        for (int i = 0; i < vetC.length; i++) {
            System.out.println((i + 1) + "° lugar: " + vetC[i]);
        }
    }

}
