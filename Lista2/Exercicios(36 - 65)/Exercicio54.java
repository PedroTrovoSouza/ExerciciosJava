import java.util.Scanner;

public class Exercicio54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Dollarficator");

        System.out.println("Digite o valor que voce quer converter para dolar: ");
        double valorReal = scanner.nextDouble();

        System.out.println("Digite o valor do Dolar(unidade): ");
        double valorUmDolar = scanner.nextDouble();

        System.out.printf("Seus real em dolar está a: %.2f", (valorReal * valorUmDolar));
    }
}
