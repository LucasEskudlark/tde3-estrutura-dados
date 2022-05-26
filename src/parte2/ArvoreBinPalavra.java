package parte2;

public class ArvoreBinPalavra {
    public NoAVL raiz;

    public ArvoreBinPalavra() { this.raiz = null; }

    public void inserePalavra(String novaPalavra) {
        novaPalavra = novaPalavra.toLowerCase();

        if ( raiz == null ) {
            // A árvore está vazia.
            // A nova palavra se torna a raíz.
            raiz = new NoAVL(novaPalavra);
            return;
        }

        NoAVL atual; // Vai checar toda a árvore para encontrar um lugar para a nova palavra
        atual = raiz; // Começando pela raíz

        while (true) {
            if ( novaPalavra.equals(atual.palavra)) {
                // A palavra já está na árvore, apenas retorna
                atual.contador += 1;
                return;
            }
            if ( novaPalavra.compareTo(atual.palavra) < 0) {
                // Se a nova palavra for "menor" que o atual,
                // ela deve ser adicionada à sub-árvore da esquerda.
                // Se o ponteiro da esquerda estiver nulo, adiciona lá.
                // Caso contrário desce um nível para a esquerda
                if (atual.esquerda == null) {
                    atual.esquerda = new NoAVL(novaPalavra);
                    return; // Adicionou na esquerda
                } else {
                    atual = atual.esquerda;
                }
            }
            else {
                // Se a nova palavra for "maior" que o atual,
                // ela deve ser adicionada à sub-árvore da direita.
                // Se o ponteiro da direta estiver nulo, adiciona lá.
                // Caso contrário desce um nível para a direita.
                if ( atual.direita == null ) {
                    atual.direita = new NoAVL(novaPalavra);
                    return; // Adicionou na direita
                } else {
                    atual = atual.direita;
                }
            }
        } // Fim do while
    } // Fim do método


    public void imprimeInOrdem(NoAVL raiz) {
        if (raiz != null) {
            imprimeInOrdem(raiz.esquerda);
            System.out.println(raiz.palavra);
            imprimeInOrdem(raiz.direita);
        }
    }
} // Fim da classe

