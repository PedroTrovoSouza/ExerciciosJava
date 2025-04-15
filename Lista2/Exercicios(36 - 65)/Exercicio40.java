import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de integrantes: ");
        int integrantes = scanner.nextInt();
        int contador = 1;
        int media = 0;
        int maioridade = 0;

        List<Integer> idades = new ArrayList<>();

        while (contador < integrantes + 1) {
            System.out.println("Digite a idade do integrante " + contador + ":");
            int idadeDaVez = scanner.nextInt();
            idades.add(idadeDaVez);
            contador++;
        }
        int maior = idades.get(0);
        int menor = idades.get(0);

        for (int i = 0; i < idades.size(); i++) {
            if (idades.get(i) > maior) {
                maior = idades.get(i);
            }
            if (idades.get(i) < menor) {
                menor = idades.get(i);
            }
        }

        for (int i = 0; i < idades.size(); i++) {
            media += idades.get(i);
        }

        for (int i = 0; i < idades.size(); i++) {
            if (idades.get(i) > 17) {
                maioridade++;
            }
        }

        System.out.println("Média das idades: " + media +"\n" +
                            "Maior idade: " + maior +"\n" +
                            "Menor idade: " + menor +"\n" +
                            "Quantidade de pessoas: " + maioridade);
    }
}
