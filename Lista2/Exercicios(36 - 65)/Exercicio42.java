import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Exercicio42 {
    public static void main(String[] args) {
        Random random = new Random();

        int numeroDeGrupos = 40;
        int numerosPorGrupo = 3;

        for (int grupo = 1; grupo <= numeroDeGrupos; grupo++) {
            List<Integer> grupoDeNumeros = new ArrayList<>();

            while (grupoDeNumeros.size() < numerosPorGrupo) {
                int numeroSorteado = random.nextInt(60); // Gera número entre 0 e 59
                if (!grupoDeNumeros.contains(numeroSorteado)) {
                    grupoDeNumeros.add(numeroSorteado);
                }
            }

            Collections.sort(grupoDeNumeros);

            System.out.println("Grupo " + grupo + ": " + grupoDeNumeros);
        }
    }
}
