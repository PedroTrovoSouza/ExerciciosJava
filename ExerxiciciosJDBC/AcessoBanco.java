package ExerxiciciosJDBC;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Scanner;

public class AcessoBanco {

    public static void main(String[] args) throws SQLException {

        DataSource ds = new DataSource();

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o nome do café que deseja pesquisar:");
        String nomeCafe = scan.nextLine();

        System.out.println(ds.getDadosCafe(nomeCafe));

    }

}
