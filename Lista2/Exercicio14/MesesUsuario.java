package Lista2.Exercicio14;

import java.util.Scanner;

public class MesesUsuario {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String mes = "";

        System.out.println("Informe o nome do mês");
        mes = teclado.next();

        if (mes.equalsIgnoreCase("Janeiro")) {
            System.out.println("1");
        } else if (mes.equalsIgnoreCase("Fevereiro")) {
            System.out.println("2");
        } else if (mes.equalsIgnoreCase("Março")) {
            System.out.println("3");
        } else if (mes.equalsIgnoreCase("Abril")) {
            System.out.println("4");
        } else if (mes.equalsIgnoreCase("Maio")) {
            System.out.println("5");
        } else if (mes.equalsIgnoreCase("Junho")) {
            System.out.println("6");
        } else if (mes.equalsIgnoreCase("Julho")) {
            System.out.println("7");
        } else if (mes.equalsIgnoreCase("Agosto")) {
            System.out.println("8");
        } else if (mes.equalsIgnoreCase("Setembro")) {
            System.out.println("9");
        } else if (mes.equalsIgnoreCase("Outubro")) {
            System.out.println("10");
        } else if (mes.equalsIgnoreCase("Novembro")) {
            System.out.println("11");
        } else if (mes.equalsIgnoreCase("Dezembro")) {
            System.out.println("12");
        } else {
            System.out.println("Mês inválido.");
        }
    }
}
