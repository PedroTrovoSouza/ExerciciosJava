import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();
        int contador = 1;
        int maior = 0;

        while (contador < 101) {
            System.out.printf("Insira seu %d numero", contador);
            int inserido = scanner.nextInt();
            numeros.add(inserido);
        }

        for (int i = 0; i < 100; i++) {
            if (numeros.get(i) > maior) {
                maior = numeros.get(i);
            }
        }
        System.out.printf("O maior é %d", maior);
    }
}
