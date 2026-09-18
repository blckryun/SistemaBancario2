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
            stmt.setString(1, conta.getnumero());
            stmt.setString(2, conta.getTitular());
            stmt.setDouble(3, conta.getSaldo());

            stmt.executeUpdate();
            System.out.println("Conta Cadastrada!");
        } catch (SQLException e) {
            System.out.println("Conta nao Cadastrada!");
        }
    }

    public ContaBancaria buscarPorNumero(String numero) throws ContaNaoEncontradaException {
        String sql = "SELECT * FROM contas WHERE numero_conta = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, numero);

            try (ResultSet result = stmt.executeQuery()) {
                if (result.next()) {
                    String num = result.getString("numero_conta");
                    String titular = result.getString("titular");
                    double saldo = result.getDouble("saldo");

                    return new ContaBancaria(num, titular, saldo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao Buscar Conta: " + e.getMessage());
        }

        throw new ContaNaoEncontradaException("Conta com número " + numero + " não foi encontrada.");
    }
}












