import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroTransacoesBancarias {
    public static void registrarTransacoes(ContaBancaria conta) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Consome a nova linha

        System.out.print("Quantidade de transações: ");
        int quantidadeTransacoes = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha

        List<String> transacoes = new ArrayList<>();
        for (int i = 1; i <= quantidadeTransacoes; i++) {
            System.out.print("Tipo de transação (D para depósito ou S para saque): ");
            char tipoTransacao = scanner.next().toUpperCase().charAt(0);
            System.out.print("Valor da transação: ");
            double valorTransacao = scanner.nextDouble();
            scanner.nextLine(); // Consome a nova linha

            if (tipoTransacao == 'D') {
                saldo += valorTransacao;
                transacoes.add("Depósito de " + valorTransacao);
            } else if (tipoTransacao == 'S') {
                saldo -= valorTransacao;
                transacoes.add("Saque de " + valorTransacao);
            } else {
                System.out.println("Opção inválida. Utilize D para depósito ou S para saque.");
                i--; // Decrementa o índice para repetir a iteração
            }
        }

        System.out.println("Saldo: " + saldo);
        System.out.println("Transações:");
        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println((i + 1) + ". " + transacoes.get(i));
        }
    }
}
