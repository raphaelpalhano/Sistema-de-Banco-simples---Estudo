package bankSystem.contas;

import bankSystem.contas.cliente.ClienteContaEspecial;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public abstract class ContaCorrente{
    protected String  escolha;
    protected Double escolhaValor;
    protected Double salario;
    protected Double saldo;
    private final Float taxa = 20.00f;
    private final List<String> opcoes = Arrays.asList("depositar", "sacar", "transferir", "sair");
    private Boolean iniciador = true;

    public ContaCorrente() {
        this.saldo = 00.0;

    }


    public ContaCorrente(Double salario, Double saldo) {
        this.salario = salario;
        this.saldo = saldo;

    }

    public Double getSaldo() {
        return saldo;
    }


    public Double getSalario() {
        return  salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }


    public void depositar(Double escolhaValor){

        if (escolhaValor > 50000.50) {
            JOptionPane.showMessageDialog(null, "Valor negado!" + "\n"
                    + "Voce tentou depositar R$"+ escolhaValor +", e ultraprassou o limite de R$50.000 mil reais.");

        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Voce acabou de efetuar o deposito de R$"+ escolhaValor + " reais com sucesso!");
            this.saldo += escolhaValor;
        }
    }

    public void sacar(Double escolhaValor){
        try {
            if (escolhaValor > 5000.00) {
                JOptionPane.showMessageDialog(null, "Valor negado!" + "\n"
                        + "Voce tentou sacar R$ " + escolhaValor + ", e ultraprassou o limite de R$5.000 mil reais.");

            } else {
                if (escolhaValor > this.saldo) {
                    JOptionPane.showMessageDialog(null, "Voce nao possui saldo suficiente" +
                            "para sacar essa quantia." + "\n" + "Tente acessar sua Conta Especial!");

                } else {
                    JOptionPane.showMessageDialog(null, "Voce acabou de efetuar o saque de R$" + escolhaValor + " reais com sucesso!");
                    this.saldo -= escolhaValor;
                }

            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor limite invalido!");
        }
    }



    /*  APLICANDO O CONCEITO DE COMPOSIÇÃO: SO PODE ACESSAR ATRAVES DO MENU*/
    private void transferir() {
        try{
            JOptionPane.showMessageDialog(null, "Transferencia para Conta Especial");
            Double valorlimte = Double.parseDouble( JOptionPane.showInputDialog("Valor limite:"));
            System.out.println(valorlimte);
            ClienteContaEspecial contaEspecial = new ClienteContaEspecial("", valorlimte, this.saldo, this.salario);
            this.saldo -= this.taxa;
            contaEspecial.menuBank();
            if(contaEspecial.escolhaValor != null && contaEspecial.escolhaValor > 0){
                this.saldo -= contaEspecial.escolhaValor;
                iniciador = false;
            }else{
                iniciador = false;
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Valor limite invalido!");
        }
    }

    public void menuBank() {
        JOptionPane.showMessageDialog(null, "Sistema Menu Bank" );
        JOptionPane.showMessageDialog(null,"A facilidade em suas maos, para voce sacar, depositar ou" +
                " transferir seu dinheiro para uma conta especial por apenas uma taxa administrativa!");
        while(iniciador){
            this.escolha = JOptionPane.showInputDialog("MENU DE OPCOES: " + "\n"+
                    "[sacar]" +"\n"+ "[depositar]" +"\n" + "[transferir]" +"\n" +
                    "[sair]");
            if(opcoes.contains(escolha)){
                if(this.escolha.equalsIgnoreCase("sacar")){
                    try {
                        JOptionPane.showMessageDialog(null, "Sacar dinheiro.");
                        JOptionPane.showMessageDialog(null, "O valor limite para sacar e ate R$5.000 mil reais.");
                        this.escolhaValor = Double.parseDouble(JOptionPane.showInputDialog("Valor a ser sacado: R$"));
                        sacar(this.escolhaValor);
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Valor de saque invalido!");
                    }


                }else if(this.escolha.equalsIgnoreCase("depositar")){
                    try{
                        JOptionPane.showMessageDialog(null, "Depositar dinheiro.");
                        JOptionPane.showMessageDialog(null, "O valor limite para deposito e ate R$50.000 mil reais.");
                        this.escolhaValor = Double.parseDouble(JOptionPane.showInputDialog("Valor a ser depositado: R$"));
                        depositar(this.escolhaValor);
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Valor depositado invalido!");
                    }


                }else if(this.escolha.equalsIgnoreCase("transferir")){
                    transferir();
                }
                else if(this.escolha.equalsIgnoreCase("sair")){
                    JOptionPane.showMessageDialog(null, "Saindo do sistema Menu Bank...");
                    iniciador = false;
                }

            }else{
                JOptionPane.showMessageDialog(null, "[ERROR DE OPCAO]" + "\n" +
                        "Tente novamente!");

            }

        }

    }

    public String toString() {
        return String.format("Salario: %.2f" + "\n" + "Saldo: %.2f",
                 this.getSalario(), this.getSaldo() );
        }




}
