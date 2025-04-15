import java.time.LocalDate;
import java.util.Scanner;

public class Exercicio57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira data:");
        System.out.print("Dia: ");
        int dia1 = scanner.nextInt();
        System.out.print("Mês: ");
        int mes1 = scanner.nextInt();
        System.out.print("Ano: ");
        int ano1 = scanner.nextInt();

        System.out.println("Digite a segunda data:");
        System.out.print("Dia: ");
        int dia2 = scanner.nextInt();
        System.out.print("Mês: ");
        int mes2 = scanner.nextInt();
        System.out.print("Ano: ");
        int ano2 = scanner.nextInt();

        LocalDate data1 = LocalDate.of(ano1, mes1, dia1);
        LocalDate data2 = LocalDate.of(ano2, mes2, dia2);

        if (data1.isAfter(data2)) {
            LocalDate temp = data1;
            data1 = data2;
            data2 = temp;
        }

        System.out.println("\nDatas entre " + data1 + " e " + data2 + ":");

        LocalDate atual = data1;
        while (!atual.isAfter(data2)) {
            System.out.println(atual);
            atual = atual.plusDays(1);
        }

        scanner.close();
    }
}


