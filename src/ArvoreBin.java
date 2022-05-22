public class ArvoreBin {
    public NoAbin raiz;

    public ArvoreBin(){
        this.raiz = null;
    }

    public void insere(int valor) {
        NoAbin novo = new NoAbin(valor);
        // Se a raiz for nula, o novo elemento vira a raiz
        if (this.raiz == null) {
            this.raiz = novo;
        } else {
            NoAbin p = this.raiz;
            NoAbin q = null;
            // Enquanto p for diferente de nulo, inserir na direita ou na esquerda
            while (p != null) {
                q = p;
                if (valor < p.info) {
                    p = p.esquerda;
                } else {
                    p = p.direita;
                }
            }
        }
    }

    public void inOrdem(NoAbin raiz) {
        if (raiz != null) {
            inOrdem(raiz.esquerda);
            System.out.println(raiz.info);
            inOrdem(raiz.direita);
        }
    }
    public void preOrdem(NoAbin raiz){
        if (raiz != null){
            System.out.println(raiz.info);
            preOrdem(raiz.esquerda);
            preOrdem(raiz.direita);
        }
    }

    public void posOrdem(NoAbin raiz){
        if (raiz != null){
            posOrdem(raiz.esquerda);
            posOrdem(raiz.direita);
            System.out.println(raiz.info);
        }
    }

    public NoAbin busca(int valor) {
        NoAbin p = this.raiz;

        while (p != null && p.info != valor) {
            if (valor < p.info) {
                p = p.esquerda;
            } else {
                p = p.direita;
            }
        }
        return p;
    }

}
