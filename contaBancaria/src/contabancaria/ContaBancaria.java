package contabancaria;

import java.util.ArrayList;
import java.util.Scanner;

public class ContaBancaria {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("=================================================================");
        System.out.println("=============== SEJA BEM VINDO AO BANCO TARGARYEN ===============");
        System.out.println("=================================================================");
        System.out.println("|  Digite 1 - Criar conta  |");
        System.out.println("|  Digite 2 - Depositar  |");
        System.out.println("|  Digite 3 - Sacar  |");
        System.out.println("|  Digite 4 - Transferir  |");
        System.out.println("|  Digite 5 - Listar  |");
        System.out.println("|  Digite 6 - Sair  |");

        int menu = sc.nextInt();

        switch (menu) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("OBRIGADO POR SER NOSSO CLIENTE, ATÉ A PRÓXIMA!");
                System.exit(0);
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
                operacoes();
                break;

        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = sc.next();

        System.out.println("\nCPF: ");
        String cpf = sc.next();

        System.out.println("\nEmail: ");
        String email = sc.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("CONTA CRIADA!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta);
                conta = c;
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("DIGITE O NÚMERO DA CONTA: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("DIGITE O VALOR DO DEPÓSITO: ");
            double valorDeposito = sc.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("DEPÓSITO REALIZADO!");
        } else {
            System.out.println("CONTA NÃO ENCONTRADA!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("DIGITE O NÚMERO DA CONTA: ");
        int numeroConta = sc.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("DIGITE O VALOR DO SAQUE: ");
            double valorSaque = sc.nextDouble();
            conta.saque(valorSaque);
            System.out.println("SAQUE REALIZADO!");
        } else {
            System.out.println("CONTA NÃO ENCONTRADA!");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("DIGITE O NÚMERO DA CONTA DO COLABORADOR: ");
        int numeroContaColaborador = sc.nextInt();

        Conta contaColaborador = encontrarConta(numeroContaColaborador);

        if (contaColaborador != null) {
            System.out.println("DIGITE O NÚMERO DA CONTA DO RECEPTOR: ");
            int numeroContaReceptor = sc.nextInt();

            Conta contaReceptor = encontrarConta(numeroContaReceptor);

            if (contaReceptor != null) {
                System.out.println("DIGITE O VALOR DA ATRANSFERÊNCIA: ");
                double valor = sc.nextDouble();

                contaColaborador.transferir(contaReceptor, valor);
            }
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            contasBancarias.stream().forEach((conta) -> {
                System.out.println(conta);
            });
        } else {
            System.out.println("SEM CONTAS CADASTRADAS!");
        }
        operacoes();
    }
}
