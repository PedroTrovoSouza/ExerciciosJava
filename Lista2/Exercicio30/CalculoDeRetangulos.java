package Lista2.Exercicio30;

import java.util.Scanner;

public class CalculoDeRetangulos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe os vértices do primeiro retângulo:");
        int x1 = teclado.nextInt(), y1 = teclado.nextInt();
        int x2 = teclado.nextInt(), y2 = teclado.nextInt();
        int x3 = teclado.nextInt(), y3 = teclado.nextInt();
        int x4 = teclado.nextInt(), y4 = teclado.nextInt();

        System.out.println("Informe os vértices do segundo retângulo:");
        int x5 = teclado.nextInt(), y5 = teclado.nextInt();
        int x6 = teclado.nextInt(), y6 = teclado.nextInt();
        int x7 = teclado.nextInt(), y7 = teclado.nextInt();
        int x8 = teclado.nextInt(), y8 = teclado.nextInt();

        if (!isRetanguloValido(x1, y1, x2, y2, x3, y3, x4, y4)) {
            System.out.println("Os vértices do primeiro retângulo não formam um retângulo válido.");
            return;
        }
        if (!isRetanguloValido(x5, y5, x6, y6, x7, y7, x8, y8)) {
            System.out.println("Os vértices do segundo retângulo não formam um retângulo válido.");
            return;
        }

        int[] limites1 = getLimites(x1, y1, x2, y2, x3, y3, x4, y4);
        int[] limites2 = getLimites(x5, y5, x6, y6, x7, y7, x8, y8);

        if (intersecta(limites1, limites2)) {
            System.out.println("Os dois retângulos se interceptam.");
        } else {
            System.out.println("Os dois retângulos não se interceptam.");
        }
    }

    private static boolean isRetanguloValido(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        return (x1 != x2 || y1 != y2) && (x3 != x4 || y3 != y4) &&
                (x1 != x3 || y1 != y3) && (x2 != x4 || y2 != y4);
    }

    private static int[] getLimites(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int minX = Math.min(Math.min(x1, x2), Math.min(x3, x4));
        int maxX = Math.max(Math.max(x1, x2), Math.max(x3, x4));
        int minY = Math.min(Math.min(y1, y2), Math.min(y3, y4));
        int maxY = Math.max(Math.max(y1, y2), Math.max(y3, y4));
        return new int[]{minX, maxX, minY, maxY};
    }

    private static boolean intersecta(int[] limites1, int[] limites2) {
        return !(limites1[1] < limites2[0] ||
                limites1[0] > limites2[1] ||
                limites1[3] < limites2[2] ||
                limites1[2] > limites2[3]);
    }
}