package Lista2.Exercicio20;

import java.util.Scanner;

public class PessoaMaisVelha {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome1 = "";
        int idade1 = 0;
        String nome2 = "";
        int idade2 = 0;

        System.out.println("Informe seu nome: ");
        nome1 = teclado.nextLine();

        System.out.println("Informe sua idade: ");
        idade1 = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Informe seu nome: ");
        nome2 = teclado.nextLine();

        System.out.println("Informe sua idade: ");
        idade2 = teclado.nextInt();

        System.out.println("\nOrdem da pessoa mais velha para a mais nova:");
        if (idade1 < idade2) {
            System.out.println(nome2);
            System.out.println(nome1);
        } else {
            System.out.println(nome1);
            System.out.println(nome2);
        }
    }
}
