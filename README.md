# Reflore$ta 🌱

## Sobre o Projeto

**Reflore$ta** é um projeto educacional em Java que simula um sistema de investimento sustentável. Os usuários podem se cadastrar, realizar investimentos e receber "cotas" que simbolizam árvores plantadas. Como incentivo, cada investimento dá direito a um brinde ecológico aleatório.

Este sistema serve como um **mockup de uma empresa fictícia chamada Reflore$ta**, cujo objetivo é promover a preservação ambiental através de investimentos simbólicos em reflorestamento.

Ao final do uso do programa, os dados dos clientes são salvos e exibidos de forma organizada.

---

## Funcionalidades

- Cadastro de novos usuários
- Login com verificação de ID e senha
- Simulação de investimentos em árvores
- Geração de cotas proporcionais ao valor investido
- Sorteio de brindes ecológicos
- Registro das ações dos usuários em um arquivo de texto (`clientes.txt`)
- Exibição final de todos os cadastros

---

## Tecnologias Utilizadas

- **Java (JDK 8+)**: Linguagem principal do projeto
- **Scanner**: Para entrada de dados via terminal e leitura de arquivos
- **Formatter**: Para escrita de dados estruturados em arquivo de texto
- **Tratamento de exceções**: Para garantir segurança na manipulação de arquivos

---

## Estrutura de Arquivo

- `Main.java`: Contém toda a lógica de execução do programa
- `clientes.txt`: Arquivo gerado automaticamente contendo os dados dos usuários cadastrados e seus investimentos

---

## Como Executar

1. Compile o projeto:
   ```bash
   javac Main.java
