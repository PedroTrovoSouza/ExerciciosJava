package Lista2.Exercicio1;

import java.util.Scanner;

public class DataAniversario {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe o ano do seu nascimento: ");
        int anoNasc = teclado.nextInt();

        System.out.print("Informe o ano atual: ");
        int anoAtual = teclado.nextInt();

        int idadeUsuario = anoAtual - anoNasc;

        System.out.print("Idade: " + idadeUsuario);
    }
}
