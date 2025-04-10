package Exercicio2;

import java.util.Scanner;

public class VerificandoImparPar {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("<----- Informe o valor que deseja saber se é ímpar ou par ----->");
        int valorUsuario = teclado.nextInt();

        if (valorUsuario % 2 == 0){
            System.out.print("O valor: "+ valorUsuario + " é par");
        }else {
            System.out.println("O valor: "+ valorUsuario + " é ímpar");
        }
    }
}
