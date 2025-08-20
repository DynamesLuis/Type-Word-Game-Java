
public class WordGenerator {
    String[] wordsAvailable = {"java", "javascript", "springboot", "programming", ""};
    Word[] currentWords;
    int ySpeed = 1;
    int yPosition = 0;

    public Word generateWord() {
       String randomWord = wordsAvailable[(int)(Math.random() * wordsAvailable.length)];
       return new Word(randomWord, generateX(), yPosition, ySpeed);
   }

    public int generateX() {
        return (int)(Math.random() * GameWindow.widthWindow );
    }

}
