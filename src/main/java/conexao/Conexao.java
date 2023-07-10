package conexao;

import java.sql.*;

public class Conexao {

    public static void main(String[] args) throws SQLException {
        Connection conexao = null;
        // 1º passo - carregar o driver do banco de dados dentro da aplicação (dependência)

        try {
            Class.forName("org.postgresql.Driver");
            // 2º passo - criar a conexão
            conexao = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/exemplo-banco-de-dados", "postgres", "puc@2015");
            ResultSet rsEstudante = conexao.createStatement().executeQuery("SELECT * FROM estudante");
            while (rsEstudante.next()){

                System.out.println("Nome: " + rsEstudante.getString("nome"));


            }
        } catch (ClassNotFoundException e) {
                 System.out.println("Driver do banco de dados não localizado" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco." + e.getMessage());
        } finally {

            if (conexao != null) {

                conexao.close();

            }

        }
    }

}
