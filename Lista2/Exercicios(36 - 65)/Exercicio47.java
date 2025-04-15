import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Paciente {
    String nome;
    String sexo;
    int idade;
    double peso;
    double altura;

    public Paciente(String nome, String sexo, int idade, double peso, double altura) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }
}

public class Exercicio47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Paciente> pacientes = new ArrayList<>();
        int totalPacientes = 0;
        int totalHomens = 0;
        int idadeHomens = 0;
        int mulheresAlturaPeso = 0;
        int idade18a25 = 0;
        Paciente pacienteMaisVelho = null;
        Paciente mulherMaisBaixa = null;

        while (true) {
            System.out.print("Digite o nome do paciente (ou 'fim' para encerrar): ");
            String nome = scanner.nextLine();

            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Digite o sexo do paciente (Masculino/Feminino): ");
            String sexo = scanner.nextLine();

            System.out.print("Digite a idade do paciente: ");
            int idade = scanner.nextInt();

            System.out.print("Digite o peso do paciente (kg): ");
            double peso = scanner.nextDouble();

            System.out.print("Digite a altura do paciente (m): ");
            double altura = scanner.nextDouble();

            scanner.nextLine();

            Paciente paciente = new Paciente(nome, sexo, idade, peso, altura);
            pacientes.add(paciente);
            totalPacientes++;

            if (sexo.equalsIgnoreCase("Masculino")) {
                totalHomens++;
                idadeHomens += idade;
            }

            if (sexo.equalsIgnoreCase("Feminino")) {
                if (altura >= 1.60 && altura <= 1.70 && peso > 70) {
                    mulheresAlturaPeso++;
                }
                if (mulherMaisBaixa == null || altura < mulherMaisBaixa.altura) {
                    mulherMaisBaixa = paciente;
                }
            }

            if (idade >= 18 && idade <= 25) {
                idade18a25++;
            }

            if (pacienteMaisVelho == null || idade > pacienteMaisVelho.idade) {
                pacienteMaisVelho = paciente;
            }
        }

        System.out.println("\nRelatório da Clínica:");
        System.out.println("Quantidade total de pacientes: " + totalPacientes);

        if (totalHomens > 0) {
            double mediaIdadeHomens = (double) idadeHomens / totalHomens;
            System.out.println("Média de idade dos homens: " + mediaIdadeHomens);
        } else {
            System.out.println("Nenhum homem cadastrado.");
        }

        System.out.println("Quantidade de mulheres com altura entre 1,60m e 1,70m e peso acima de 70kg: " + mulheresAlturaPeso);

        System.out.println("Quantidade de pessoas com idade entre 18 e 25 anos: " + idade18a25);

        if (pacienteMaisVelho != null) {
            System.out.println("Nome do paciente mais velho: " + pacienteMaisVelho.nome);
        }

        if (mulherMaisBaixa != null) {
            System.out.println("Nome da mulher mais baixa: " + mulherMaisBaixa.nome);
        }

        scanner.close();
    }

}
