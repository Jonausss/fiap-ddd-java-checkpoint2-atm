package br.fiap.bank.atm.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Dinheiro {
    private BigDecimal valor;

    public Dinheiro(BigDecimal valor) {
        this.valor = valor;
    }

    public Dinheiro somar(Dinheiro outro) {
        return new Dinheiro(this.valor.add(outro.valor));
    }

    public Dinheiro subtrair(Dinheiro outro) {
        return new Dinheiro(this.valor.subtract(outro.valor));
    }

    public Boolean maiorQue(Dinheiro outro) {
        return this.valor.compareTo(outro.valor) > 0;
    }

    public Boolean menorQue(Dinheiro outro) {
        return this.valor.compareTo(outro.valor) < 0;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Dinheiro dinheiro = (Dinheiro) obj;
        return this.valor.compareTo(dinheiro.valor) == 0;
    }
}