import java.util.ArrayList;

public class WordGenerator {
    String[] wordsAvailable = {"java", "javascript", "springboot", "programming", "variable",
            "inheritance", "interface", "framework", "fullstack", "frontend", "backend", "github",
            "testing"};
    static ArrayList<Word> currentWords = new ArrayList<>();
    int ySpeed = 1;
    int yPosition = 0;

    public Word generateWord() {
       String randomWord = wordsAvailable[(int)(Math.random() * wordsAvailable.length)];
       return new Word(randomWord, generateX(), yPosition, ySpeed);
   }

    public int generateX() {
        return (int)(Math.random() * (GameWindow.widthWindow - 150) );
    }

    public void addWord(Word newWord) {
        currentWords.add(newWord);
    }

    public void deleteWord(Word newWord) {
        currentWords.remove(newWord);
    }

}
