package br.fiap.bank.atm.model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    private final Dinheiro TAXA_MANUTENCAO = new Dinheiro(new BigDecimal("20.00"));

    public ContaCorrente(Cliente cliente, ContaAcesso contaAcesso, Dinheiro saldo) {
        super(cliente, contaAcesso, saldo, 0.0);
    }

    @Override
    protected void aplicarRegraDeTaxa() {
        if (this.saldo.maiorQue(TAXA_MANUTENCAO) || this.saldo.equals(TAXA_MANUTENCAO)) {
            this.saldo = this.saldo.subtrair(TAXA_MANUTENCAO);
            registrarMovimentacao(TipoMovimentacao.TAXA, TAXA_MANUTENCAO);
        }
        else {
            this.saldo = this.saldo.subtrair(TAXA_MANUTENCAO);
            registrarMovimentacao(TipoMovimentacao.TAXA, TAXA_MANUTENCAO);
        }
    }
}