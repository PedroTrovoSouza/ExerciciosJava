package Lista1.Exercicio5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DiasDaSemana {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe um número de 1 a 7: ");
        int valor = teclado.nextInt();

        String[] diasDaSemana = {
                "Segunda-Feira",
                "Terça-Feira",
                "Quarta-Feira",
                "Quinta-Feira",
                "Sexta-Feira",
                "Sábado",
                "Domingo",
        };
        System.out.println(diasDaSemana[valor - 1]);
    }
}
