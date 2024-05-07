public class CellDigException extends Exception {
    public CellDigException(String reason) {
        super("Could not dig cell. Reason: " + reason);
    }
}
