import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Board extends JPanel{
    private int totalRows;
    private int totalCols;
    private int mineCount;
    private int totalCellsClicked = 0;
    private Cell cells[][];

    public Board(int targetRows, int targetCols, int targetMineCount){
        super();

        totalRows = targetRows;
        totalCols = targetCols;
        cells = new Cell[totalRows][totalCols];
        mineCount = targetMineCount;

        this.setLayout(new GridLayout(totalRows, totalCols));

        for(int currentRow = 0; currentRow < totalRows; currentRow++){
            for(int currentCol = 0; currentCol < totalCols; currentCol++){
                cells[currentRow][currentCol] = new Cell();
                cells[currentRow][currentCol].setRowID(currentRow);
                cells[currentRow][currentCol].setColID(currentCol);
                this.add(cells[currentRow][currentCol]);
            }
        }

        int tempMineCount = 0;
        while(tempMineCount != targetMineCount){
            Random randRow = new Random();
            Random randCol = new Random();
            int targetRow = randRow.nextInt(totalRows);
            int targetCol = randCol.nextInt(totalCols);

            if(cells[targetRow][targetCol].getMine() == false){
                cells[targetRow][targetCol].setMine(true);

                cells[targetRow][targetCol].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        for(int currentRow = 0; currentRow < totalRows; currentRow++){
                            for(int currentCol = 0; currentCol < totalCols; currentCol++){
                                cells[currentRow][currentCol].setEnabled(false);
                                if(cells[currentRow][currentCol].getMine() == true){
                                    cells[currentRow][currentCol].setCellIcon(new ImageIcon(getClass().getResource("mine.png")));
                                }
                            }
                        }

                        JOptionPane.showMessageDialog(getRootPane(), "You lost!");
                    }
                });

                tempMineCount++;
            }
        }

        for(int currentRow = 0; currentRow < totalRows; currentRow++){
            for(int currentCol = 0; currentCol < totalCols; currentCol++){
                if(cells[currentRow][currentCol].getMine() == false){
                    if(currentRow == 0 && currentCol == 0){
                        if(cells[currentRow+1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else if(currentRow == 0 && currentCol == totalCols -1){
                        if(cells[currentRow+1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else if(currentRow == totalRows -1 && currentCol == 0){
                        if(cells[currentRow-1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else if(currentRow == totalRows -1 && currentCol == totalCols -1){
                        if(cells[currentRow-1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else if(currentRow == 0){
                        if(cells[currentRow][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else if(currentRow == totalRows -1){
                        if(cells[currentRow][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else if(currentCol == 0){
                        if(cells[currentRow-1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else if(currentCol == totalCols -1){
                        if(cells[currentRow-1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }
                    else{
                        if(cells[currentRow-1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol-1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow-1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                        if(cells[currentRow+1][currentCol+1].getMine() == true){
                            cells[currentRow][currentCol].addBombNear();
                        }
                    }

                    cells[currentRow][currentCol].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            Cell clickedCell = (Cell)actionEvent.getSource();
                            if(clickedCell.getBombsNear() == 0){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("clear.png")));
                                //clear(clickedCell.getRowID(), clickedCell.getColID());
                            }
                            else if(clickedCell.getBombsNear() == 1){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("one.png")));
                            }
                            else if(clickedCell.getBombsNear() == 2){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("two.png")));
                            }
                            else if(clickedCell.getBombsNear() == 3){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("three.png")));
                            }
                            else if(clickedCell.getBombsNear() == 4){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("four.png")));
                            }
                            else if(clickedCell.getBombsNear() == 5){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("five.png")));
                            }
                            else if(clickedCell.getBombsNear() == 6){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("six.png")));
                            }
                            else if(clickedCell.getBombsNear() == 7){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("seven.png")));
                            }
                            else if(clickedCell.getBombsNear() == 8){
                                clickedCell.setCellIcon(new ImageIcon(getClass().getResource("eight.png")));
                            }

                            clickedCell.setEnabled(false);

                            totalCellsClicked++;
                            if(totalCellsClicked == (totalRows * totalCols -mineCount)){
                                for(int currentRow = 0; currentRow < totalRows; currentRow++){
                                    for(int currentCol = 0; currentCol < totalCols; currentCol++){
                                        cells[currentRow][currentCol].setEnabled(false);
                                        if(cells[currentRow][currentCol].getMine() == true){
                                            cells[currentRow][currentCol].setCellIcon(new ImageIcon(getClass().getResource("flag.png")));
                                        }
                                    }
                                }

                                JOptionPane.showMessageDialog(getRootPane(), "You won!");
                            }
                        }
                    });
                }
            }
        }
    }

    /*void clear(int targetRow, int targetCol){
        //if targetRow >= zero and targetRow < totalRows and targetCol >= 0 and targetCol <= totalCols
        if(targetRow >= 0 && targetRow < totalRows && targetCol >= 0 && targetCol <= totalCols){
            if() {
                cells[targetRow][targetCol].setCellIcon(new ImageIcon(getClass().getResource("clear.png")));

                clear(targetRow - 1, targetCol - 1);            //top left
                clear(targetRow - 1, targetCol);                //top middle
                clear(targetRow - 1, targetCol + 1);            //top right
                clear(targetRow, targetCol + 1);                //middle right
                clear(targetRow + 1, targetCol + 1);            //bottom right
                clear(targetRow + 1, targetCol);                //bottom middle
                clear(targetRow + 1, targetCol - 1);            //bottom left
                clear(targetRow, targetCol - 1);                //middle right
            }
        }
    }*/
}
