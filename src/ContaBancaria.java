import java.util.List;  //imports
import java.util.ArrayList;


public class ContaBancaria {
    // atributos
    protected String titular;
    protected double saldo;
    protected String numero;
    protected List<String> historico;  //atribuicao da lista

    //construtor
    public ContaBancaria(String titular, String numero, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.historico = new ArrayList<>();  // criacao da lista
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else
            this.saldo = 0;
    }

    // metodos
    public void depositar (double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            historico.add("Valor Depositado em : R$" + valor);
        } else {
            System.out.println("Valor de Depósito Invalido!");
        }
    }

    public boolean sacar (double valor) throws SaldoInsuficienteException {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            historico.add("Valor Sacado em : R$" + valor);
        } else {
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }
    }

    public void transferir (double valor, ContaBancaria contaDestino) throws SaldoInsuficienteException{
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


    public void exibirHistorico() { //criacao do metodo utilizando array
        for (String transacao : this.historico) {
            System.out.println(transacao);
        }
    }

    // get s
    public double getSaldo() {
        return saldo;
    }
    public String getTitular() {
        return titular;
    }
    public String getnumero(){
        return numero;
    }
}











