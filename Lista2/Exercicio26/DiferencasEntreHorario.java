package Lista2.Exercicio26;

import java.util.Scanner;

public class DiferencasEntreHorario {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int hora1 = 0;
        int minuto1 = 0;
        int segundo1 = 0;
        int hora2 = 0;
        int minuto2 = 0;
        int segundo2 = 0;

        System.out.println("Informe a hora: ");
        hora1 = teclado.nextInt();

        System.out.println("Informe os minutos: ");
        minuto1 = teclado.nextInt();

        System.out.println("Informe os segundos: ");
        segundo1 = teclado.nextInt();

        int conversaoHoras = hora1 * 3600;
        int conversaoMinutos = minuto1 * 60;
        int totalSegundos = conversaoMinutos + conversaoHoras + segundo1;

        System.out.println("Informe a hora: ");
        hora2 = teclado.nextInt();

        System.out.println("Informe os minutos: ");
        minuto2 = teclado.nextInt();

        System.out.println("Informe os segundos: ");
        segundo2 = teclado.nextInt();

        int conversaoHoras2 = hora2 * 3600;
        int conversaoMinutos2 = minuto2 * 60;
        int totalSegundos2 = conversaoMinutos2 + conversaoHoras2 + segundo1;

        int diferencaTotal = totalSegundos - totalSegundos2;

        System.out.println("Diferença dos horários em sugundos: " + diferencaTotal);
    }
}
