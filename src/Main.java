public class Main {
    public static void main(String[] args) {
        ArvoreBin arvore = new ArvoreBin();

        arvore.insere(5);
        arvore.insere(10);
        arvore.insere(20);
        arvore.insere(30);
        arvore.insere(40);
        arvore.insere(50);

        System.out.println(arvore.busca(20));
    }
}
