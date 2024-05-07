public class CellModel {
    private boolean isMine = false;
    private boolean isEnabled = true;
    private boolean isFlagged = false;

    public void placeMine() throws MinePlacingException {
        if (!isEnabled) {
            throw new MinePlacingException("Cell is disabled.");
        } else if (isMine) {
            throw new MinePlacingException("Cell already has mine.");
        } else {
            isMine = true;
        }
    }

    public void placeFlag() throws FlagPlacingException {
        if (!isEnabled) {
            throw new FlagPlacingException("Cell is disabled.");
        } else if (isFlagged) {
            throw new FlagPlacingException("Cell already has flag");
        } else {
            isFlagged = true;
        }
    }

    public boolean dig() throws CellDigException {
        if (!isEnabled) {
            throw new CellDigException("Cell is disabled.");
        } else {
            isEnabled = false;
            return isMine;
        }
    }
}
