import java.util.Scanner;

public class Exercicio62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Piramidator");

        System.out.println("Digite a quantidade de linhas: ");
        int linhas = scanner.nextInt();

        for (int i = 1; i <= linhas; i++) {
            StringBuilder linha = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                if (i < 10) {
                    linha.append(" 0").append(i);
                } else {
                    linha.append(" ").append(i);
                }
            }
            System.out.println(linha.toString());
        }

        scanner.close();
    }
}
