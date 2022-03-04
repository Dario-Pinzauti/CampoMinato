import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameBoard extends JPanel implements ActionListener {

    private Color bgColor;
    private int col = 10 ;
    private int row = 10;
    private int bombNumber = 10;
    CellButton[][] cellButtons ;


    public GameBoard() {
        super();
        setDoubleBuffered(true);
        updateUI();
        cellButtons = new CellButton[col][row];
        for (int i = 0; i <col; i++) {
            for (int j = 0; j <row; j++) {
                cellButtons[i][j] = new CellButton(this,i,j);
                add(cellButtons[i][j]);
            }
        }
        initGrid();
        setVisible(true);
        setBackground(Color.GREEN);
        setLayout(new GridLayout(col,row));
    }

    private void initGrid() {
        initializeBombs();
    }


    /**
     * inserite le bombe in maniera casuale nella griglia di gioco
     */
    private void initializeBombs() {
        for (int i = 0; i < bombNumber; i++) {
            int randomY;
            int randomX;
            do{
             randomY = (int) (Math.random() * row);
             randomX = (int) (Math.random() * col);
            }while (cellButtons[randomX][randomY].getBomb());

            CellButton componentAt =cellButtons[randomX][randomY];
            componentAt.setBomb(true);
        }
    }
    //
    private void verifyNearCell(CellButton source) {
        int countBombs = 0;
        for (Point nearPoint : source.getNearCell()) {
            if(nearPoint.x>=row || nearPoint.y >=col)
                continue;
            if( cellButtons[nearPoint.x][nearPoint.y].getBomb())
                countBombs++;
        }
        if(countBombs!= 0){
            source.setSelect(true);
            source.modify(countBombs+"");
        }else{
            source.setSelect(true);
            source.modify("");
            for (Point nearPoint : source.getNearCell()) {
                if(nearPoint.x>=row || nearPoint.y >=col)
                    continue;
                if(!cellButtons[nearPoint.x][nearPoint.y].getSelect())
               verifyNearCell(cellButtons[nearPoint.x][nearPoint.y]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CellButton source = (CellButton) e.getSource();
        if(source.getSelect())
        return;

        if(source.getBomb()){
            //fineeeeeee
            source.modify("");
        }
        verifyNearCell(source);
    }

    @Override
    public void repaint() {
        super.repaint();
    }
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
