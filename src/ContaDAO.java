import java.util.ArrayList; //imports
import java.util.List;
public class ContaDAO { // busca de dados em excecao
    private List<ContaBancaria> contas = new ArrayList<>(); // inicializacao da lista
    public void cadastrar (ContaBancaria conta){ // assinatura do metodo
        this.contas.add(conta);}
    public ContaBancaria buscarporNumero (String numero) throws ContaNaoEncontradaException { // abertura do metodo
        for (ContaBancaria conta: this.contas){ // iteracao de conta dentro de contas
            if (conta.getnumero().equals(numero)){ // verificacao do n conta
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Conta Não Encontrada!"); // instanciamento do objeto
    }
}





