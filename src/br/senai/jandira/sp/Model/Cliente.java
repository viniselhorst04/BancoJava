package br.senai.jandira.sp.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private int senha;
    private long cpf, rg, telefone;

    Scanner teclado = new Scanner(System.in);

    List<Cliente> listCliente = new ArrayList<>();

    public void addCliente(Cliente cliente){
        listCliente.add(cliente);
    }

    public Cliente pesquisarCliente(long cpf){
        for (Cliente cliente: listCliente) {
            long cpfCliente = cliente.getCpf();

            if (cpfCliente == cpf){
                return cliente;
            }
        }
        return null;
    }

    public Cliente pesquisarLogin(long cpf, int senha){
        for (Cliente cliente: listCliente) {
            long cpfCliente = cliente.getCpf();
            int senhaCliente = cliente.getSenha();

            if (cpfCliente == cpf && senhaCliente == senha){
                return cliente;
            }
        }
        return null;
    }


    public void cadastrarCliente(){

        System.out.println(" ----------------- CADASTRAR CLIENTE ---------------- ");
        System.out.println("\n Informe seu nome: ");
        nome = teclado.nextLine();
        System.out.println("\n Informe uma senha: ");
        senha = teclado.nextInt();
        teclado.nextLine();
        System.out.println(" Informe seu CPF: ");
        cpf = teclado.nextLong();
        System.out.println(" Informe seu RG: ");
        rg = teclado.nextLong();
        System.out.println(" Informe seu Telefone: ");
        telefone = teclado.nextLong();
        teclado.nextLine();
        System.out.println(" ---------------------------------------------------- ");

    }


    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf(){
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
