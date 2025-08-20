import javax.swing.*;
import java.awt.*;

public class Word {
    JLabel label;
    String name;
    int x;
    int y;
    int ySpeed;
    boolean isCorrectlyTyped = false;

    public Word(String name, int x, int y, int ySpeed) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.ySpeed = ySpeed;
    }

    public JLabel getLabel() {
        return this.label;
    }

    public void move() {
       y += ySpeed;
       //label.setLocation(150, y);
    }

    public void checkIsEqual(String wordTyped) {
        if (!isCorrectlyTyped) {
            if (wordTyped.equals(name)) {
                System.out.println("equals");
                isCorrectlyTyped = true;
            }
        }
    }

    public void draw(Graphics g) {
        if (!isCorrectlyTyped) {
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.setColor(Color.BLUE);
            g.drawString(name, x, y);
        }
    }

    public boolean checkIfGone() {
        if (y > GameWindow.heightWindow) System.out.println("it's gone");
        return y > GameWindow.heightWindow;
    }

}
