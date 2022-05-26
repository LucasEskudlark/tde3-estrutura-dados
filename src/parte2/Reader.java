package parte2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private ArvoreBinPalavra arvore = new ArvoreBinPalavra();
    private File pasta;

    public Reader(File pasta) {
        this.pasta = pasta;
    }

    public void insereArvore() throws FileNotFoundException {
        // Método recebe um diretório, lê as palavras
        // e adiciona em uma árvore binária

        for (final File arquivo : pasta.listFiles()) {
            // Para cada arquivo dentro da pasta informada
            Scanner input = new Scanner(arquivo);
            String palavra;

            while (input.hasNext()) {
                palavra = input.next();
                arvore.inserePalavra(palavra);
                contaPalavra(palavra);
            }
        }


    } // Fim do método lerDiretorio

    public void contaPalavra(String palavra) throws FileNotFoundException {
        NoAVL p = arvore.raiz;

        while (p != null && !p.palavra.equals(palavra)) {
            if (palavra.compareTo(p.palavra) < 0) {
                p = p.esquerda;
            } else {
                p = p.direita;
            }
        }

        int counter = 0;
        for (final File arquivo : pasta.listFiles()) {
            // Para cada arquivo dentro da pasta informada
            Scanner input = new Scanner(arquivo);

            while (input.hasNext()) {
                if (input.next().equals(palavra)) {
                    counter += 1;
                }
            }

        }
        assert p != null;
        p.lista = new ListaEncadeada();
        p.lista.addNo(counter);
    } // Fim do método

    public void imprimeArvore() {
        System.out.println("Árvore em ordem alfabética: ");
        arvore.imprimeInOrdem(arvore.raiz);
    }

    public void encontraPalavra() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a palavra a ser encontrada: ");
        String palavra = sc.nextLine();

        NoAVL p = arvore.raiz;

        while (p != null && !p.palavra.equals(palavra)) {
            if (palavra.compareTo(p.palavra) < 0) {
                p = p.esquerda;
            } else {
                p = p.direita;
            }
        }

        System.out.println("Palavra: " + palavra);
        System.out.println("Quantidade: " + p.lista.primeiro.valor);

    }
}
