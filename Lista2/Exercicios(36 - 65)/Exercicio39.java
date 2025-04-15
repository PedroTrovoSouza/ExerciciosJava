import java.util.Scanner;

public class Exercicio39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero a ser analisado: ");
        int num = scanner.nextInt();

        int soma = 0;

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                soma += i;
            }
        }

        if (soma == num) {
            System.out.println(num + " é um número perfeito!");
        } else {
            System.out.println(num + " não é um número perfeito.");
        }

        scanner.close();
    }
}
