package Lista1.Exercicio4;

import java.util.Scanner;

public class ConverterDIstancia {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("<----- Informe a distancia em milhas ----->");
        double distancia = teclado.nextDouble();
        int valorKm = 1690;

        double resultadoDistanciaKm = valorKm * distancia;
        System.out.print("Sua distanca em KM: " + resultadoDistanciaKm);
    }
}
