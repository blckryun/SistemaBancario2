public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("Gabriel", 1, 2000); //conta1
        ContaBancaria conta2 = new ContaBancaria("Isabelly", 2, 500); //contaDestino

        conta1.depositar(500); //teste deposito c1
        conta1.sacar(500); //saque c1
        conta1.transferir(1000, conta2); //transferencia da c1 para c2

        conta2.depositar(500); //teste deposito c2
        conta2.sacar(600); //teste saque c2


        conta1.exibirHistorico(); //materializacao do historico c1
        System.out.println("Saldo da Conta de Gabriel : " + conta1.getSaldo());
        conta2.exibirHistorico(); //materializacao do historico c2
        System.out.println("Saldo da Conta de Isabelly : " + conta2.getSaldo());

        ContaDAO dao = new ContaDAO();
        try {
            dao.buscarporNumero("123");
            System.out.println("Conta Encontrada!");
        }
        catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }


    }
}
