import java.io.Serial;

public class ItemInexistenteException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public ItemInexistenteException(String msg) {
        super(msg);
    }
}
