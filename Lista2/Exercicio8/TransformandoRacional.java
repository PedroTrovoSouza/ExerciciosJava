package Lista2.Exercicio8;

import java.util.Scanner;

public class TransformandoRacional {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o numerador: ");
        double numerador = teclado.nextDouble();

        System.out.println("Informe o denominador: ");
        double denominador = teclado.nextDouble();

        if(denominador != 0){
            double numeroReal = numerador / denominador;
            System.out.println("Número real: " + numeroReal);
        }else{
            System.out.println("Infelizmente não existe divisão por 0");
        }
    }
}
