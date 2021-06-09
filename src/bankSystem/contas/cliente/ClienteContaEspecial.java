package bankSystem.contas.cliente;

import bankSystem.contas.ContaCorrente;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class ClienteContaEspecial extends ContaCorrente {

    private Boolean iniciator = true;
    private final List<String> opcoes = Arrays.asList("sacar", "sair");
    private Double valorLimite;
    private String nome;

    public ClienteContaEspecial(){
        this.valorLimite = 0.00;
        this.nome = "";
    }

    public ClienteContaEspecial(String nome, Double valorlimite, Double saldo, Double salario) {
        this.valorLimite = valorlimite;
        super.saldo = saldo;
        super.salario = salario;
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void sacar(Double escolhaValor){
        if(this.valorLimite < 1){
            JOptionPane.showMessageDialog(null,"Voce nao definiu o valor limite para ser sacado!");
        }else{
            if (escolhaValor > this.valorLimite) {
                JOptionPane.showMessageDialog(null, String.format( "Valor negado!" + "\n"
                        + "Voce tentou sacar R$ " +escolhaValor+ ", e ultraprassou o limite de R$%.2f mil reais.", this.valorLimite));

            }else {

                JOptionPane.showMessageDialog(null,  "Voce acabou de efetuar o saque de R$"+ escolhaValor + " reais com sucesso!");
                super.saldo -= escolhaValor;

            }
        }

    }

    public Double getValorLimite() {
        return this.valorLimite;
    }

    public void setValorLimite(Double valorLimite) {
        this.valorLimite = valorLimite;
    }

    public void menuBank() {
        JOptionPane.showMessageDialog(null, "Menu Bank - Conta Especial" );
        JOptionPane.showMessageDialog(null,"Faca agora seus emprestimos e garanta " +
                "que seu nome fique limpo!");
        while(iniciator){
            super.escolha = JOptionPane.showInputDialog("MENU DE OPCOES: " + "\n"+
                    "[sacar]" +"\n"+ "[sair]");
            if(opcoes.contains(escolha)){
                if(super.escolha.equalsIgnoreCase("sacar")){
                    try {
                        JOptionPane.showMessageDialog(null, "Sacar dinheiro.");
                        JOptionPane.showMessageDialog(null, String.format( "O valor limite para " +
                                "sacar e ate R$%.2f mil reais.", this.valorLimite));
                        super.escolhaValor = Double.parseDouble(JOptionPane.showInputDialog("Valor a ser sacado: R$"));
                        sacar(super.escolhaValor);
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Valor depositado invalido!");
                    }

                }

                else if(this.escolha.equalsIgnoreCase("sair")){
                    JOptionPane.showMessageDialog(null, "Saindo do sistema Menu Bank...");
                    iniciator = false;
                }

            }else{
                JOptionPane.showMessageDialog(null, "[ERROR DE OPCAO]" + "\n" +
                        "Tente novamente!");

            }

        }

    }

    public String toString() {
        return String.format( "Nome: %s "+ "\n"+  "Salario: R$%.2f" + "\n" + "Saldo: R$%.2f"+ "\n" + "Valor limite de Saque: R$%.2f",
                this.nome, super.getSalario(), super.saldo, this.valorLimite );
    }

}
