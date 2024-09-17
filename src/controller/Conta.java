package controller;

public class Conta {
	private String codigoConta;
    private double saldo;

    public Conta(String codigoConta, double saldoInicial) {
        this.codigoConta = codigoConta;
        this.saldo = saldoInicial;
    }

    public synchronized boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado na conta " + codigoConta + ". Saldo atual: " + saldo);
            return true;
        } else {
            System.out.println("Saque de " + valor + " falhou na conta " + codigoConta + ". Saldo insuficiente.");
            return false;
        }
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado na conta " + codigoConta + ". Saldo atual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
