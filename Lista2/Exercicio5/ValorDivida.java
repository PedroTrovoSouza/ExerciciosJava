package Lista2.Exercicio5;

import java.util.Scanner;

public class ValorDivida {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Valor inicial do débito: ");
        double valorInicial = teclado.nextDouble();

        System.out.print("Informe a quantidade de meses: ");
        double qtdMeses = teclado.nextDouble();

        System.out.print("Informe o valor dos juros mensais: ");
        double valorJuros = teclado.nextDouble();

        double valorDaDivida = valorInicial * (1 + valorJuros * qtdMeses);

        System.out.print("Valor da dívida: " + valorDaDivida);
    }
}
