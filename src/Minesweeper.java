import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Minesweeper implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem newGameMenuItem, settingsMenuItem, quitMenuItem, helpMenuItem;

    private int boardRows = 4;
    private int boardCols = boardRows;
    private int mines = 4;
    private static int minRows = 3;
    private static int maxRows = 12;
    private static int minMines = 2;
    private int maxMines = boardRows*boardCols/2;

    private Board board;

    public static void main(String[] args){
        new Minesweeper();
    }

    public Minesweeper(){
        this.createGUI();
    }

    void createGUI(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { }

        frame = new JFrame("Minesweeper"){};

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
        frame.add(mainPanel);

        menuBar = new JMenuBar();

        gameMenu = new JMenu("Game");
        newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainPanel.removeAll();
                board = new Board(boardRows, boardCols, mines);
                mainPanel.add(board);
                mainPanel.revalidate();
            }
        });
        gameMenu.add(newGameMenuItem);

        settingsMenuItem = new JMenuItem("Settings");
        settingsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object[] difficulties = {"Beginner", "Intermediate", "Expert" };
                String difficultyChoice = (String)JOptionPane.showInputDialog(frame, "Select a difficulty.", "Difficulty Selection", JOptionPane.PLAIN_MESSAGE, null, difficulties, difficulties[0]);
                if(difficultyChoice == "Beginner"){
                    boardRows = 4;
                    boardCols = 4;
                    mines = 4;
                }
                else if(difficultyChoice == "Intermediate"){
                    boardRows = 8;
                    boardCols = 8;
                    mines = 15;
                }
                else if(difficultyChoice == "Expert"){
                    boardRows = 12;
                    boardCols = 12;
                    mines = 40;
                }

                mainPanel.removeAll();
                board = new Board(boardRows, boardCols, mines);
                mainPanel.add(board);
                mainPanel.revalidate();
                frame.pack();
            }
        });
        gameMenu.add(settingsMenuItem);

        quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        gameMenu.add(quitMenuItem);

        menuBar.add(gameMenu);

        helpMenuItem = new JMenuItem("Help");
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(frame, "Goal: Clear all of the cells that are not mines.\n\nIf you click on a mine, you lose.\nThe number on a cell represents the number of mines bordering that cell.\nCells without numbers have no bordering mines.");
            }
        });
        menuBar.add(helpMenuItem);

        frame.setJMenuBar(menuBar);

        board = new Board(boardRows, boardCols, mines);
        mainPanel.add(board);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}