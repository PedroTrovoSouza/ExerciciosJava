package Lista2.Exercicio29;

import java.util.Scanner;

public class PlanoCartesiano {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe as coordenadas do vértice superior esquerdo:");
        int x1 = teclado.nextInt();
        int y1 = teclado.nextInt();

        System.out.println("Informe as coordenadas do vértice inferior direito:");
        int x2 = teclado.nextInt();
        int y2 = teclado.nextInt();

        int xMin = Math.min(x1, x2);
        int xMax = Math.max(x1, x2);
        int yMax = Math.max(y1, y2);
        int yMin = Math.min(y1, y2);

        if (x1 == x2 && y1 == y2) {
            System.out.println("É um ponto.");
        } else if (y1 == y2) {
            System.out.println("É uma reta horizontal.");
        } else if (x1 == x2) {
            System.out.println("É uma reta vertical.");
        } else {
            System.out.println("É um retângulo.");

            int largura = xMax - xMin;
            int altura = yMax - yMin;
            int area = largura * altura;
            System.out.println("Área do retângulo: " + area);
        }

        System.out.println("Informe as coordenadas do ponto a ser analisado:");
        int px = teclado.nextInt();
        int py = teclado.nextInt();

        if (px > xMin && px < xMax && py > yMin && py < yMax) {
            System.out.println("O ponto está dentro do retângulo.");
        } else if ((px == xMin || px == xMax) && py >= yMin && py <= yMax ||
                (py == yMin || py == yMax) && px >= xMin && px <= xMax) {
            System.out.println("O ponto está na linha do retângulo.");
        } else if (px < xMin && py > yMax) {
            System.out.println("O ponto está acima e à esquerda.");
        } else if (px >= xMin && px <= xMax && py > yMax) {
            System.out.println("O ponto está acima.");
        } else if (px > xMax && py > yMax) {
            System.out.println("O ponto está acima e à direita.");
        } else if (px < xMin && py < yMin) {
            System.out.println("O ponto está embaixo e à esquerda.");
        } else if (px >= xMin && px <= xMax && py < yMin) {
            System.out.println("O ponto está embaixo.");
        } else if (px > xMax && py < yMin) {
            System.out.println("O ponto está embaixo e à direita.");
        } else if (px < xMin && py >= yMin && py <= yMax) {
            System.out.println("O ponto está à esquerda.");
        } else if (px > xMax && py >= yMin && py <= yMax) {
            System.out.println("O ponto está à direita.");
        }
    }
}
