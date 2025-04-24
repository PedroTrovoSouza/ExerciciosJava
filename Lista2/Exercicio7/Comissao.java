package Lista2.Exercicio7;

import java.util.Scanner;

public class Comissao {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double comissao = 0;

        System.out.println("Informe a sua despesa: ");
        double despesaCliente = teclado.nextDouble();

        comissao = despesaCliente * 0.10;

        System.out.println("Comissão: " + comissao);
    }
}
