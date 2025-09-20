# Simulador de lacunas na memoria principal (Sistemas Operacionais)

## Requisitos

* Memoria
    * Espacos
        * Linked List
        * Processo que vai ser executado (Sua lacuna)
    * Limite
    * Instancia de um Algorithm

* Gerador de Processo
    * Funcionalidade
        * Criar varios processos

* Processo
    * Id
    * Quantidade de instrucoes -> Tamanho processo

* Interface -> Algorithm
    * Adicionar um processo
    * Remover um processo (caso ele va ser processado)
    * Ordenacao
    * Partir a lacunas que está dentro da memória

* Implementation (Algorithm)
    * First Fit
        * Pecorrer toda a lista até encontrar a lacuna necessária para guardar o processo
    * Next Fit
        * Mesma implementação do First fit, porem ele guarda o momento onde ele parou, para a partir daí ser o 'início' da lista.
    * Best Fit
        * Ele vai buscar o tamanho mímino para guardar o processo (foca em efeciência).
    * Worst Fit
        * Esse algoritimo irá buscar a maior lacuna disponível para guardar o processo.

### O que acontece dentro da memoria

Dentro da memoria -> Linked List.

-> Algorithm nao tera forma de armazenamento <-
```
Algorithm(
    paramentro: uma copia da linked list -> linkedlist da instancia
)
```

Dentro do **Java** podemos pegar a mesma referencia da instancia e trabalhar com uma mesma referencia em dois lugares simultaneamente.

```java
class Memoria {
    private LinkedList espaco;
    private Algorithm algorithm;

    public Memoria{
        espaco = new LinkedList<Processo>(); // (Referencia)
        algorithm = new Algorithm(espaco);
    }

    public void adicionarProcessos(array: Processo[]) {}
    public void execute() {}
    private void tirarProcessoAleatoriamente(){}
    private void ordenarEspaco() {}
}
```

### Como a linked list deve trabalhar

A LinkedList terá que possuir esses dados:
* Se está ocupada por um processo
* Incio da lacuna
* Fim da lacuna

-> Criar uma classe que determinará as LACUNAS

A forma de partir as lacunas será a mesma para todos os algoritmos

A forma detectar as lacunas será diferente para cada algoritmo.

