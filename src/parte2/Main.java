package parte2;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArvoreBinPalavra arvore = new ArvoreBinPalavra();
        final File pasta = new File("C:/Users/lucas/Desktop/teste"); // Caminho do arquivo


        for (final File arquivo : pasta.listFiles()) {
            // Para cada arquivo dentro da pasta informada
            Scanner input = new Scanner(arquivo);

            while (input.hasNext()) {
                String palavra = input.next();
                arvore.inserePalavra(palavra);
            }
        }

        arvore.imprimeInOrdem(arvore.raiz);



    }
}
