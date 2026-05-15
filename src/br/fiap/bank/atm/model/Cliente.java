package br.fiap.bank.atm.model;

public class Cliente extends BaseEntity {
    private String nomeCompleto;

    public Cliente(String nomeCompleto) {
        super();
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("O cliente deve ter um nome completo.");
        }
        this.nomeCompleto = nomeCompleto;
    }

    public String obterPrimeiroNome() {
        if (nomeCompleto != null && nomeCompleto.contains(" ")) {
            return nomeCompleto.split(" ")[0];
        }
        return nomeCompleto;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
}