import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FooterPanel extends JPanel {
    Color backgroundColor = Color.white;
    static int points;
    static JLabel typedWord = new JLabel("", SwingConstants.CENTER);
    static JLabel score = new JLabel("Score: 0");

    public FooterPanel() {
        typedWord = new JLabel("", SwingConstants.CENTER);
        score = new JLabel("Score: 0");
        typedWord.setFont(new Font("Arial", Font.BOLD, 22));
        score.setFont(new Font("Arial", Font.BOLD, 16));
        score.setBorder(new EmptyBorder(0, 0, 0, 10));

        this.setLayout(new BorderLayout());
        this.setBackground(backgroundColor);
        this.add(typedWord, BorderLayout.CENTER);
        this.add(score, BorderLayout.EAST);
    }

    static public void updateScore() {
        points ++;
        score.setText("Score: " + points);
    }

    static public void updateInput() {
        typedWord.setText(GamePanel.currentWordTyped);
    }
}
