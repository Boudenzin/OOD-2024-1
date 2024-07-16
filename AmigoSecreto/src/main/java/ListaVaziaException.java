import java.io.Serial;

public class ListaVaziaException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public ListaVaziaException(String msg) {
        super(msg);
    }
}
