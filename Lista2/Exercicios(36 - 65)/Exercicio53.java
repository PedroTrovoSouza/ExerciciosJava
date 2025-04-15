import java.util.Scanner;

public class Exercicio53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao tabuator!");
        System.out.println("Escolha o numero que voce quer a tabuada");
        int tabuator = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            System.out.printf("\n %d x %d = %d", tabuator, (i + 1), (tabuator * (i + 1)));
        }
    }
}
