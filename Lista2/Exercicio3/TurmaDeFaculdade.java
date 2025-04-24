package Lista2.Exercicio3;

import java.util.Scanner;

public class TurmaDeFaculdade {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("<----- Informe a quantidade de homens ----->");
        int qtdHomem = teclado.nextInt();

        System.out.println("<----- Informe a quantidade de mulheres ----->");
        int qtdMulher = teclado.nextInt();

        int totalDeAlunos = qtdHomem + qtdMulher;

        double porcentHomem = (double) qtdHomem / totalDeAlunos * 100;
        double porcentMulher = (double) qtdMulher / totalDeAlunos * 100;

        System.out.println(totalDeAlunos);
        System.out.println("Porcentagem de homens: " + porcentHomem + "%");
        System.out.print("Porcentagem de mulheres: " + porcentMulher + "%");
    }
}
