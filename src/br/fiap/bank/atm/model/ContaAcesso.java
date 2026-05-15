package br.fiap.bank.atm.model;

import java.util.Objects;

public class ContaAcesso {
    public final Integer MAXIMO_TENTATIVAS = 3;
    private String senha;
    private Integer tentativas;
    private Boolean bloqueado;

    public ContaAcesso(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("A senha não pode ser vazia.");
        }
        this.senha = senha;
        this.tentativas = 0;
        this.bloqueado = false;
    }

    public Boolean validarSenha(String senhaDigitada) {
        if (bloqueado) {
            return false;
        }

        if (this.senha.equals(senhaDigitada)) {
            resetarTentativas();
            return true;
        }
        else {
            tentativas++;
            if (tentativas >= MAXIMO_TENTATIVAS) {
                bloqueado = true;
            }
            return false;
        }
    }

    public Boolean isBloqueado() {
        return bloqueado;
    }

    public void resetarTentativas() {
        this.tentativas = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ContaAcesso that = (ContaAcesso) obj;
        return Objects.equals(senha, that.senha) &&
                Objects.equals(tentativas, that.tentativas) &&
                Objects.equals(bloqueado, that.bloqueado);
    }
}