public class ContaCorrente extends ContaBancaria { // heranca da classe mae
    private double chequeEspecial; //atributo chequeEspecial criado

    public ContaCorrente(String titular, double saldoInicial, String numero, double chequeEspecial) { //abertura do construtor
        super(titular, numero, saldoInicial); //abertura da classe filha
        this.chequeEspecial = chequeEspecial; //atribuicao
    }
    @Override
    public boolean sacar(double valor){
        if (valor <= saldo + chequeEspecial) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }
}

