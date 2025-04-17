package Lista2.Exercicio10;

import java.util.Scanner;

public class EmprestimoBanco {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe seu salário bruto: ");
        double salarioBruto = teclado.nextDouble();

        System.out.println("Informe os valores de descontos: ");
        double valorDesconto = teclado.nextDouble();

        System.out.println("Possível empréstimo: ");
        double possivelEmprestimo = teclado.nextDouble();

        double salarioLiquido = salarioBruto - valorDesconto;
        double emprestimoMaximo = salarioLiquido * 0.30;

        if(possivelEmprestimo <= emprestimoMaximo){
            System.out.println("Empréstimo aprovado!!");
        }else {
            System.out.println("Empréstimo reprovado!!");
        }
    }
}
