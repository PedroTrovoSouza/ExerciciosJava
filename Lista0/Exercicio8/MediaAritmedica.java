package Exercicio8;

import java.util.Scanner;

public class MediaAritmedica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contador = 0;
        double soma = 0;

        while (contador < 50) {
            System.out.print("Digite o " + (contador + 1) + "º número: ");
            double numero = scanner.nextDouble();
            soma += numero;
            contador++;
        }

        double media = soma / 50;
        System.out.println("A média aritmética dos 50 números é: " + media);

        scanner.close();
    }
}
