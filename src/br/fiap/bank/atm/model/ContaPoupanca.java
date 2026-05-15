package br.fiap.bank.atm.model;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {
    private final Double RENDIMENTO_MENSAL = 0.01; // 1%

    public ContaPoupanca(Cliente cliente, ContaAcesso contaAcesso, Dinheiro saldo) {
        super(cliente, contaAcesso, saldo, 0.01);
    }

    @Override
    protected void aplicarRegraDeTaxa() {
        BigDecimal valorRendimento = this.saldo.getValor().multiply(BigDecimal.valueOf(RENDIMENTO_MENSAL));
        Dinheiro rendimento = new Dinheiro(valorRendimento);

        this.saldo = this.saldo.somar(rendimento);
        registrarMovimentacao(TipoMovimentacao.RENDIMENTO, rendimento);
    }
}