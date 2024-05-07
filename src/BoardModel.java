import java.util.ArrayList;

public class BoardModel {
    private final ArrayList<ArrayList<CellModel>> cells;
    private final int columns;

    public BoardModel(int rows, int columns) {
        this.columns = columns;

        cells = new ArrayList<>();

        for (int rowCount = 0; rowCount < rows; rowCount++) {
            cells.add(new ArrayList<>());
        }
    }

    public int size() {
        int size = 0;

        for (ArrayList<CellModel> row : cells) {
            size += row.size();
        }

        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(CellModel cell) throws BoardAddException {
        for (ArrayList<CellModel> row : cells) {
            if (row.size() < columns) {
                row.add(cell);
                return;
            }
        }

        throw new BoardAddException("Board is full.");
    }
}
