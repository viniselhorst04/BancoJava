package br.senai.jandira.sp.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {

    private String agencia = "1258-X";
    private int numeroConta ;
    private double saldo = 0;

    private Cliente cliente;

    Scanner scanner = new Scanner(System.in);

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    List<Conta> contaList = new ArrayList<>();

    public void addConta(Conta conta){
        contaList.add(conta);
    }

    public Conta pesquisarConta(long cpf){
        for (Conta conta: contaList) {
            long cpfConta = conta.cliente.getCpf();

            if (cpfConta == cpf){
                return conta;
            }
        }
        return null;

    }

    public void gerarConta(Cliente cliente){
        this.cliente = cliente;
        numeroConta = (int) (Math.random()*10000);

    }


    public void realizarDeposito(double valor){

        this.saldo += valor;
        System.out.println(" O saldo disponivel é : " + this.saldo);

    }
    public void realizarSaque(double valor){

        boolean validaSaque = avaliarSaque(valor);

        if (validaSaque) {
            this.saldo -= valor;
            System.out.println(" O saldo disponivel é : " + this.saldo);

        }else {
            System.out.println(" SAQUE INDISPONIVEL!! Pois o saldo disponivel é: " + this.saldo);
        }

    }
    public void consultarSaldo(){

        System.out.println(" O saldo disponivel é : " + this.saldo);
    }

    public boolean avaliarSaque(double valor){
        if (this.saldo >= valor){
            return true;
        }else {
            return false;
        }

    }

    public void realizarTranferencia( Conta contaUser,Conta contaDest){



        System.out.println("Informe o valor da Transferencia: ");
        double valorTransferencia = scanner.nextDouble();
        scanner.nextLine();

        double saldoDisponivel = contaUser.getSaldo();

        if ( saldoDisponivel >= valorTransferencia) {

            saldoDisponivel -= valorTransferencia;
            contaUser.setSaldo(saldoDisponivel);

            double saldoDest = contaDest.getSaldo();
            saldoDest += valorTransferencia;
            contaDest.setSaldo(saldoDest);

            System.out.println(" Transferencia Realizada!");
            System.out.println(" Agora seu Saldo é: " + contaUser.getSaldo());
        }else{
            System.out.println(" Saldo insuficiente para está Transferencia!");
        }

    }

}
