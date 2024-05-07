public class BoardAddException extends Exception {
    public BoardAddException(String reason) {
        super("Cannot add cell to board. Reason: " + reason);
    }
}
