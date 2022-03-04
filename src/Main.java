import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        GameBoard comp = new GameBoard();
        jFrame.add(comp);
        jFrame.setSize(500,500);
        jFrame.invalidate();
        jFrame.repaint();

    }
}
