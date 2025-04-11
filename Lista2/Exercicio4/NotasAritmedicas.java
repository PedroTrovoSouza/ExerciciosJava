package Lista2.Exercicio4;

import java.util.Scanner;

public class NotasAritmedicas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double notaUsuario = 0;
        int totalDeNotas = 0;
        double resultado = 0.0;

        for (int i = 1; i <= 4; i++){
            System.out.print("Informe sua nota: ");
            notaUsuario += teclado.nextDouble();
            totalDeNotas++;
        }
        resultado = notaUsuario / totalDeNotas;
        System.out.println("Média das notas: " + resultado);
    }
}
