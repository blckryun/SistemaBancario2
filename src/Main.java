public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Gabriel", 123, 1000);
        conta.depositar(500);
        System.out.println("Saldo Depositado R$ " + conta.getSaldo());

        conta.sacar(2500);
        System.out.println("Saldo Sacado R$ " + conta.getSaldo());
    }
}
