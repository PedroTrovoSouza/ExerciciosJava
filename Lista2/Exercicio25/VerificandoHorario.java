package Lista2.Exercicio25;

import java.util.Scanner;

public class VerificandoHorario {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int hora = 0;
        int minuto = 0;
        int segundo = 0;

        System.out.println("Informe a hora: ");
        hora = teclado.nextInt();

        System.out.println("Informe os minutos: ");
        minuto = teclado.nextInt();

        System.out.println("Informe os segundos: ");
        segundo = teclado.nextInt();

        if(hora <= 23 && minuto <= 60 && segundo <= 60){
            System.out.println("Seu horário está correto: " + hora + ":" + minuto + ":" + segundo);
        }else {
            System.out.println("Horário incorreto!!");
        }
    }
}
