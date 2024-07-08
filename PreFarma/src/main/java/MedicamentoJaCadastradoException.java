import java.io.Serial;

public class MedicamentoJaCadastradoException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;
    public MedicamentoJaCadastradoException(String message) {
        super(message);
    }
}
