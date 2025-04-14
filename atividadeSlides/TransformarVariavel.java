package atividadeSlides;

public class TransformarVariavel {
    public static void main(String[] args) {
        int x = 13;
        double y = 0.0;

        while (x != 1){
            if(x % 2 == 0){
                y = (double) x /2;
            }else {
                y = 3 * x + 1;
            }
            System.out.println("Valor de Y: " + y);
            x = (int) y;
        }

    }
}
