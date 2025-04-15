import java.util.Scanner;

public class Exercicio51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de termos da sequência de Tribonacci: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("O número de termos deve ser maior que 0.");
        } else {
            exibirTribonacci(n);
        }

        scanner.close();
    }

    public static void exibirTribonacci(int n) {
        long n1 = 1, n2 = 1, n3 = 2;

        if (n >= 1) {
            System.out.print(n1 + " ");
        }
        if (n >= 2) {
            System.out.print(n2 + " ");
        }
        if (n >= 3) {
            System.out.print(n3 + " ");
        }

        for (int i = 4; i <= n; i++) {
            long nextTerm = n1 + n2 + n3;
            System.out.print(nextTerm + " ");

            n1 = n2;
            n2 = n3;
            n3 = nextTerm;
        }

        System.out.println();
    }
}
