import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperacaoBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        Random random = new Random();

        int digits = 8;
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        int protocolNumber = random.nextInt(max - min + 1) + min;

        while (true) {
            System.out.println("\nSimulador de Banco");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Consultar Transações");
            System.out.println("6. Registrar Transações");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Número da Conta: ");
                    String numeroConta = scanner.nextLine();

                    System.out.print("Nome do Titular: ");
                    String nomeTitular = scanner.nextLine();

                    System.out.print("Saldo Inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine(); // Consome a nova linha

                    banco.criarConta(numeroConta, nomeTitular, saldoInicial);
                    break;

                case 2:
                    System.out.print("Número da Conta: ");
                    String numeroContaDeposito = scanner.nextLine();
                    ContaBancaria contaDeposito = banco.buscarConta(numeroContaDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Valor do Depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine(); // Consome a nova linha
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da Conta: ");
                    String numeroContaSaque = scanner.nextLine();
                    ContaBancaria contaSaque = banco.buscarConta(numeroContaSaque);
                    if (contaSaque != null) {
                        System.out.print("Valor do Saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine(); // Consome a nova linha
                        if (contaSaque.sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Número da Conta: ");
                    String numeroContaConsulta = scanner.nextLine();
                    ContaBancaria contaConsulta = banco.buscarConta(numeroContaConsulta);
                    if (contaConsulta != null) {
                        System.out.println("Saldo: " + contaConsulta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Número da Conta: ");
                    String numeroContaTransacoes = scanner.nextLine();
                    ContaBancaria contaTransacoes = banco.buscarConta(numeroContaTransacoes);
                    if (contaTransacoes != null) {
                        System.out.println("Transações:");
                        contaTransacoes.getTransacoes().stream()
                                .map(transacao -> String.format("%c de %.1f", Character.toLowerCase(transacao.getTipo()), transacao.getValor()))
                                .collect(Collectors.toList())
                                .forEach(System.out::println);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Número da Conta: ");
                    String numeroContaRegistro = scanner.nextLine();
                    ContaBancaria contaRegistro = banco.buscarConta(numeroContaRegistro);
                    if (contaRegistro != null) {
                        RegistroTransacoesBancarias.registrarTransacoes(contaRegistro);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    System.out.println("Número de protocolo gerado: " + protocolNumber);
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
