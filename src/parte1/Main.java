package parte1;

public class Main {
    public static void main(String[] args) {
        ArvoreBin arvore = new ArvoreBin();

        arvore.insereElemento(5);
        arvore.insereElemento(20);
        arvore.insereElemento(10);
        arvore.insereElemento(40);
        arvore.insereElemento(30);
        arvore.insereElemento(50);

        //System.out.println(arvore.existeElemento(20));
        arvore.imprimeInOrdem(arvore.raiz);
        arvore.removeElemento(arvore.raiz, 30);
        arvore.imprimeInOrdem(arvore.raiz);

        //System.out.println(arvore.altura(arvore.raiz));
    }
}
