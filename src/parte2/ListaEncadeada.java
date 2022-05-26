package parte2;

public class ListaEncadeada {
    public NoENC primeiro;
    public NoENC ultimo;

    public void addNo(int data) {
        NoENC novoNo = new NoENC(data);
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            ultimo.proximo = novoNo;
        }
        ultimo = novoNo;
    }
}
