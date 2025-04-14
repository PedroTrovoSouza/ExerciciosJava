package Lista2.Exercicio35;

import java.util.Random;
import java.util.Scanner;

public class NumeroSorteadosUsuario {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int qtdSorteio = 0;
        int maximo = 0;
        Random random = new Random();

        System.out.println("Informe a quantidade de números a serem sorteados: ");
        qtdSorteio = teclado.nextInt();

        System.out.println("Informe a faixa: ");
        maximo = teclado.nextInt();

        for (int i = 1; i <= qtdSorteio; i++){
            int numeroSorteado = random.nextInt(maximo) + 1;
            System.out.println(numeroSorteado);
        }
    }
}
