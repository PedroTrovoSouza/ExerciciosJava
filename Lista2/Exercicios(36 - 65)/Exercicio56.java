import java.util.Scanner;

public class Exercicio56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os candidatos");

        System.out.println("Candidato 1:");
        String candidato1 = scanner.nextLine();
        System.out.println("Candidato 2:");
        String candidato2 = scanner.nextLine();
        System.out.println("Candidato 3:");
        String candidato3 = scanner.nextLine();

        int votosCandidato1 = 0,
            votosCandidato2 = 0,
            votosCandidato3 = 0;

        while (true) {
            System.out.println("Bem vindo a Urna!");
            System.out.println("Candidatos: \n " +
                    candidato1 + "\n" +
                    candidato2 + "\n" +
                    candidato3);
            System.out.println("Escolha seu voto!");
            System.out.println("1 - candidato 1 \n " +
                    "2 - candidato 2 \n" +
                    "3 - candidato 3 \n" +
                    "4 - voto em branco");
            int voto = scanner.nextInt();
            switch (voto) {
                case 1:
                    votosCandidato1++;
                    System.out.println("Você votou em " + candidato1 +
                    "ele possui " + votosCandidato1 +" votos.");
                    break;
                case 2:
                    votosCandidato2++;
                    System.out.println("Você votou em " + candidato2 +
                            "ele possui " + votosCandidato2 +" votos.");
                    break;
                case 3:
                    votosCandidato3++;
                    System.out.println("Você votou em " + candidato3 +
                            "ele possui " + votosCandidato3 +" votos.");
                    break;
                case 4:
                    if (votosCandidato1 > votosCandidato2 && votosCandidato1 > votosCandidato3) {
                        votosCandidato1++;
                    }
                    if (votosCandidato2 > votosCandidato1 && votosCandidato2 > votosCandidato3) {
                        votosCandidato2++;
                    }
                    if (votosCandidato3 > votosCandidato1 && votosCandidato3 > votosCandidato2) {
                        votosCandidato3++;
                    }
                    break;
            }
        }
    }
}
