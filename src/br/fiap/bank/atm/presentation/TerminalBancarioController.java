package br.fiap.bank.atm.presentation;

import br.fiap.bank.atm.application.AutorizacaoService;
import br.fiap.bank.atm.application.ContaService;
import br.fiap.bank.atm.model.Dinheiro;
import br.fiap.bank.atm.model.Movimentacao;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TerminalBancarioController {
    private ContaService contaService;
    private AutorizacaoService autorizacaoService;
    private Scanner scanner;

    public TerminalBancarioController(ContaService contaService, AutorizacaoService autorizacaoService) {
        this.contaService = contaService;
        this.autorizacaoService = autorizacaoService;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("===============================");
        System.out.println("  BEM-VINDO AO FIAP BANK ATM   ");
        System.out.println("===============================");
        Boolean autenticado = false;

        while (!autenticado) {
            System.out.print("Digite sua senha de acesso: ");
            String senhaDigitada = scanner.nextLine();

            autenticado = autorizacaoService.autorizar(senhaDigitada);

            if (autenticado) {
                System.out.println("Acesso liberado!\n");
                exibirMenuPrincipal();
            } else {
                System.out.println("Senha incorreta ou conta bloqueada por excesso de tentativas.");
            }
        }
    }

    public void exibirMenuPrincipal() {
        Boolean sessaoAtiva = true;

        while (sessaoAtiva) {
            System.out.println("\n------- MENU PRINCIPAL -------");
            System.out.println("[ 1 ] Consultar Saldo");
            System.out.println("[ 2 ] Fazer Deposito");
            System.out.println("[ 3 ] Fazer Saque");
            System.out.println("[ 4 ] Historico de Movimentacoes");
            System.out.println("[ 5 ] Sair");
            System.out.println("------------------------------");
            System.out.print("Escolha uma opcao: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    exibirSaldo();
                    pausarTela();
                    break;
                case "2":
                    realizarDeposito();
                    pausarTela();
                    break;
                case "3":
                    realizarSaque();
                    pausarTela();
                    break;
                case "4":
                    exibirMovimentacoes();
                    pausarTela();
                    break;
                case "5":
                    System.out.println("Sessao encerrada. Obrigado por utilizar o FIAP Bank!");
                    sessaoAtiva = false;
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor, tente novamente.");
                    pausarTela();
            }
        }
    }

    public void exibirSaldo() {
        Dinheiro saldo = contaService.obterSaldo();
        System.out.println("\n>> Saldo atual: R$ " + saldo.getValor());
    }

    public void realizarDeposito() {
        try {
            System.out.print("\nDigite o valor do deposito: R$ ");
            String valorString = scanner.nextLine();
            Dinheiro valor = new Dinheiro(new BigDecimal(valorString));

            contaService.realizarDeposito(valor);
            System.out.println(">> Deposito realizado com sucesso!");
        } catch (Exception e) {
            System.out.println(">> Erro na operacao: " + e.getMessage());
        }
    }

    public void realizarSaque() {
        try {
            System.out.print("\nDigite o valor do saque: R$ ");
            String valorString = scanner.nextLine();
            Dinheiro valor = new Dinheiro(new BigDecimal(valorString));

            contaService.realizarSaque(valor);
            System.out.println(">> Saque realizado com sucesso!");
        } catch (Exception e) {
            System.out.println(">> Erro na operacao: " + e.getMessage());
        }
    }

    public void exibirMovimentacoes() {
        System.out.println("\n=== HISTORICO DE MOVIMENTACOES ===");
        List<Movimentacao> historico = contaService.obterMovimentacoes();

        if (historico.isEmpty()) {
            System.out.println(">> Nenhuma movimentacao registrada.");
            return;
        }

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        for (Movimentacao mov : historico) {
            String dataFormatada = mov.getDataHora().format(formatador);
            System.out.println(dataFormatada + " | " + mov.getTipo() + " | R$ " + mov.getValor().getValor());
        }
    }

    private void pausarTela() {
        System.out.print("\nPressione [ENTER] para continuar...");
        scanner.nextLine();
    }
}