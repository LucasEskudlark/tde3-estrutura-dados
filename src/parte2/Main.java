package parte2;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        final File pasta = new File("C:/Users/lucas/Desktop/teste"); // Caminho do arquivo
        Reader reader = new Reader(pasta);


        reader.insereArvore(); // Insere os elementos do arquivo na arvore
        reader.imprimeArvore(); // Imprime a arvore em ordem alfabetica
        reader.encontraPalavra(); // Solicita uma palavra e mostra a quantidade de vezes repetida

    }


}
