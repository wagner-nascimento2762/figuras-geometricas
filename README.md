# Geometry Linked List System (Java Maven)

Trabalho académico desenvolvido em Java para a unidade curricular de **Estruturas de Dados**. O projeto implementa um sistema de formas geométricas restrito a três tipos: Triângulos, Retângulos e Círculos, utilizando listas ligadas manuais e o padrão de projeto *Strategy Pattern*.

---

## Arquitetura e Principais Objetos

1. **`Node`**: Representa um vértice ou ponto da estrutura. Contém um identificador (`id`), coordenadas (`x`, `y`), e referências bidirecionais (`previous` e `next`).
2. **`Connection`**: Representa uma ligação direcionada entre dois objetos `Node`. Quando instanciada (`N1 -> N2`), atualiza automaticamente `N1.next = N2` e `N2.previous = N1`.
3. **`Shape`**: Representa a forma geométrica centralizada através de um `ShapeType` enum (`TRIANGLE`, `RECTANGLE`, `CIRCLE`), contendo listas ligadas manuais de nós e ligações, além do raio (`radius`) para círculos. Não existem subclasses de domínio separadas (`Triangle`, `Rectangle`, `Circle`).

---

## Conceitos Chave Implementados

- **Lista Ligada vs. Referências `previous`/`next`**: 
  - As **listas ligadas manuais** (`LinkedNodeList` e `LinkedConnectionList`) gerem a coleção de elementos contidos na forma através de nós internos (`Entry`).
  - As referências `previous` e `next` residem dentro de cada `Node` individual, permitindo a navegação topológica direta entre os vértices das formas geométricas.
- **Navegação (`current`, `previous`, `next`)**: A travessia simula ciclos fechados em polígonos, parando ao completar o número exato de nós para evitar loops infinitos.
- **Valores `null`**: Utilizados quando não existe um nó anterior ou seguinte (como no nó central de um círculo, onde `C.previous` e `C.next` são `null`).
- **Representação do Círculo**: Um círculo não possui vértices poligonais convencionais. É representado por um único nó de referência central `C`, raio guardado no `Shape`, referências `null` e uma lista de ligações vazia.
- **Strategy Pattern**: A interface `ShapeCreationStrategy` possui implementações específicas (`TriangleCreationStrategy`, `RectangleCreationStrategy`, `CircleCreationStrategy`), coordenadas pela `ShapeFactory`.
- **Validação de Tipos**: Qualquer valor inválido ou diferente de `TRIANGLE`, `RECTANGLE` ou `CIRCLE` enviado à fábrica resulta numa exceção `IllegalArgumentException`.

---

## Como Compilar e Executar com Maven

Certifique-se de ter o **Java 17+** e o **Maven** instalados.

1. **Compilar o projeto:**
   ```bash
   mvn clean compile