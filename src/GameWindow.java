import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static int widthWindow = 600;
    static int heightWindow = 700;

    public GameWindow() {
        JPanel mainPanel = new JPanel();
        JPanel gamePanel = new GamePanel();
        JPanel footerPanel = new FooterPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gamePanel, BorderLayout.NORTH);
        mainPanel.add(footerPanel, BorderLayout.CENTER);

        this.add(mainPanel);
        this.setTitle("Type Game!");
        this.setSize(widthWindow, heightWindow);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
