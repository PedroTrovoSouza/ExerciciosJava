import java.util.Scanner;

public class Exercicio60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Dividator!");

        System.out.print("Digite o valor da dívida: ");
        double divida = scanner.nextDouble();

        System.out.print("Digite a taxa (% ao mês, ex: 1.8 para 1.8%): ");
        double taxaPercentual = scanner.nextDouble();

        System.out.print("Digite a quantidade de anos: ");
        int anos = scanner.nextInt();

        double taxa = taxaPercentual / 100.0;
        double dividaAtual = divida;

        int totalMeses = anos * 12;

        for (int mes = 1; mes <= totalMeses; mes++) {
            System.out.printf("%.2f\n", dividaAtual);

            dividaAtual += dividaAtual * taxa;
        }
        scanner.close();
    }
}
