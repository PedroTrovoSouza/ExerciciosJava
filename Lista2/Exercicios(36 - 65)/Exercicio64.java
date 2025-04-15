import java.util.Scanner;

public class Exercicio64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Piramidator");

        System.out.println("Digite a quantidade de linhas: ");
        int linhas = scanner.nextInt();

        for (int i = 0; i < linhas; i++) {
            StringBuilder linha = new StringBuilder();

            for (int espacos = 1; espacos <= linhas - i; espacos++) {
                linha.append(" ");
            }

            for (int estrelas = 1; estrelas <= (2 * i - 1); estrelas++) {
                linha.append("*");
            }

            System.out.println(linha);
        }
        scanner.close();
    }
}
