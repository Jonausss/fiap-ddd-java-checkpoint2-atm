package br.fiap.bank.atm.application;

import br.fiap.bank.atm.model.Cliente;
import br.fiap.bank.atm.model.Conta;
import br.fiap.bank.atm.model.Dinheiro;
import br.fiap.bank.atm.presentation.TerminalBancarioController;
import br.fiap.bank.atm.infrastructure.ContaRepository;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Bruce Wayne");
        Dinheiro saldoInicial = new Dinheiro(new BigDecimal("0.00"));

        Conta minhaConta = ContaFactory.getInstance().criarContaCorrente(cliente, saldoInicial);

        ContaRepository repository = new ContaRepository();
        repository.salvar(minhaConta);

        ContaService contaService = new ContaService(minhaConta);
        AutorizacaoService autorizacaoService = new AutorizacaoService(minhaConta);

        TerminalBancarioController terminal = new TerminalBancarioController(contaService, autorizacaoService);

        terminal.iniciar();
    }
}