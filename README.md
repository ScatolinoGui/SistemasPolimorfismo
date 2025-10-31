# Exercícios de POO - Polimorfismo

Este repositório contém dois projetos em Java desenvolvidos como exercícios para a aula de Programação Orientada a Objetos do Professor Marcelo Santos.

O objetivo principal desses exercícios é aplicar e demonstrar o conceito de **Polimorfismo**, um pilar fundamental da POO. Ambos os sistemas utilizam herança, classes abstratas e, principalmente, a sobrescrita de métodos (method overriding) para permitir que objetos de diferentes classes sejam tratados de maneira uniforme.

---

## 1. SistemaFolhaPagamento

Este projeto simula o cálculo da folha de pagamento de uma empresa, demonstrando como o polimorfismo pode lidar com regras de negócio complexas para diferentes tipos de funcionários.

### Conceitos Aplicados

- **Classe Abstrata**: `Funcionario` e `FuncionarioComissionado` definem contratos comuns, como os métodos abstratos `calcularSalarioTotal()` e `calcularBonus()`.

- **Herança**: As classes concretas herdam e estendem as funcionalidades.

- **Polimorfismo**: A classe principal `SistemaFolhaPagamento` utiliza um array de `Funcionario`. Ao iterar por este array, os métodos `calcularSalarioTotal()` e `calcularBonus()` são chamados. O Java, em tempo de execução, decide qual implementação específica do método deve ser executada com base no tipo real do objeto (se é Gerente, Diretor, Vendedor, etc.).

### Hierarquia das Classes

```
Funcionario (Abstrata)
├── Gerente
│   └── Diretor
└── FuncionarioComissionado (Abstrata)
    └── Vendedor
        └── VendedorSenior
```

### Como Executar

A classe principal é `SistemaFolhaPagamento.java`. Ao ser executada, ela irá:

1. Instanciar 6 funcionários de tipos diferentes (Diretor, Gerentes, Vendedores e Vendedor Sênior).
2. Processar cada funcionário, exibindo seu salário base, bônus, adicional por tempo de serviço e salário total.
3. Calcular e exibir o valor total da folha de pagamento.
4. Encontrar e exibir o funcionário com o maior salário.

---

## 2. SistemaBiblioteca

Este projeto simula o gerenciamento de itens em uma biblioteca, focando no cálculo de multas por atraso.

### Conceitos Aplicados

- **Classe Abstrata**: `ItemBiblioteca` define os atributos comuns (título, código) e os métodos abstratos `calcularMulta()` e `estaAtrasado()`.

- **Herança**: As classes `Livro` e `Revista` herdam de `ItemBiblioteca`.

- **Polimorfismo**: As classes `Livro` e `Revista` implementam `calcularMulta()` com regras de negócio completamente diferentes:
  - **Livro**: Atrasado após 7 dias, com taxa de R$ 2,00 ou R$ 3,00 (dependendo do nº de páginas).
  - **Revista**: Atrasada após 3 dias, com taxa fixa de R$ 1,00.

A classe `TesteBiblioteca` itera sobre um array de `ItemBiblioteca` e chama `item.calcularMulta()` em cada um, executando a versão correta do método para cada tipo de item.

### Hierarquia das Classes

```
ItemBiblioteca (Abstrata)
├── Livro
└── Revista
```

### Como Executar

A classe principal é `TesteBiblioteca.java`. Ao ser executada, ela irá:

1. Instanciar 5 itens (Livros e Revistas) com diferentes dias de empréstimo.
2. Processar cada item, exibindo suas informações, status (Atrasado/Em dia) e o valor da multa.
3. Calcular e exibir o valor total de todas as multas.
4. Exibir o total de itens atrasados.
5. Identificar e exibir qual item gerou a maior multa.

---

## Estrutura do Repositório

```
SistemasPolimorfismo/
├── SistemaBiblioteca/
│   ├── bin/
│   ├── lib/
│   └── src/
│       ├── ItemBiblioteca.java
│       ├── Livro.java
│       ├── Revista.java
│       └── TesteBiblioteca.java
├── SistemaFolhaPagamento/
│   ├── bin/
│   ├── lib/
│   └── src/
│       ├── Diretor.java
│       ├── Funcionario.java
│       ├── FuncionarioComissionado.java
│       ├── Gerente.java
│       ├── SistemaFolhaPagamento.java
│       ├── Vendedor.java
│       └── VendedorSenior.java
└── README.md
```

---

## Autor: Guilherme Scatolino

Desenvolvido como exercício pedagógico sob orientação do Professor Marcelo Santos.
