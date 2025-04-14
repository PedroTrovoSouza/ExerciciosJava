package Lista2.Exercicio34;

import java.util.Random;

public class NumerosSorteados {
    public static void main(String[] args) {

        Random random = new Random();

        for(int i = 1; i <= 50; i++){
            int numeroSorteado = random.nextInt(100) + 1;
            System.out.println(numeroSorteado);
        }
    }
}
