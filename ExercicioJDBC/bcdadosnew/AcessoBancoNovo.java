package bcdadosnew;

import java.sql.*;

public class AcessoBancoNovo {

    private Connection connection;

    public AcessoBancoNovo() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/banconovo?useSSL=false", "root", "Semsenha13");
            System.out.println("Conexão estabelecida!!");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Erro Driver Jdbc!" + cnfe.getLocalizedMessage());
        } catch (SQLException sqle) {
            System.out.println("Conexão falhou!");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void criarTabela() throws SQLException {
        try (PreparedStatement dropStmt = connection.prepareStatement(
                "DROP TABLE IF EXISTS dinossauros")) {
            dropStmt.executeUpdate();
        }

        try (PreparedStatement createStmt = connection.prepareStatement(
                "CREATE TABLE dinossauros (" +
                        "id_dinossauro INT NOT NULL AUTO_INCREMENT, " +
                        "genero VARCHAR(50), " +
                        "especie VARCHAR(50), " +
                        "PRIMARY KEY (id_dinossauro))")) {
            createStmt.executeUpdate();
        }

        DatabaseMetaData dbm = connection.getMetaData();
        try (ResultSet tabela = dbm.getTables(null, null, "dinossauros", null)) {
            if (tabela.next()) {
                System.out.println("Tabela Criada Com Sucesso!!");
            }
        } catch (Exception e) {
            System.err.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }

    public void inserirRegTab(String genero, String especie) throws SQLException {

        PreparedStatement prep = (PreparedStatement) connection
                .prepareStatement("INSERT INTO dinossauros (genero, especie) values (?, ?);");

        prep.setString(1, genero);
        prep.setString(2, especie);
        prep.addBatch();

        connection.setAutoCommit(false);
        prep.executeBatch();
        connection.setAutoCommit(true);
    }

    public void alteraRegistro(int id, String genero, String especie) throws SQLException {
        String sqlConsultaPorCod = "SELECT id_dinossauro, genero, especie FROM dinossauros WHERE id_dinossauro = ?";
        String sqlAlteracao1 = "UPDATE dinossauros SET genero = ? WHERE id_dinossauro = ?";
        String sqlAlteracao2 = "UPDATE dinossauros SET especie = ? WHERE id_dinossauro = ?";

        if (genero == null || especie == null) {
            PreparedStatement prep = connection.prepareStatement(sqlConsultaPorCod);
            prep.setInt(1, id);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                System.out.println("Dados do dinossauro");
                System.out.println("ID..: " + rs.getString("id_dinossauro"));
                System.out.println("Genero..: " + rs.getString("genero"));
                System.out.println("Especie.: " + rs.getString("especie"));
            }
        } else {
            PreparedStatement prepGenero = connection.prepareStatement(sqlAlteracao1);
            prepGenero.setString(1, genero);
            prepGenero.setInt(2, id);
            prepGenero.executeUpdate();

            PreparedStatement prepEspecie = connection.prepareStatement(sqlAlteracao2);
            prepEspecie.setString(1, especie);
            prepEspecie.setInt(2, id);
            prepEspecie.executeUpdate();

            System.out.println("Registro alterado com sucesso!");
        }
    }

    public void deletarRegistro(int id) throws SQLException {
        PreparedStatement prep = (PreparedStatement)      connection.prepareStatement("DELETE FROM dinossauros where id_dinossauro = ? ");
        connection.setAutoCommit(true);
        prep.setInt(1, id);
        prep.executeUpdate();
    }


}