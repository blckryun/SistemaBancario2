import javax.xml.transform.Source;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Conexao.conectar();
        ContaBancaria conta1 = new ContaBancaria("Gabriel", "1", 2000); //conta1
        ContaBancaria conta2 = new ContaBancaria("Isabelly", "2", 1000); //contaDestino
        ContaDAO dao = new ContaDAO(); // abertura do objeto
        dao.cadastrar(conta1); // metodo de cadastro
        dao.cadastrar(conta2); // metodo de cadastro


        ContaCorrente cc = new ContaCorrente("Nome : ", "100", 12345, 500.00);
        try {
            boolean sacou = cc.sacar(700);
            System.out.println("Saldo Atualiazado " + sacou);
            System.out.println("Saldo Atualiazado em R$ " + cc.getSaldo() + " Com Cheque Especial ");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        try {
            conta1 = dao.buscarporNumero("1");
            System.out.println("Historico de Movimentacoes");
            System.out.println("Titular : " + conta1.getTitular());
            System.out.println("Saldo Inicial : R$" + conta1.getSaldo());
            conta1.depositar(1000);

            conta1.exibirHistorico();
        } catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        try {
            conta2 = dao.buscarporNumero("2");
            System.out.println("Historico de Movimentacoes");
            System.out.println("Titular : " + conta2.getTitular());
            System.out.println("Saldo Inicial : R$" + conta2.getSaldo());
            conta2.depositar(500);
            conta2.sacar(700);
            conta2.exibirHistorico();
        } catch (ContaNaoEncontradaException | SaldoInsuficienteException exception) {
            System.out.println("Erro nos Testes da Conta2 : " + exception.getMessage());

        }

        Scanner scanner = new Scanner(System.in);

        int opcao1 = -1;
        while (opcao1 != 0) {
            System.out.println("0 - Sair, 1 - Trasferencia, 2 - Sacar, 3 - Consultar Saldo.");
            opcao1 = scanner.nextInt();

            switch (opcao1) {
                case 1:
                    System.out.println("Digite o N* da Conta Destinada");
                    String numdestino = scanner.next();

                    System.out.println("Digite o Valor de Transferencia");
                    double valor = scanner.nextDouble();

                    try {
                        ContaBancaria contaDestino = dao.buscarporNumero(numdestino);
                        conta1.transferir(valor, contaDestino);
                        System.out.println("Transferencia Realizada com Sucesso!");
                    } catch (ContaNaoEncontradaException | SaldoInsuficienteException exception) {
                        System.out.println("Erro : " + exception.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Insira o Valor para Saque");
                    double valorSaque = scanner.nextDouble();

                    try {
                        conta1.sacar(valorSaque);
                        System.out.println("Saque Realizado com Sucesso!");

                    } catch (SaldoInsuficienteException e) {
                        System.out.println("Erro : " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saldo Atual : " + conta1.getSaldo());
                    break;
                case 0:
                    System.out.println("Sistema Encerrado!");
                default:
                    System.out.println("Opcao Invalida! Tente Novamente");
                    break;
            }
        }
    }
}