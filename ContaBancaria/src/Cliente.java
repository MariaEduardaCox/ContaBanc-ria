import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    protected static int proximoNumeroConta = 1;
    protected static int proximoNumeroAgencia = 1;

    protected int numeroConta;
    protected int numeroAgencia;
    protected String nome;
    protected String email;
    protected String dataNascimento;
    protected String cpf;
    protected double saldo;

    public static int getProximoNumeroConta() {
        return proximoNumeroConta;
    }

    public static void setProximoNumeroConta(int proximoNumeroConta) {
        Cliente.proximoNumeroConta = proximoNumeroConta;
    }

    public static int getProximoNumeroAgencia() {
        return proximoNumeroAgencia;
    }

    public static void setProximoNumeroAgencia(int proximoNumeroAgencia) {
        Cliente.proximoNumeroAgencia = proximoNumeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente(String nome, String email, String dataNascimento, String cpf) {
        this.numeroConta = proximoNumeroConta++;
        this.numeroAgencia = proximoNumeroAgencia++;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.saldo = 40.0; // Valor inicial da conta
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
        }
    }

    public void fazerEmprestimo(double valor) {
        double limite = 10000.0;

        if (saldo > 1000.0) {
            if (valor <= saldo) {
                saldo -= valor;
                System.out.println("Empréstimo de R$" + valor + " realizado com sucesso. Saldo atual: R$" + saldo);
            } else if (valor <= limite) {
                double valorEmprestimo = saldo;
                saldo = 0;
                System.out.println("Empréstimo de R$" + valorEmprestimo + " realizado com sucesso. Saldo atual: R$" + saldo);
            } else {
                System.out.println("Valor de empréstimo não disponível.");
            }
        } else {
            System.out.println("Empréstimo não disponível para esta conta.");
        }
    }

    public void transferir(Cliente destinatario, double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para a transferência.");
        } else {
            saldo -= valor;
            destinatario.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada com sucesso.");
        }
    }

    public void mostrarDados() {
        System.out.println("Número da Agência: " + numeroAgencia);
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("CPF: " + cpf);
        System.out.println("Saldo: R$" + saldo);
    }
}
