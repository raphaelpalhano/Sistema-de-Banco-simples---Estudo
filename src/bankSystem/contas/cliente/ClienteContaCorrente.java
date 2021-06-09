package bankSystem.contas.cliente;

import bankSystem.contas.ContaCorrente;

import javax.swing.*;



public class ClienteContaCorrente extends ContaCorrente{
    private String nome;
    private String profissao;



    public ClienteContaCorrente(){
       this.nome = "";
       this.profissao = "";


    }

    public ClienteContaCorrente(String nome, String profissao, Double salario, Double saldo){
        this.nome = nome;
        this.profissao = profissao;
        super.salario = salario;
        super.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao){
        this.profissao = profissao;
    }



    public String toString(){
        return String.format("Nome: %s " + "\n"  +"Profissao: %s" + "\n"+ "Salario: %.2f" + "\n" + "Saldo: %.2f",
                this.nome, this.profissao, super.salario, super.saldo);
    }


}
