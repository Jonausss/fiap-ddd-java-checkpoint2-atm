# FIAP Bank ATM - Versão Beta

Este projeto é a evolução (Versão Beta) do simulador de Caixa Eletrônico (ATM) do FIAP Bank. O sistema foi completamente refatorado para abandonar o paradigma procedural e adotar os pilares da Orientação a Objetos e do *Domain-Driven Design* (DDD).

## 🚀 O Projeto

O objetivo principal desta versão é garantir um código limpo, robusto e estruturado. As operações bancárias básicas foram mantidas, mas agora o sistema exige autenticação de segurança e registra um histórico detalhado de todas as movimentações financeiras.

### Funcionalidades (Menu Principal)
- **[ 1 ] Consultar Saldo:** Exibição do saldo atual da conta.
- **[ 2 ] Fazer Depósito:** Adição de valores ao saldo com registro de operação.
- **[ 3 ] Fazer Saque:** Retirada de valores com aplicação de regras específicas por tipo de conta.
- **[ 4 ] Histórico de Movimentações:** Listagem completa de operações detalhando Data/Hora, Tipo (Saque, Depósito, Taxa, Rendimento) e Valor.
- **[ 5 ] Sair:** Encerra a sessão de forma segura.

## 🏗️ Arquitetura e Padrões de Projeto

O sistema foi dividido estritamente em quatro camadas profissionais, abolindo o uso do *Default Package*:

1. **Presentation:** Interface com o usuário (`TerminalBancarioController`), responsável pelos fluxos de entrada/saída via Console.
2. **Application:** Camada de orquestração (`ContaService`, `AutorizacaoService`, `ContaFactory` e `Main`), responsável por interligar os dados sem vazar regras de negócio.
3. **Model:** O coração do sistema. Contém as Entidades (`Cliente`, `Movimentacao`), a superclasse `Conta` e as subclasses `ContaCorrente` e `ContaPoupanca`, além dos *Value Objects* (`Dinheiro`, `ContaAcesso`).
4. **Infrastructure:** Simulação de armazenamento externo de dados em memória (`ContaRepository`).

### Padrões Aplicados
- **Template Method:** Implementado na superclasse `Conta` para ditar o algoritmo padrão de saque, delegando a cobrança de taxas/rendimentos para as subclasses.
- **Singleton:** Utilizado na `ContaFactory` para garantir uma única instância do criador de contas.
- **Factory:** Utilizado para a criação polimórfica das contas.

## ⚠️ Restrições e Regras de Negócio
- **Adeus Tipos Primitivos:** O projeto **não** utiliza primitivos como `int`, `double` ou `boolean`. Todos os valores numéricos e lógicos utilizam Classes Wrapper ou `BigDecimal` através do *Value Object* `Dinheiro`.
- **Segurança:** O sistema bloqueia a conta após 3 tentativas inválidas de senha.
- **Encapsulamento:** As entidades protegem seu estado. Nenhuma regra lógica ou cálculo financeiro existe fora da camada `Model`.

## 💻 Como Executar

1. Certifique-se de ter o **Java 17** instalado em sua máquina.
2. Clone este repositório
3. Abra o projeto na sua IDE de preferência (ex: IntelliJ IDEA, Eclipse).
4. Navegue até a classe Main.java localizada no pacote br.fiap.bank.atm.application
5. Execute o método main.
6. No terminal, utilize a senha inicial 1234 para acessar o sistema.

## 👨‍🎓 Autoria
Desenvolvido por:

JOÃO PEDRO RAIMUNDO MARCILO - RM: 561603

Engenharia de Software - FIAP
