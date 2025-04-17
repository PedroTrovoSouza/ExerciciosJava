package Lista1.Exercicio11;

import java.util.Scanner;

public class OrdenarPorOrdemAlfabetica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        System.out.print("Informe a primeira palavra: ");
        String palavra1 = teclado.nextLine();

        System.out.print("Informe a segunda palavra: ");
        String palavra2 = teclado.nextLine();

        if(palavra1.compareToIgnoreCase(palavra2) < 0){
            System.out.println(palavra1);
            System.out.println(palavra2);
        }else {
            System.out.println(palavra2);
            System.out.println(palavra1);
        }

        if(palavra1.length() > palavra2.length()){
            System.out.println("Palavra com mais caracteres: " + palavra1);
        }else {
            System.out.println("Palavra com mais caracteres: " + palavra2);
        }

    }
}
