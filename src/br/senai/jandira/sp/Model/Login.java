package br.senai.jandira.sp.Model;

import java.time.LocalTime;
import java.util.Scanner;

public class Login {

    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    Conta refConta = new Conta();
    Cliente refCliente = new Cliente();
    public void entrada(){
        LocalTime horaAtual = LocalTime.now();

        if (horaAtual.isBefore(LocalTime.of(12, 0))) {
            System.out.println("------- Bom Dia! -------");
            System.out.println(" Que bom te ver por aqui! ");
            System.out.println("\n !");
        } else if (horaAtual.isBefore(LocalTime.of(18, 0))) {
            System.out.println("------- Boa Tarde ! -------");
            System.out.println(" Que bom te ver por aqui! ");
        } else {
            System.out.println("------- Boa Noite! -------");
            System.out.println(" Que bom te ver por aqui! ");

        }

        boolean exit = false;

        while (!exit) {

            System.out.println(" ================================ ");
            System.out.println(" 1 - Entrar");
            System.out.println(" 2 - Fechar App");
            System.out.println("\n Não tem cadastro?");
            System.out.println(" 3 - Cadastrar");

            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser) {

                case 1:

                    validarLogin();

                    break;

                case 2:
                    exit = true;
                    break;

                case 3:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    refCliente.addCliente(cliente);
                    break;
            }

        }
    }

    public void validarLogin() {

        System.out.print("Informe o CPF do Titular: ");
        long cpfTitular = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Informe a senha: ");
        int senhaTitular = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteLogin = refCliente.pesquisarLogin(cpfTitular,senhaTitular);

        if (clienteLogin !=null){
            System.out.println("Entrando ...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            menu.executarMenu();

        }else {
            System.out.println("O cliente não tem cadastro!");
        }
    }


}
