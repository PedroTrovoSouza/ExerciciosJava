package Lista2.Exercicio27;

import java.util.Scanner;

public class MaiorDos3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double valor1, valor2, valor3;

        System.out.println("Informe o primeiro valor: ");
        valor1 = teclado.nextDouble();

        System.out.println("Informe o segundo valor: ");
        valor2 = teclado.nextDouble();

        System.out.println("Informe o terceiro valor: ");
        valor3 = teclado.nextDouble();

        if (valor1 == valor2 && valor2 == valor3) {
            System.out.println("Todos os valores são iguais.");
        } else {
            double maior;

            if (valor1 >= valor2 && valor1 >= valor3) {
                maior = valor1;
            } else if (valor2 >= valor1 && valor2 >= valor3) {
                maior = valor2;
            } else {
                maior = valor3;
            }
            System.out.println("O maior valor é: " + maior);
        }
    }
}
