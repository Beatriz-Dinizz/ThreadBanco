package controller;

import java.util.concurrent.Semaphore;

public class Transacao extends Thread {
    private Conta conta;
    private double valor;
    private String tipo; 
    private Semaphore saqueDepositoSemaphore;

    public Transacao(Conta conta, double valor, String tipo, Semaphore saqueDepositoSemaphore) {
        this.conta = conta;
        this.valor = valor;
        this.tipo = tipo;
        this.saqueDepositoSemaphore = saqueDepositoSemaphore;
    }

    @Override
    public void run() {
        try {
            saqueDepositoSemaphore.acquire(); 
            if (tipo.equals("Saque")) {
                conta.sacar(valor);
            } else if (tipo.equals("Depósito")) {
                conta.depositar(valor);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            saqueDepositoSemaphore.release(); 
        }
    }
}
