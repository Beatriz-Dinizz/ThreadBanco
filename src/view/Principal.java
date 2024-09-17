package view;

import controller.Conta;
import controller.Transacao;
import java.util.concurrent.Semaphore;

public class Principal {
    public static void main(String[] args) {
        Conta conta = new Conta("12345-6", 1000.0); 
        Semaphore saqueDepositoSemaphore = new Semaphore(1); 

        for (int i = 0; i < 20; i++) {
            double valor = Math.random() * 500; 
            String tipo = Math.random() < 0.5 ? "Saque" : "Depósito"; 

            Transacao transacao = new Transacao(conta, valor, tipo, saqueDepositoSemaphore);
            transacao.start();
        }
    }
}
