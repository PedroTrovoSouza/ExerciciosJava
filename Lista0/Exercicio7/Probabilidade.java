package Exercicio7;

public class Probabilidade {
    public static void main(String[] args) {
        System.out.println("<----- Combinações que somam 7 ao lançar dois dados: ----->");

        for (int dado1 = 1; dado1 <= 6; dado1++) {
            for (int dado2 = 1; dado2 <= 6; dado2++) {
                if (dado1 + dado2 == 7) {
                    System.out.println("Dado 1: " + dado1 + " | Dado 2: " + dado2);
                }
            }
        }
    }
}