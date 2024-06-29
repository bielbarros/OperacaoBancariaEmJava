import java.util.Scanner;
import java.util.Random;

public class OperacaoBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        boolean continuar = true;

        Random random = new Random();

        int digits = 8;
        int min = (int) Math.pow(10, digits - 1); // mínimo = 10000000 (8 dígitos)
        int max = (int) Math.pow(10, digits) - 1; // máximo = 99999999 (8 dígitos)

        int protocolNumber = random.nextInt(max - min + 1) + min;

        System.out.println("Bem-vindo ao Banco Java!");
        System.out.println("Insira o número da sua conta:");

        try {
            String numeroConta = scanner.nextLine();
            verificarNumeroConta(numeroConta, saldo, continuar, protocolNumber, scanner);
            System.out.println("Número de conta válido.");
            // Chamar o método que verifica se o número da conta é válido

            // Caso nenhuma exceção seja lançada, imprime a mensagem de sucesso.
        } catch (IllegalArgumentException e) {
            // Informar que o número de conta é inválido e exibir a mensagem de erro
            System.out.println("Erro: " + e.getMessage());
        } finally {
            // Fechar o scanner para evitar vazamentos de recursos
            scanner.close();
        }
    }

    private static void verificarNumeroConta(String numeroConta, double saldo, boolean continuar, int protocolNumber, Scanner scanner) {
        if (numeroConta.length() != 8) {
            throw new IllegalArgumentException("Número de conta inválido. Digite exatamente 8 dígitos.");
            // Lançar uma IllegalArgumentException com a seguinte mensagem:
            // "Número de conta inválido. Digite exatamente 8 dígitos."
        }

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar Saldo");
            System.out.println("0 - Encerrar");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    saldo += valorDeposito;
                    System.out.printf("Saldo atual: %.1f\n", saldo);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    if (valorSaque <= saldo) {
                        saldo -= valorSaque;
                        System.out.printf("Saldo atual: %.1f\n", saldo);
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.printf("Saldo atual: %.1f\n", saldo);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    System.out.println("Número de protocolo gerado: " + protocolNumber);
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
