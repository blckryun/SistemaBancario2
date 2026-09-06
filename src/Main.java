public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("Gabriel", "1", 2000); //conta1
        ContaBancaria conta2 = new ContaBancaria("Isabelly", "2", 1000); //contaDestino
        ContaDAO dao = new ContaDAO(); // abertura do objeto
        dao.cadastrar(conta1); // metodo de cadastro
        dao.cadastrar(conta2); // metodo de cadastro

        ContaCorrente cc = new ContaCorrente("Nome : ", 100, "12345", 500.00);
        boolean sacou = cc.sacar(700);
        System.out.println("Saldo Atualiazado " + sacou);
        System.out.println("Saldo Atualiazado em R$ " +  cc.saldo + " Com Cheque Especial ");

        try {
            conta1 = dao.buscarporNumero("1");
            System.out.println("==========================");
            System.out.println("Historico de Movimentacoes");
            System.out.println("Titular : " + conta1.getTitular());
            System.out.println("Saldo Inicial : R$" + conta1.getSaldo());
            conta1.depositar(1000);
            conta1.sacar(500);
            conta1.transferir(500 ,conta2);
            conta1.exibirHistorico();
        } catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }

        try {
            conta2 = dao.buscarporNumero("2");
            System.out.println("==========================");
            System.out.println("Historico de Movimentacoes");
            System.out.println("Titular : " + conta2.getTitular());
            System.out.println("Saldo Inicial : R$" + conta2.getSaldo());
            conta2.depositar(500);
            conta2.sacar(700);
            conta2.exibirHistorico();
            System.out.println("==========================");
        } catch (ContaNaoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }
}