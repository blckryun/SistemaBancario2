public class ContaDAO { // busca de dados em excecao
    public ContaBancaria buscarporNumero (String numero) throws ContaNaoEncontradaException { // abertura do metodo
        boolean encontrou = true; // variavel teste
        if (!encontrou) { // condicional da excecao
            throw new ContaNaoEncontradaException("Conta Não Encontrada!"); // instanciamento do objeto
        } return null;
    }
}




