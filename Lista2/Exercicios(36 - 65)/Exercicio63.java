import java.util.Scanner;

public class Exercicio63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Piramidator");

        System.out.println("Digite a quantidade de linhas: ");
        int linhas = scanner.nextInt();
        int numero = 1;

        for (int i = 1; i <= linhas; i++) {
            StringBuilder aster = new StringBuilder("");
            for (int j = i; j > 0; j--) {
                if (j < 10) {
                    aster = aster.insert(0, " 0" + j);
                } else {
                    aster = aster.insert(0, " " + j);
                }
            }
            System.out.println(aster);
        }
    }
}
