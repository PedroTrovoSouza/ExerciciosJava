package Lista2.Exercicio12;

import java.util.Scanner;

public class MediaAlunoAprovado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota = 0.0;
        double notaProvaFinal = 0.0;

        for(int i = 1; i <= 3; i++){
            System.out.println("Informe sua nota");
            nota += teclado.nextInt();
        }
        nota = nota / 3;
        if(nota < 5){
            System.out.println("Infelizmente você foi reprovado!");
        }else if(nota >= 5 || nota < 7){
            System.out.println("Você está de recuperação!!");
            System.out.println("Qual foi a sua nota da prova final?");
            notaProvaFinal = teclado.nextDouble();
            nota += notaProvaFinal / 2;
            if (nota >= 5){
                System.out.println("Você foi aprovado!");
            }else{
                System.out.println("Você foi reprovado!!");
            }
        }else{
            System.out.println("Você foi aprovado!!");
        }
    }
}
