import java.io.Serial;

public class AmigoJaCadastradoException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public AmigoJaCadastradoException(String msg) {
        super(msg);
    }
}
