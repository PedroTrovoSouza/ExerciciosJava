package Lista2.Exercicio24;

import java.util.Scanner;

public class VerificandoData {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int dia = 0;
        int mes = 0;
        int ano = 0;
        Boolean anoBissexto = false;

        System.out.println("Informe o dia");
        dia = teclado.nextInt();

        System.out.println("Informe o mes");
        mes = teclado.nextInt();

        System.out.println("Informe o ano");
        ano = teclado.nextInt();

        if(dia >= 1 && dia <= 31){
            if(mes >= 1 && mes <= 12){
                if(mes == 2 && dia == 29){
                    System.out.println("A data " + dia + "/" + mes + "/" + ano + " está correta e é um ano bissexto");
                }else{
                    System.out.println("A data " + dia + "/" + mes + "/" + ano + " está correta e não é um ano bissexto");
                }
            }else{
                System.out.println("Mês incorreto");
            }
        }else{
            System.out.println("Dia incorreto!!");
        }
    }
}
