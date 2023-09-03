import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaBancaria {
    private static List<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*** Bem Vindo ao Revolution ***");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Acessar Conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    acessarConta();
                    break;
                case 3:
                    System.out.println("Saindo do sistema. Até logo!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.print("Digite o nome completo do cliente: ");
        scanner.nextLine(); // Limpar o buffer do teclado
        String nome = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String email = scanner.next();
        System.out.print("Digite a data de nascimento do cliente (DD/MM/AAAA): ");
        String dataNascimento = scanner.next();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.next();

        Cliente novoCliente = new Cliente(nome, email, dataNascimento, cpf);
        clientes.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Número da Agência: " + novoCliente.getNumeroAgencia());
        System.out.println("Número da Conta: " + novoCliente.getNumeroConta());
    }

    private static void acessarConta() {
        System.out.print("Digite o número da agência: ");
        int numeroAgencia = scanner.nextInt();
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();

        Cliente cliente = encontrarCliente(numeroAgencia, numeroConta);

        if (cliente == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        while (true) {
            System.out.println("\n*** Bem-vindo, " + cliente.getNome() + " ***");
            System.out.println("Número da Agência: " + cliente.getNumeroAgencia());
            System.out.println("Número da Conta: " + cliente.getNumeroConta());
            System.out.println("Saldo: R$" + cliente.getSaldo());
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Fazer Empréstimo");
            System.out.println("4. Transferir");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(valorSaque);
                    break;
                case 3:
                    System.out.print("Digite o valor do empréstimo: ");
                    double valorEmprestimo = scanner.nextDouble();
                    cliente.fazerEmprestimo(valorEmprestimo);
                    break;
                case 4:
                    System.out.print("Digite o número da agência do destinatário: ");
                    int numeroAgenciaDestinatario = scanner.nextInt();
                    System.out.print("Digite o número da conta do destinatário: ");
                    int numeroContaDestinatario = scanner.nextInt();
                    Cliente destinatario = encontrarCliente(numeroAgenciaDestinatario, numeroContaDestinatario);

                    if (destinatario == null) {
                        System.out.println("Conta destinatária não encontrada.");
                    } else {
                        System.out.print("Digite o valor para transferência: ");
                        double valorTransferencia = scanner.nextDouble();
                        cliente.transferir(destinatario, valorTransferencia);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static Cliente encontrarCliente(int numeroAgencia, int numeroConta) {
        for (Cliente cliente : clientes) {
            if (cliente.getNumeroAgencia() == numeroAgencia && cliente.getNumeroConta() == numeroConta) {
                return cliente;
            }
        }
        return null;
    }
}