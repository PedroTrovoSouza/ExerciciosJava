import java.util.Scanner;

public class Exercicio55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double MENSALIDADE = 50.0;
        final double VALOR_EXCEDENTE_OUTRAS = 0.65;
        final double VALOR_EXCEDENTE_VAIVAI = 0.20;

        int minutosFranquia = 100;
        int bonusVaiVai = 50;
        double valorExcedente = 0.0;

        String continuar;

        do {
            System.out.print("Tipo de ligação (o = outras operadoras, v = Vai-Vai, f = fixo): ");
            char tipo = scanner.next().toLowerCase().charAt(0);

            System.out.print("Quantidade de minutos: ");
            int minutos = scanner.nextInt();

            if (tipo == 'v') {
                // Usa primeiro o bônus
                if (bonusVaiVai >= minutos) {
                    bonusVaiVai -= minutos;
                } else {
                    int restante = minutos - bonusVaiVai;
                    bonusVaiVai = 0;

                    if (minutosFranquia >= restante) {
                        minutosFranquia -= restante;
                    } else {
                        int excedente = restante - minutosFranquia;
                        minutosFranquia = 0;
                        valorExcedente += excedente * VALOR_EXCEDENTE_VAIVAI;
                    }
                }

            } else if (tipo == 'o') {
                if (minutosFranquia >= minutos) {
                    minutosFranquia -= minutos;
                } else {
                    int excedente = minutos - minutosFranquia;
                    minutosFranquia = 0;
                    valorExcedente += excedente * VALOR_EXCEDENTE_OUTRAS;
                }

            } else if (tipo == 'f') {
                int minutosConvertidos = minutos / 2;

                if (minutosFranquia >= minutosConvertidos) {
                    minutosFranquia -= minutosConvertidos;
                } else {
                    int excedenteConvertido = minutosConvertidos - minutosFranquia;
                    minutosFranquia = 0;
                    // Para cobrança, considera minutos reais, não convertidos
                    valorExcedente += minutos * VALOR_EXCEDENTE_OUTRAS;
                }

            } else {
                System.out.println("Tipo de ligação inválido!");
            }

            System.out.println("\n--- Status Atual ---");
            System.out.println("Minutos restantes (franquia): " + minutosFranquia);
            System.out.println("Minutos bônus Vai-Vai restantes: " + bonusVaiVai);
            System.out.printf("Valor a pagar além da mensalidade: R$ %.2f\n", valorExcedente);

            System.out.print("\nDeseja informar outra ligação? (s/n): ");
            continuar = scanner.next();

        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\n--- Resumo Final ---");
        System.out.printf("Valor total a pagar (mensalidade + excedente): R$ %.2f\n", MENSALIDADE + valorExcedente);

        scanner.close();
    }
}
