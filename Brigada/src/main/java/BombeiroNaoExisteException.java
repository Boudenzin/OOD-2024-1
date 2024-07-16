import java.io.Serial;

public class BombeiroNaoExisteException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;
    public BombeiroNaoExisteException(String msg) {
        super(msg);
    }
}



