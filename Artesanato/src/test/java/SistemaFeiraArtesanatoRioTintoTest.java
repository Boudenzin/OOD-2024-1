import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SistemaFeiraArtesanatoRioTintoTest {

    SistemaFeiraArtesanato sistema = new SistemaFeiraArtesanatoRioTinto();

    @BeforeEach
    void setUp()  {
        this.sistema = new SistemaFeiraArtesanatoRioTinto();
    }
}
