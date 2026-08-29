import java.security.PublicKey;

public class ContaBancaria {
    // atributos
    private String titular;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String titular, int numeroConta, double saldoInicial) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else
            this.saldo = 0;
    }
    // metodos
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
        }
    }
    public void sacar (double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            System.out.println("Valor Sacado!");
        } else {
            System.out.println("Valor Indisponivel para Saque!");
        }
    }
    // get s
    public double getSaldo() {
        return saldo;
    }
    public int getNumeroConta() {
        return numeroConta;
    }
    public String getTitular() {
        return titular;
    }
}











