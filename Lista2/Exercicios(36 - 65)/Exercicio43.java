import java.util.Scanner;

public class Exercicio43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contador = 1;
        int soma = 0;

        while (contador < 501) {
            System.out.println("Digite o numero " + contador + ":");
            int num = scanner.nextInt();
            soma += num;
            contador++;
        }

        System.out.println("A média é: " + (soma / contador));
    }
}
