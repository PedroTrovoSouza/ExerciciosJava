import java.util.Scanner;

public class TrocarValores {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int valor1 = 0;
        int valor2 = 0;

        System.out.println("<----- Informe o primeiro valor ----->");
        valor1 = teclado.nextInt();
        System.out.println("<----- Informe o segundo valor ----->");
        valor2 = teclado.nextInt();

        System.out.println("Valor 1: " + valor1);
        System.out.println("Valor 2: " + valor2);

        System.out.println("<----- Mudanças de valor ----->");

        System.out.println("Valor 1 agora: " + atribuirValor1(valor1, valor2));
        System.out.println("Valor 2 agora: " + atribuirValor2(valor1, valor2));
    }

    public static int atribuirValor1(int valor1, int valor2){
        return valor1 = valor2;
    }

    public static int atribuirValor2(int valor1, int valor2){
        return valor2 = valor1;
    }
}
