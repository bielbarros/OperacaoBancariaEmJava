import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void criarConta(String numeroConta, String nomeTitular, double saldoInicial) {
        contas.add(new ContaBancaria(numeroConta, nomeTitular, saldoInicial));
        System.out.println("Conta criada com sucesso! Seja bem-vindo!");
    }

    public ContaBancaria buscarConta(String numeroConta) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }
}
