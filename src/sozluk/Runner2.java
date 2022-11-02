package sozluk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner2 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "resources/txt/sozluk.txt";
        File file = new File(path);
        Scanner scan = new Scanner(file);
        System.out.println("Kelimeler yükleniyor...");
        Trie2 trie = new Trie2();
        while (scan.hasNextLine()) {
            trie.insert(scan.nextLine());
        }

        System.out.println(trie.search("ZOOTIEST"));
        System.out.println(trie.search("zOOTIEST"));
    }
}
