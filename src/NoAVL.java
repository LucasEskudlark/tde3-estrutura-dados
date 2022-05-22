public class NoAVL {
    public NoAVL esquerda;
    public NoAVL direita;
    public int info;

    public NoAVL(int valor) {
        this.info = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
