package Lista2.Exercicio28;

import java.util.Scanner;

public class OrdemCrescente {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double numero1, numero2, numero3;
        double menor, meio, maior;

        System.out.println("Digite o primeiro número:");
        numero1 = teclado.nextDouble();

        System.out.println("Digite o segundo número:");
        numero2 = teclado.nextDouble();

        System.out.println("Digite o terceiro número:");
        numero3 = teclado.nextDouble();

        if (numero1 <= numero2 && numero1 <= numero3) {
            menor = numero1;
            if (numero2 <= numero3) {
                meio = numero2;
                maior = numero3;
            } else {
                meio = numero3;
                maior = numero2;
            }
        } else if (numero2 <= numero1 && numero2 <= numero3) {
            menor = numero2;
            if (numero1 <= numero3) {
                meio = numero1;
                maior = numero3;
            } else {
                meio = numero3;
                maior = numero1;
            }
        } else {
            menor = numero3;
            if (numero1 <= numero2) {
                meio = numero1;
                maior = numero2;
            } else {
                meio = numero2;
                maior = numero1;
            }
        }

        System.out.println("Ordem crescente: " + menor + ", " + meio + ", " + maior);

    }
}
