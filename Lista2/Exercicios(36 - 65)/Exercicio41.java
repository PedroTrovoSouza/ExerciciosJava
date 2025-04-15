import java.util.Random;
import java.util.Scanner;

public class Exercicio41 {
    public static int numeroAleatorio(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean acertou = false;
        int tentativas = 1;

        System.out.println("Adivinhator!!!");
        Integer aleatorio = numeroAleatorio(1, 100);
        System.out.println(aleatorio);


        while(acertou == false) {
            System.out.println("Advinhe um numero gerado entre 1 e 100");
            Integer num = scanner.nextInt();
            if (num.equals(aleatorio)) {
                System.out.println("Acertou o número " + aleatorio + " Em " + tentativas + " tentativas.");
                acertou = true;
            } else {
                System.out.println("Errou");
                tentativas++;
            }
        }
    }
}
