import java.util.Scanner;

public class Exercicio36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o numero minimo");
        int min = scanner.nextInt();

        System.out.println("Digite o numero maximo");
        int max = scanner.nextInt();

        for (int i = min; i < max; i++) {
            if (!(i % 2 == 0)) {
                System.out.println("Numero impar entre a faixa: " + i);
            }
        }
    }
}
