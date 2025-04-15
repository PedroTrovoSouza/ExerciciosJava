import java.util.Scanner;

public class Exercicio61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Piramidator");

        System.out.println("Digite a quantidade de linhas: ");
        int linhas = scanner.nextInt();
        for (int i = 1; i <= linhas; i++) {
            String aster = "";
            for (int j = 1; j <= i; j++) {
                aster += "*";
            }
            System.out.println(aster);
        }
    }
}
