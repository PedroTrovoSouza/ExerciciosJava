package atividadeSlides.Arrays;

public class Arrays01 {
    public static void main(String[] args) {
        String[] listaFamiliares;

        listaFamiliares = new String[5];

        listaFamiliares[0] = "Marcella";
        listaFamiliares[1] = "Anderson";
        listaFamiliares[2] = "Miguel";
        listaFamiliares[3] = "Rafael";
        listaFamiliares[4] = "Sofia";

        for(int i = 0; i <= listaFamiliares.length - 1; i++){
            System.out.println(listaFamiliares[i]);
        }

    }
}
