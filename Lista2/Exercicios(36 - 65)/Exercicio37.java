import java.util.Scanner;

public class Exercicio37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro para calcular o fatorial: ");
        int num = scanner.nextInt();

        long fatorial = 1;

        for (int i = 1; i <= num; i++) {
            fatorial += i;
        }

        System.out.println("O fatorial de " + num + " é: " + fatorial);
        scanner.close();
    }
}
