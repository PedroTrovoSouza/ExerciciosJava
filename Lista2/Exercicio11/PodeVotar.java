package Lista2.Exercicio11;

import java.util.Scanner;

public class PodeVotar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe sua idade: ");
        int idade = teclado.nextInt();
        if(idade < 16){
            System.out.println("Você ainda não pode votar");
        }else if(idade <= 16 || idade >= 65){
            System.out.println("Seu voto é facuntativo");
        }else{
            System.out.println("Seu voto é obrigatório");
        }
    }
}
