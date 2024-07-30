import java.io.Serial;

public class CodigoInvalidoException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public CodigoInvalidoException(String msg) {
        super(msg);
    }
}
