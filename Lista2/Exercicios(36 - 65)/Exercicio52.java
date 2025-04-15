import java.math.BigInteger;

public class Exercicio52 {
    public static void main(String[] args) {
        BigInteger saco = BigInteger.valueOf(50_966);

        BigInteger totalGraos = BigInteger.ZERO;

        BigInteger graos = BigInteger.ONE;

        for (int i = 1; i <= 64; i++) {
            totalGraos = totalGraos.add(graos);

            System.out.println("Casa " + i + ": " + graos + " grãos");

            graos = graos.multiply(BigInteger.valueOf(2));
        }

        System.out.println("\nTotal de grãos de arroz: " + totalGraos);

        BigInteger numSacos = totalGraos.divide(saco);
        if (totalGraos.mod(saco).compareTo(BigInteger.ZERO) > 0) {
            numSacos = numSacos.add(BigInteger.ONE);
        }

        System.out.println("Número de sacos de arroz necessários: " + numSacos);
    }
}
