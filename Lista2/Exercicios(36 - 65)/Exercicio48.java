import java.util.Scanner;

public class Exercicio48 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Quantas notas o aluno possui? ");
            int quantidadeDeNotas = scanner.nextInt();

            double somaDasNotas = 0;

            for (int i = 1; i <= quantidadeDeNotas; i++) {
                System.out.print("Digite a nota " + i + ": ");
                double nota = scanner.nextDouble();
                somaDasNotas += nota;
            }

            double media = somaDasNotas / quantidadeDeNotas;

            System.out.print("Digite o número de faltas do aluno: ");
            int faltas = scanner.nextInt();

            System.out.print("Digite o número total de aulas: ");
            int numeroDeAulas = scanner.nextInt();

            double limiteDeFaltas = numeroDeAulas * 0.25;

            if (faltas >= limiteDeFaltas) {
                System.out.println("O aluno foi reprovado por faltas.");
            } else if (media >= 7) {
                System.out.println("O aluno foi aprovado.");
            } else {
                System.out.println("O aluno foi reprovado por nota.");
            }

            scanner.close();
        }
    }