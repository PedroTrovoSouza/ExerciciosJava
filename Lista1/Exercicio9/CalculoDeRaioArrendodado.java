package Lista1.Exercicio9;

import java.util.Scanner;

public class CalculoDeRaioArrendodado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double pi = 3.14;

        System.out.println("<----- Informe o raio ----->");
        double raio = teclado.nextDouble();

        double resultado = pi * (raio * raio);
        System.out.println("Valor da área: " + Math.round(resultado));
    }
}
