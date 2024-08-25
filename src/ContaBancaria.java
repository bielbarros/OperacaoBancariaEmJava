import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;
    private List<Transacao> transacoes = new ArrayList<>();

    public ContaBancaria(String numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void depositar(double valor) {
        saldo += valor;
        transacoes.add(new Transacao('D', valor));
    }

    public boolean sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return false;
        }
        saldo -= valor;
        transacoes.add(new Transacao('S', valor));
        return true;
    }
}
