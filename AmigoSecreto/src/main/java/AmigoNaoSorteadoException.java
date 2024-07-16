import java.io.Serial;

public class AmigoNaoSorteadoException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public AmigoNaoSorteadoException(String msg) {
        super(msg);
    }
}
