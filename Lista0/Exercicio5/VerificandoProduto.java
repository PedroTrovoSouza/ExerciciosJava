package Lista1.Exercicio5;

import java.util.Scanner;

public class VerificandoProduto {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int codigoProduto = 0;

        System.out.println("<---- Informe o nome do produto ----->");
        codigoProduto = teclado.nextInt();

        if(codigoProduto == 001){
            System.out.println("00"+codigoProduto + ": Parafuso");
        }else if(codigoProduto == 002){
            System.out.println("00"+codigoProduto + ": Porca");
        }else if(codigoProduto == 003){
            System.out.println("00"+codigoProduto + ": Prego");
        }else{
            System.out.println("00"+codigoProduto + ": Diversos");
        }
    }
}
