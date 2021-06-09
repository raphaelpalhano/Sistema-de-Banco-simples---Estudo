package bankSystem;

import bankSystem.contas.cliente.ClienteContaEspecial;
import bankSystem.contas.cliente.ClienteContaCorrente;

import javax.swing.*;

public class AcessandoBanco {
    public static void main(String[] args){

        // CLIENTE COM CONTA CORRENTE COM BÔNUS DA CONTAL ESPECIAL, TEM A POSSIBILIDADE DE ACESSAR O RECURSO PAGANDO A TAXA DE 20 REAIS:
        ClienteContaCorrente cliente1 = new ClienteContaCorrente("Joaquim", "Pedreiro", 1200.00, 3200.00);
        cliente1.menuBank();
        JOptionPane.showMessageDialog(null, cliente1);



        //CLIENTE SOMENTE COM COM CONTA ESPECIAL:
        ClienteContaEspecial clienteEspecial = new ClienteContaEspecial("Juca", 15000.00, 3000.00, 1200.00);
        clienteEspecial.depositar(3000.00);
        clienteEspecial.sacar(10000.00);
        JOptionPane.showMessageDialog(null, clienteEspecial.getSaldo());
        clienteEspecial.menuBank();
        JOptionPane.showMessageDialog(null,  clienteEspecial);
        
    }
}
