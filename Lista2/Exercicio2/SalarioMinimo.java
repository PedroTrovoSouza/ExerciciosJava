package Lista2.Exercicio2;

import java.util.Scanner;

public class SalarioMinimo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe o seu salário atual: ");
        double salarioUsuario = teclado.nextDouble();

        System.out.print("Informe o valor do salário mínimo atual: ");
        double salarioMinimo = teclado.nextDouble();

        double qtdSalarioMinimo = salarioUsuario / salarioMinimo;

        System.out.print("Quantidade de salários mínimos: " + Math.round(qtdSalarioMinimo));
    }
}
