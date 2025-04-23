package bcdadosnew;

import java.sql.SQLException;
import java.util.Scanner;

public class ChamadasBancoNovo {
    public static void main(String[] args) {
        AcessoBancoNovo abn = new AcessoBancoNovo();
        Scanner teclado = new Scanner(System.in);;
        int codigoUser;
        int opcao;
        String genero;
        String especie;

        try {
            abn.criarTabela();
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }

        while(true){
            System.out.println("""
                    1 - Cadastrar dinossauro
                    2 - Editar dinossauro
                    3 - Excluir dinossauro
                    4 - Sair""");
            opcao = teclado.nextInt();

            if(opcao == 1){
                System.out.println("Informe o genero do dinossauro");
                genero = teclado.next();

                System.out.println("Informe a especie do dinossauro");
                especie = teclado.next();

                try {
                    abn.inserirRegTab(genero, especie);
                }catch (SQLException e){
                    System.err.println("Não foi possivel inserir os dados: " + e.getMessage());
                }

            } else if (opcao == 2) {
                System.out.println("Informe o código: ");
                codigoUser = teclado.nextInt();

                teclado.nextLine();

                System.out.println("Informe o genero: ");
                genero = teclado.nextLine();

                System.out.println("Informe a especie: ");
                especie = teclado.nextLine();

                try {
                    abn.alteraRegistro(codigoUser, genero, especie);
                }catch (SQLException e){
                    System.err.println("Não foi possivel alterar os dados: " + e.getMessage());
                }
            }else if(opcao == 3){
                System.out.println("Qual registro você deseja excluir: ");
                codigoUser = teclado.nextInt();

                try {
                    abn.deletarRegistro(codigoUser);
                }catch (SQLException e){
                    System.err.println("Não foi possivel excluir o registro: " + e.getMessage());
                }
            }else {
                break;
            }
        }
    }
}

