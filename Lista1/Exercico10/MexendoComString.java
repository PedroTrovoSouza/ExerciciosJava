package Lista1.Exercico10;

import java.util.Locale;
import java.util.Scanner;

public class MexendoComString {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe sua frase: ");
        String fraseUsuario = teclado.nextLine();
        int numeroDeVogais = 0;
        int numeroDeConsoantes = 0;
        int numeroDeEspacos = 0;
        String fraseUsuarioMinuscula = fraseUsuario.toLowerCase();

        for(int i = 0; i < fraseUsuarioMinuscula.length(); i++){
            char letras = fraseUsuarioMinuscula.charAt(i);
            if (letras == 'a' || letras == 'e' || letras == 'i' || letras == 'o' || letras == 'u'){
                numeroDeVogais++;
            }else if(letras == ' '){
                numeroDeEspacos++;
            }else{
                numeroDeConsoantes++;
            }
        }
        System.out.println("Número de vogais: " + numeroDeVogais);
        System.out.println("Número de consoantes: " + numeroDeConsoantes);
        System.out.print("Número de espaços: " + numeroDeEspacos);
    }
}
