import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    Color backgroundColor = Color.black;
    static String currentWordTyped = "";
    Timer timer;
    boolean isRunning = false;
    boolean gameStarted = false;
    WordGenerator wordGenerator;
    ArrayList<Word> words = new ArrayList<>();

    public GamePanel() {
        this.setPreferredSize(new Dimension(GameWindow.widthWindow, 600));
        this.setBackground(backgroundColor);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        this.wordGenerator = new WordGenerator();
    }

    public void startGame() {
        timer = new Timer(10, this);
        timer.start();
        isRunning = true;
        gameStarted = true;
        System.out.println("game running");
        Word newWord = wordGenerator.generateWord();
        words.add(newWord);
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (GameWindow.widthWindow - metrics2.stringWidth("Game Over"))/2, GameWindow.heightWindow/2);
    }

    public void resetWord() {
        currentWordTyped = "";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isRunning) {
            for (Word word: words) {
                word.draw(g);
            }
        } else if (!isRunning && gameStarted){
            gameOver(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isRunning) {
            for (Word word: words) {
                word.move();
                word.checkIsEqual(currentWordTyped);
                boolean isGone = word.checkIfGone();
                if (isGone) isRunning = false;
            }
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                startGame();
            } else {
                currentWordTyped += e.getKeyChar();
                System.out.println(currentWordTyped);
            }
        }
    }
}
