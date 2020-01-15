import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;

public class Cell extends JButton{
    private int height = 50;
    private int width = height;
    private boolean isMine = false;
    private ImageIcon cellIcon;
    private int bombsNear = 0;
    private int rowID;
    private int colID;

    public Cell(){
        super();

        cellIcon = new ImageIcon(getClass().getResource("default.png"));
        this.setPreferredSize(new Dimension(height, width));
        this.setIcon(cellIcon);
    }

    void setCellIcon(ImageIcon newCellIcon){
        this.setIcon(newCellIcon);
    }

    boolean getMine(){
        return this.isMine;
    }

    void setMine(boolean mineSetting){
        this.isMine = mineSetting;
    }

    int getBombsNear(){
        return this.bombsNear;
    }

    void addBombNear(){
        this.bombsNear = this.bombsNear+1;
    }

    int getRowID(){
        return this.rowID;
    }

    int getColID(){
        return this.colID;
    }

    void setRowID(int id){
        this.rowID = id;
    }

    void setColID(int id){
        this.colID = id;
    }
}
