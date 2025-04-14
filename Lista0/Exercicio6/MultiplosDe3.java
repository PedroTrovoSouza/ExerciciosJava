package Exercicio6;

public class MultiplosDe3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            if(i % 3 == 0){
                double resultado = i / 2;
                System.out.println(resultado);
            }
        }
    }
}
