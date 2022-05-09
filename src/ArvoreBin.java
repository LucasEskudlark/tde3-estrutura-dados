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

}
