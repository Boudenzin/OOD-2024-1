import java.io.Serial;

public class OficialJaExisteException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public OficialJaExisteException(String msg) {
        super(msg);
    }
}
