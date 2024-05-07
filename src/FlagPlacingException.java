public class FlagPlacingException extends Exception {
    public FlagPlacingException(String reason) {
        super("Cannot place flag on cell. Reason: " + reason);
    }
}
