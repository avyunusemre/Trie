package sozluk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        String URI = "/Users/yunusemrekaya/IdeaProjects/sozluk/resources/txt/sozluk.txt";
        File file = new File(URI);
        Scanner scan = new Scanner(file);
        Trie trie = new Trie();
        System.out.println("Sözlük yükleniyor. Lütfen bekleyin...");
        while (scan.hasNextLine()) {
            String[] words = scan.nextLine().split(" ");
            for (String word : words) {
                System.out.println(word);
                trie.insert(word);
            }
        }
        System.out.println(trie.startsWith("zz"));
        System.out.println("Sözlük yüklendi.\nBir kelime yazip enter tusuna basiniz: ");
        Scanner scan2 = new Scanner(System.in);
        String word = scan2.next();
    }
}