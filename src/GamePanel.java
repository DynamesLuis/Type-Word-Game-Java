import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Color backgroundColor = Color.black;

    public GamePanel() {
        this.setPreferredSize(new Dimension(GameWindow.widthWindow, 600));
        this.setBackground(backgroundColor);
    }
}
