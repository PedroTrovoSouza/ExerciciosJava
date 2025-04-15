import java.util.Scanner;

public class Exercicio50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de n para obter o n-ésimo número da sequência de Fibonacci: ");
        int n = scanner.nextInt();

        System.out.println("O " + n + "-ésimo número da sequência de Fibonacci é: " + fibonacci(n));

        scanner.close();
    }

    public static int fibonacci(int n) {
        int n1 = 1, n2 = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        int resultado = 0;
        for (int i = 3; i <= n; i++) {
            resultado = n1 + n2;
            n1 = n2;
            n2 = resultado;
        }
        return resultado;
    }
}
