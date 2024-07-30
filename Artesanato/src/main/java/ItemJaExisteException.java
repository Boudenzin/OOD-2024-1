import java.io.Serial;

public class ItemJaExisteException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public ItemJaExisteException(String msg) {
        super(msg);
    }
}
