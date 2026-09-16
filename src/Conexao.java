import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/banco_db";
    private static final String usuario = "root";
    private static final String senha = System.getenv("MYSQL_PASSWORD"); //uso do .env pra seguranca de senha

    public static Connection conectar() { // abertura do metodo
        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha); //conexao com o banco
            System.out.println("Conexao Concluida!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Conexao nao Estabelecida " + e.getMessage()); //excessao
            return null;
        }
    }
}
