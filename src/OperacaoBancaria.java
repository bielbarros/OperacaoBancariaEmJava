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

        String numeroConta = null;
        boolean numeroContaValido = false;

        while (!numeroContaValido) {
            System.out.println("Insira o número da sua conta:");

            try {
                numeroConta = scanner.nextLine();
                verificarNumeroConta(numeroConta, saldo, protocolNumber, scanner);
                numeroContaValido = true; // Marca como válido apenas se passou pelo método sem exceção
                System.out.println("Número de conta válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                // Permite que o usuário insira o número da conta novamente
            }
        }

        // Agora que temos o número de conta válido, entramos no loop principal
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
        // Encerra o scanner
        scanner.close();
    }

    private static void verificarNumeroConta(String numeroConta, double saldo, int protocolNumber, Scanner scanner) {
        if (numeroConta.length() != 8) {
            throw new IllegalArgumentException("Número de conta inválido. Digite exatamente 8 dígitos.");
        }
    }
}



