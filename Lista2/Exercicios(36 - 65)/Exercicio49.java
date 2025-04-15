public class Exercicio49 {
    public static void main(String[] args) {
        System.out.println("Os 50 primeiros números da sequência de Fibonacci são:");
        int n1 = 1, n2 = 1;
        System.out.print(n1 + ", " + n2);
        for (int i = 3; i <= 50; i++) {
            int n3 = n1 + n2;
            System.out.print(", " + n3);
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }
}
