package Lista1.Exercicio12;

import java.util.Scanner;

public class ConsumoDeCombustivel {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe a quantidade de kms dirigidos: ");
        int qtdKm = teclado.nextInt();

        System.out.print("Informe a quantidade de gasolina utilizada: ");
        int qtdGasolinaUsada = teclado.nextInt();

        System.out.print("Informe o tamanho do seu tanque: ");
        int tamanhoTanque = teclado.nextInt();

        double kmPorGasolina = (double) qtdKm / qtdGasolinaUsada;
        double tanques = tamanhoTanque * kmPorGasolina;

        System.out.println("Consumo médio: " + kmPorGasolina);
        System.out.println("Com um tanque cheio, você pode percorrer até: "+ tanques);;

    }
}
