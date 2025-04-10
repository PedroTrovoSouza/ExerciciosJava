package Lista1.Exercicio7;

public class DivisaoDe2PorMultiplosDe3 {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++){
            if(i % 3 == 0){
                double resultado = i / 2.0;
                System.out.println(resultado);
            }
        }
    }
}
