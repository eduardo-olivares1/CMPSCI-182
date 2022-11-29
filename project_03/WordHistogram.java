import java.util.Scanner;
import java.util.LinkedList;
import java.io.*;

public class WordHistogram {
    public static void main(String[] args) {
        LinkedList<Word> list = new LinkedList<Word>();

        String filename = args[0];
        File file = new File(filename);
        try {
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String word = input.next();
                word = word.replace(".", "");
                word = word.replace("?", "");
                word = word.replace(",", "");
                word = word.toLowerCase();

                Word currentWord = new Word(word, 1);

                int wordIndex = 0;
                boolean containsWord = false;

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(word)) {
                        containsWord = true;
                        wordIndex = i;
                        break;
                    }
                }

                if (containsWord) {
                    list.get(wordIndex).setCount(list.get(wordIndex).getCount() + 1);
                } else {
                    list.add(currentWord);
                }

            }

            list.sort(Word::compareTo);

            System.out.print("[");
            for (int i = 0; i < list.size(); i++) {
                if (i == (list.size() - 1)) {
                    System.out.print(list.get(i).toString() + "");
                } else {
                    System.out.print(list.get(i).toString() + ", ");
                }
            }
            System.out.println("]");

            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }

}
