package Lista1.Exercicio2;

import java.util.Scanner;

public class MostrarMaior {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("<----- Informe o primeiro valor ----->");
        double valor1 = teclado.nextDouble();

        System.out.println("<----- Informe o segundo valor ----->");
        double valor2 = teclado.nextDouble();

        if(valor1 < valor2){
            System.out.println("O maior valor é: " + valor2);
        }else {
            System.out.println("O maior valor é: " + valor1);
        }
    }
}
