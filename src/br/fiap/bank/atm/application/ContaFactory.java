package br.fiap.bank.atm.application;

import br.fiap.bank.atm.model.Cliente;
import br.fiap.bank.atm.model.Conta;
import br.fiap.bank.atm.model.ContaCorrente;
import br.fiap.bank.atm.model.ContaPoupanca;
import br.fiap.bank.atm.model.ContaAcesso;
import br.fiap.bank.atm.model.Dinheiro;

public class ContaFactory {
    private static ContaFactory instance;

    private ContaFactory() {}

    public static ContaFactory getInstance() {
        if (instance == null) {
            instance = new ContaFactory();
        }
        return instance;
    }

    public Conta criarContaCorrente(Cliente cliente, Dinheiro saldo) {
        ContaAcesso acessoPadrao = new ContaAcesso("1234");
        return new ContaCorrente(cliente, acessoPadrao, saldo);
    }

    public Conta criarContaPoupanca(Cliente cliente, Dinheiro saldo) {
        ContaAcesso acessoPadrao = new ContaAcesso("1234");
        return new ContaPoupanca(cliente, acessoPadrao, saldo);
    }
}