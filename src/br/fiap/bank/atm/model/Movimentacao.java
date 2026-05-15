package br.fiap.bank.atm.model;

import java.time.LocalDateTime;

public class Movimentacao extends BaseEntity {
    private LocalDateTime dataHora;
    private Dinheiro valor;
    private TipoMovimentacao tipo;

    public Movimentacao(TipoMovimentacao tipo, Dinheiro valor) {
        super();
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public Dinheiro getValor() {
        return valor;
    }
}