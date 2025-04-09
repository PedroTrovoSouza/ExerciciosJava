package Exercicio9;

import java.util.Scanner;

public class MediaAritmedica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int contador = 0;
        double soma = 0;

        do{
            System.out.print("Digite o " + (contador + 1) + "º número: ");
            double numero = scanner.nextDouble();
            soma += numero;
            contador++;
        } while (contador < 50);

        double media = soma / 50;
        System.out.println("A média aritmética dos 50 números é: " + media);

        scanner.close();
    }
}
