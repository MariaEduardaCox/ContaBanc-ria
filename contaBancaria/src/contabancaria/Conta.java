package contabancaria;

public class Conta {

    private static int contadorContas = 1;

    private int numeroConta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(int numeroConta, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        contadorContas += 1;
    }

    Conta(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta()
                + "\nNome: " + this.cliente.getNome()
                + "\nCpf: " + this.cliente.getCpf()
                + "\nEmail: " + this.cliente.getEmail()
                + "\nSaldo: " + Numeros.doubleToString(this.getSaldo())
                + "\n";
    }
   public void depositar(Double valor){
       if(valor > 0){
           setSaldo(getSaldo()+ valor);
           System.out.println("DEPÓSITO REALIZADO!");
       }else{
           System.out.println("NÃO FOI POSSÍVEL DEPOSITAR ESSE VALOR!");
       }
   }
   public void saque(Double valor){
       if(valor > 0 && this.getSaldo() >= valor){
           setSaldo(getSaldo()- valor);
           System.out.println("SAQUE REALIZADO!");
       } else{
           System.out.println("NÃO FOI POSSÍVEL REALIZAR O SAQUE!");
       }
   }
   public void transferir(Conta contaParaDeposito, Double valor){
       if(valor > 0 && this.getSaldo() >= valor){
           setSaldo(getSaldo()- valor);
           
           contaParaDeposito.saldo = contaParaDeposito.getSaldo()+ valor;
           System.out.println("TRANSFERÊNCIA REALIZADA!");
       }else{
           System.out.println("NÃO FOI POSSÍVEL REALIZAR A TRANSFERÊNCIA!");
       }
   }

    }

