import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pessoa {
    int idade;
    String sexo;

    public Pessoa(int idade, String sexo) {
        this.idade = idade;
        this.sexo = sexo;
    }
}

public class Exercicio46 {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 200; i++) {
            int idade = random.nextInt(71) + 10;

            String sexo = random.nextBoolean() ? "Homem" : "Mulher";

            pessoas.add(new Pessoa(idade, sexo));
        }

        int homensMaiorDeIdade = 0;
        int mulheresMaiorDeIdade = 0;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.idade >= 18) {
                if (pessoa.sexo.equals("Homem")) {
                    homensMaiorDeIdade++;
                } else {
                    mulheresMaiorDeIdade++;
                }
            }
        }

        System.out.println("Quantidade de homens maiores de idade: " + homensMaiorDeIdade);
        System.out.println("Quantidade de mulheres maiores de idade: " + mulheresMaiorDeIdade);
    }
}
