public class MinePlacingException extends Exception {
    public MinePlacingException(String reason) {
        super("Cannot place mine in cell. Reason: " + reason);
    }
}
