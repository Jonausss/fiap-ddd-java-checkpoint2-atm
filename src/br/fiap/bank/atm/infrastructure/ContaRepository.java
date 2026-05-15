package br.fiap.bank.atm.infrastructure;

import br.fiap.bank.atm.model.Conta;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContaRepository {
    private List<Conta> contasDatabase;

    public ContaRepository() {
        this.contasDatabase = new ArrayList<>();
    }

    public void salvar(Conta conta) {
        this.contasDatabase.add(conta);
    }

    public Conta buscarPorId(UUID id) {
        for (Conta conta : contasDatabase) {
            if (conta.getId().equals(id)) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> listarTodas() {
        return this.contasDatabase;
    }
}
