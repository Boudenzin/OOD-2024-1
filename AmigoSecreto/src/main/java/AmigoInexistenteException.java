import java.io.Serial;

public class AmigoInexistenteException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public AmigoInexistenteException(String msg) {
        super(msg);
    }
}
