package Lista2.Exercicio23;

import java.util.Scanner;

public class AniversarioPrimeiro {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome1 = "";
        int dia1 = 0;
        int mes1 = 0;

        String nome2 = "";
        int dia2 = 0;
        int mes2 = 0;

        System.out.println("Informe seu nome: ");
        nome1 = teclado.nextLine();

        System.out.println("Informe o dia do seu aniversário");
        dia1 = teclado.nextInt();

        System.out.println("Informe o mes do seu aniversario");
        mes1 = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Informe seu nome: ");
        nome2 = teclado.nextLine();

        System.out.println("Informe o dia do seu aniversário");
        dia2 = teclado.nextInt();

        System.out.println("Informe o mes do seu aniversario");
        mes2 = teclado.nextInt();

        if(dia1 < dia2 && mes1 < mes2){
            System.out.println(nome2);
        }else {
            System.out.println(nome1);
        }
    }
}
