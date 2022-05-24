package parte2;

public class NoAVL {
    public NoAVL esquerda; // Ponteiro pra esquerda
    public NoAVL direita; // Ponteiro pra direita
    public String palavra; // Palavra
    public int contador;

    // Construtor recebendo a palavra
    public NoAVL(String palavra) {
        this.palavra = palavra;
        this.direita = null;
        this.esquerda = null;
        this.contador = 1;
    }
}
