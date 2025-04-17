package Lista1.Exercicio3;

import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("<----- Informe o número inteiro ----->");
        int valor = teclado.nextInt();

        System.out.println("Números primos menores que " + valor + ":");

        for (int i = 2; i < valor; i++) {
            boolean primo = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.println(i);
            }
        }
    }
}
