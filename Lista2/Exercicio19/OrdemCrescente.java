package Lista2.Exercicio19;

import java.util.Scanner;

public class OrdemCrescente {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double valor1 = 0;
        double valor2 = 0;

        System.out.print("Informe o primeiro número: ");
        valor1 = teclado.nextDouble();

        System.out.print("Informe o segundo número: ");
        valor2 = teclado.nextDouble();

        if(valor1 < valor2){
            System.out.println(valor2);
            System.out.println(valor1);
        }else {
            System.out.println(valor1);
            System.out.println(valor2);
        }
    }
}
