import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CellButton extends JButton {

    private Boolean isBomb;
    private Boolean select;
    private int x;
    private int y;

    public CellButton(ActionListener actionListner,int x,int y) {
        super();
        this.x = x;
        this.y= y;
        addActionListener(actionListner);

        initButton();
    }

    private void initButton(){
        isBomb = false;
        select = false;
        setVisible(true);
        setText("0");
        repaint();
    }

    public Boolean getBomb() {
        return isBomb;
    }

    public void setBomb(Boolean bomb) {
        isBomb = bomb;
    }

    public Boolean getSelect() {
        return select;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Point> getNearCell(){
        List<Point> listPoint = new ArrayList<>();
        for (int i = x-1; i < x+2; i++) {
            for (int j = y-1; j < y+2; j++) {
                    if(i<0 || j <0 )
                        continue;

                    listPoint.add(new Point(i,j));
            }
        }
        return listPoint;
    }

    public void modify(String number){
        if (isBomb) {
            setText("");
            setBackground(Color.RED);
        } else {
            setText(number);
            setBackground(Color.CYAN);
        }
    }

    public void setSelect(Boolean selected){
        this.select = selected;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
