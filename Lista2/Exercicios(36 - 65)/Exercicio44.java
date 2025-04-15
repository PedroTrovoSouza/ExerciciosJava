import java.util.Scanner;

public class Exercicio44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha quantos numeros quer");
        int quantidade = scanner.nextInt();
        int contador = 1;
        int soma = 0;

        while (contador < quantidade) {
            System.out.println("Digite o numero #" + quantidade + ":");
            int num = scanner.nextInt();
            soma += num;
            contador++;
        }

        System.out.println("A média é: " + (soma / contador));
    }
}
