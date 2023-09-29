package br.senai.jandira.sp.Model;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Cliente refCliente = new Cliente();
    Conta refConta = new Conta();

    Login login = new Login();

    public void executarMenu() {

        boolean exit = false;

        while (!exit) {

            System.out.println(" |--------------------------| ");
            System.out.println(" |           Menu           | ");
            System.out.println(" |--------------------------| \n");
            System.out.println(" 1 - Gerar Conta");
            System.out.println(" 2 - Consultar Saldo");
            System.out.println(" 3 - Realizar Deposito");
            System.out.println(" 4 - Realizar Saque");
            System.out.println(" 5 - Realizar Transferencia");
            System.out.println(" 6 - Sair da Conta");
            System.out.println("\n |------------------------|\n ");

            System.out.print("Escolha a Opção: ");
            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {


                case 1:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfTitular = scanner.nextLong();
                    scanner.nextLine();

                    Cliente clienteConta = refCliente.pesquisarCliente(cpfTitular);

                    if (clienteConta !=null){
                        Conta conta = new Conta();
                        conta.gerarConta(clienteConta);
                        refConta.addConta(conta);
                        System.out.println("Conta criada com sucesso!");

                    }else {
                        System.out.println("O cliente não tem cadastro!");
                    }
                    break;

                case 2:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfSaldo = scanner.nextLong();
                    scanner.nextLine();
                    Conta contaSaldo= refConta.pesquisarConta(cpfSaldo);

                    if (contaSaldo !=null){
                        contaSaldo.consultarSaldo();
                    }else{
                        System.out.println("O cliente não tem conta!");
                    }


                    break;

                case 3:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();
                    Conta contaDeposito= refConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito !=null){
                        System.out.println("Informe o valor do Depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.realizarDeposito(valorDeposito);
                    }else{
                        System.out.println("O cliente não tem conta!");
                    }

                    break;

                case 4:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();
                    Conta contaSaque = refConta.pesquisarConta(cpfSaque);

                    if (contaSaque !=null){
                        System.out.println("Informe o valor do Saque: ");
                        double valorSaque = scanner.nextDouble();
                        contaSaque.realizarDeposito(valorSaque);
                    }else{
                        System.out.println("O cliente não tem conta!");
                    }
                    break;

                case 5:

                    System.out.println("Informe o CPF do Titular:");
                    long cpfOrigem = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Informe o CPF do Destinatário:");
                    long cpfDestinatario = scanner.nextLong();
                    scanner.nextLine();

                    Conta contaOrigem = refConta.pesquisarConta(cpfOrigem);
                    Conta contaDestinatario = refConta.pesquisarConta(cpfDestinatario);

                    if (contaOrigem !=null && contaDestinatario !=null){

                        contaOrigem.realizarTranferencia(contaOrigem, contaDestinatario);

                    }else{
                        System.out.println("O CPF do Titular ou do Destinatario está incorreto!");
                    }

                    break;

                case 6:

                    exit= true;
                    break;

            }

        }


    }
}
