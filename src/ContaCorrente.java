public class ContaCorrente extends ContaBancaria { // heranca da classe mae
    private double chequeEspecial; //atributo chequeEspecial criado

    public ContaCorrente(String titular, String numero, double saldoInicial, double chequeEspecial) { //abertura do construtor
        super(titular, numero, saldoInicial); //abertura da classe filha
        this.chequeEspecial = chequeEspecial; //atribuicao
    }
    @Override
    public boolean sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= saldo + chequeEspecial) {
            saldo = saldo - valor;
            return true;
        }else {
            throw new SaldoInsuficienteException("Saldo Insufisciente");
        }

    }
}

