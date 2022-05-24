package parte1;

public class ArvoreBin {
    public NoAVL raiz;

    public ArvoreBin(){
        this.raiz = null;
    }

    public void insereElemento(int valor) {
        NoAVL novo = new NoAVL(valor);
        // Se a raiz for nula, o novo elemento vira a raiz
        if (this.raiz == null) {
            this.raiz = novo;
        } else {
            NoAVL p = this.raiz;
            NoAVL q = null;
            // Enquanto p for diferente de nulo, inserir na direita ou na esquerda
            while (p != null) {
                q = p;
                if (valor < p.info) {
                    p = p.esquerda;
                } else {
                    p = p.direita;
                }
            }
            if (valor < q.info) {
                q.esquerda = novo;
            } else {
                q.direita = novo;
            }

        }
    }

    public NoAVL removeElemento(NoAVL raiz, int elemento){
        // Se for nula e fim da recursiva
        if(raiz == null){
            return raiz;
        }
        // Seguir pelo lado esquerdo da subarvore até o elemento ser menor que o valor do nó
        else if(raiz.info > elemento){
            raiz.esquerda = removeElemento(raiz.esquerda, elemento);
        }
        // Seguir pelo lado esquerdo da subarvore até o elemento ser maior que o valor do nó
        else if(raiz.info < elemento){
            raiz.direita = removeElemento(raiz.direita, elemento);
        }
        else{
            /*Três casos a serem lidados: Elemento com nenhuma sub-arvore,
            apenas uma sub-arvore ou duas sub-arvores*/

            // Lidando com a situação caso o elemento tenha uma ou nenhuma sub-arvore
            if(raiz.esquerda == null){
                return raiz.direita;
            }
            else if(raiz.direita == null){
                return raiz.esquerda;
            }

            /* Lidando com a situação caso o elemento tenha duas sub-arvores
            Encontrar o mínimo elemento seguindo a sub-arvore da direita e aplicar
            o método removeElemento() novamente */
            raiz.info = encontraMinimo(raiz.direita);

            raiz.direita= removeElemento(raiz.direita, raiz.info);
        }
        return raiz;
    }

    private int encontraMinimo(NoAVL no){
        // Assumindo o minimo como o valor informado
        int minimo = no.info;

        while(no.esquerda != null){
            minimo = no.esquerda.info;
            no = no.esquerda;
        }
        return minimo;
    }

    public NoAVL existeElemento(int elemento) {
        NoAVL p = this.raiz;

        while (p != null && p.info != elemento) {
            if (elemento < p.info) {
                p = p.esquerda;
            } else {
                p = p.direita;
            }
        }
        return p;
    }

    public int altura(NoAVL raiz) {
        if (raiz == null) {
            return 0;
        } else {
            int alturaEsquerda = altura(raiz.esquerda);
            int alturaDireita = altura(raiz.direita);

            return Math.max(alturaDireita, alturaEsquerda) + 1;
        }
    }

    public void imprimeInOrdem(NoAVL raiz) {
        if (raiz != null) {
            imprimeInOrdem(raiz.esquerda);
            System.out.println(raiz.info);
            imprimeInOrdem(raiz.direita);
        }
    }
    public void imprimePreOrdem(NoAVL raiz){
        if (raiz != null){
            System.out.println(raiz.info);
            imprimePreOrdem(raiz.esquerda);
            imprimePreOrdem(raiz.direita);
        }
    }

    public void imprimePosOrdem(NoAVL raiz){
        if (raiz != null){
            imprimePosOrdem(raiz.esquerda);
            imprimePosOrdem(raiz.direita);
            System.out.println(raiz.info);
        }
    }

    public int balanceamento(NoAVL raiz){
       return altura(raiz.direita) - altura(raiz.esquerda);
    }

    public NoAVL pai(NoAVL no){
        NoAVL noAtual = this.raiz;
        if (no == this.raiz){
            return raiz;
        }
        while(noAtual != null){
            if (no == noAtual.esquerda || no == noAtual.direita){
                break;
            }
            else if (no.info < noAtual.info){
                noAtual = noAtual.esquerda;
            }
            else{
                noAtual = noAtual.direita;
            }
        }
        return noAtual;
    }

    private void rotacaoEsquerda(NoAVL no){
        NoAVL raiz = pai(no);
        NoAVL p = no.direita;

        if (no == this.raiz){
            this.raiz = p;
        }
        else if (raiz.info <= p.info){
            raiz.direita = p;
        }
        else{
            raiz.esquerda = p;
        }
        no.direita = p.esquerda;
        p.esquerda = no;
    }

    private void rotacaoDireita(NoAVL no){
        NoAVL raiz = pai(no);
        NoAVL p = no.esquerda;

        if (no == this.raiz){
            this.raiz = p;
        }
        else if (raiz.info <= p.info){
            raiz.direita = p;
        }
        else{
            raiz.esquerda = p;
        }
        no.esquerda = p.direita;
        p.direita = no;
    }
}
