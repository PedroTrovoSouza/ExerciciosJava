package Lista1.Exercicio8;

import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String palavraInvertida = "";

        System.out.println("<----- Informe a sua palavra ----->");
        String palavraUsuario = teclado.next();

        for (int i = palavraUsuario.length() - 1; i >= 0; i--) {
            palavraInvertida += palavraUsuario.charAt(i);
        }

        System.out.println("Palavra invertida: " + palavraInvertida);

        if (palavraUsuario.equalsIgnoreCase(palavraInvertida)) {
            System.out.println("É um palíndromo");
        } else {
            System.out.println("Não é um palíndromo.");
        }
    }
}
