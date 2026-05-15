package br.fiap.bank.atm.model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Objects;

public abstract class BaseEntity {
    protected UUID id;
    protected LocalDate dataCriacao;

    public BaseEntity() {
        this.id = UUID.randomUUID();
        this.dataCriacao = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BaseEntity that = (BaseEntity) obj;
        return Objects.equals(id, that.id);
    }
}