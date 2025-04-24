package Lista2.Exercicio22;

import java.util.Scanner;

public class VerificandoDatas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dia1 = 0;
        int mes1 = 0;
        int dia2 = 0;
        int mes2 = 0;

        System.out.println("informe o dia");
        dia1 = teclado.nextInt();
        System.out.println("informe o mes");
        mes1 = teclado.nextInt();

        System.out.println("informe o dia");
        dia2 = teclado.nextInt();
        System.out.println("informe o mes");
        mes2 = teclado.nextInt();

        if(dia1 == dia2 && mes1 == mes2){
            System.out.println("As datas são iguais");
        }else {
            System.out.println("As datas não são iguais");
        }

    }
}
