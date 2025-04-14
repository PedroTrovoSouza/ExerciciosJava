package Lista2.Exercicio21;

import java.util.Scanner;

public class EmprestimoPorCargo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cargo = "";
        double salario = 0.0;
        double emprestimo = 0.0;

        System.out.println("Informe seu cargo");
        cargo = teclado.nextLine();

        System.out.println("Informe seu salário");
        salario = teclado.nextDouble();

        if(cargo.equalsIgnoreCase("Diretoria")){
            emprestimo = salario * 0.30;
        }else if (cargo.equalsIgnoreCase("Gerencia")){
            emprestimo = salario * 0.25;
        }else {
            emprestimo = salario * 0.20;
        }
        System.out.println("Para o cargo de: " + cargo + " o valor do emprestimo é de: " + emprestimo);
    }
}
