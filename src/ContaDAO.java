import java.net.CookieHandler;
import java.sql.ResultSet;
import java.util.ArrayList; //imports
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO { // busca de dados em excecao
    private List<ContaBancaria> contas = new ArrayList<>(); // inicializacao da lista


    public void cadastrar(ContaBancaria conta) { // assinatura do metodo
        String sql = "INSERT INTO contas (numero, titular, saldo) VALUES (?,?,?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             stmt.setString(1 , conta.getnumero());
             stmt.setString(2 , conta.getTitular());
             stmt.setDouble(3 , conta.getSaldo());

             stmt.executeUpdate();
            System.out.println("Conta Cadastrada!");
        }catch (SQLException e){
            System.out.println("Conta nao Cadastrada!");
        }

        public ContaBancaria buscarPornumero (String numero) {
            String sql = "SELECT * FROM contas WHERE numero_conta = ?";

            try (Connection conn = Conexao.conectar();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, numero);
                try(ResultSet result = stmt.executeQuery()){

                }



            }

        }





    }
}












