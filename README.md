# A3 - Estrutura de Dados e Análise de Algoritmos

## Integrante(s)

* Rian Pereira Gomes

## Descrição do Projeto

Este projeto foi desenvolvido para a atividade A3 da disciplina **Estrutura de Dados e Análise de Algoritmos**.

O sistema representa um conjunto de creches de uma cidade utilizando a estrutura de **Grafos**, permitindo realizar consultas sobre conexões e distâncias entre as creches, simulando um cenário de distribuição de merenda escolar.

---

## Objetivo

Implementar uma solução utilizando Estruturas de Dados que permita:

* Ler os dados do grafo a partir de um arquivo `.txt`;
* Informar o número de conexões de cada creche;
* Listar as creches conectadas a uma determinada creche em ordem crescente de distância;
* Informar a distância entre duas creches;
* Incluir novas conexões entre creches.

---

## Estruturas Utilizadas

### Matriz de Adjacência

A matriz de adjacência é utilizada para armazenar as conexões entre as creches.

* Valor **1** → Existe conexão.
* Valor **0** → Não existe conexão.

Exemplo:

|   | A | B | C |
| - | - | - | - |
| A | 0 | 1 | 1 |
| B | 1 | 0 | 0 |
| C | 1 | 0 | 0 |

---

### Lista Simplesmente Encadeada

A lista encadeada é utilizada para armazenar:

* Nome da creche conectada;
* Distância da conexão.

Cada nó da lista possui:

```java
String creche;
double distancia;
No proximo;
```

---

## Estrutura do Projeto

```text
A3_EDAA
│
├── src
├── dados
├── docs
├── README.md
└── .gitignore
```

---

## Arquivo de Entrada

O arquivo `dados.txt` contém as conexões do grafo.

Exemplo:

```txt
JoanaTimoteo;AmaroCavalcante;2.9
JoanaTimoteo;AnaReinaldo;5.7
AmaroCavalcante;AnaReinaldo;5.7
AnaReinaldo;JoaoGama;13.6
```

Formato:

```txt
CrecheOrigem;CrecheDestino;Distancia
```

---

## Funcionalidades Implementadas

### 1. Leitura do Arquivo

O sistema realiza a leitura automática do arquivo `dados.txt` e cria o grafo em memória.

---

### 2. Quantidade de Conexões

Exibe o número de conexões de cada creche.

Exemplo:

```text
JoaoGama -> 4 conexões
PedroFernandes -> 3 conexões
```

---

### 3. Listagem de Conexões

Lista todas as conexões de uma creche em ordem crescente de distância.

Exemplo:

```text
PorfiroGabrielDosAnjos - 7.6 km
PedroFernandes - 11.4 km
AnaReinaldo - 13.6 km
```

---

### 4. Consulta de Distância

Permite verificar a distância entre duas creches conectadas.

Exemplo:

```text
Distância entre PedroFernandes e HerculanoDeMelo: 14.5 km
```

---

### 5. Inclusão de Nova Conexão

Permite inserir novas conexões durante a execução do programa.

Exemplo:

```java
grafo.adicionarConexao(
    "JoseVicente",
    "PedroFernandes",
    8.0
);
```

---

## Como Executar

### Compilar

```bash
javac *.java
```

### Executar

```bash
java Main
```

---

## Conceitos Aplicados

* Grafos
* Vértices e Arestas
* Grafos Ponderados
* Matriz de Adjacência
* Lista Simplesmente Encadeada
* Leitura de Arquivos
* Manipulação de Estruturas de Dados

---

## Conclusão

O projeto demonstra a aplicação prática dos conceitos estudados na disciplina de Estrutura de Dados e Análise de Algoritmos, utilizando grafos para representar conexões entre creches e possibilitando consultas importantes para um cenário de distribuição de merenda escolar.

Todos os requisitos propostos no enunciado foram implementados utilizando matriz de adjacência estática e lista simplesmente encadeada.
