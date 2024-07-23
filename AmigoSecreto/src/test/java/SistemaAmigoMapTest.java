import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaAmigoMapTest {

    SistemaAmigoMap sistemaMap;

    @BeforeEach
    void setUp()  {
        this.sistemaMap = new SistemaAmigoMap();
    }

    @Test
    void testSistemaAmigo() {
        assertThrows(ListaVaziaException.class,
                ()  -> sistemaMap.pesquisaTodasAsMensagens().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                () -> sistemaMap.pesquisaAmigo("romildo@gmail.com"));
    }

    @Test
    void testPesquisaECadastraAmigo() {
        try {
            sistemaMap.pesquisaAmigo("romildo@gmail.com");
            fail("Deveria falhar pois não existe ainda");
        } catch (AmigoInexistenteException e) {
            //Ok
        }
        try {
            sistemaMap.cadastraAmigo("Romildo", "romildo@yahoo.com.br");
                Amigo a = sistemaMap.pesquisaAmigo("romildo@yahoo.com.br");
            assertEquals("Romildo", a.getNome());
            assertEquals("romildo@yahoo.com.br", a.getEmail());
        } catch (AmigoJaCadastradoException | AmigoInexistenteException e) {
            fail("Não deveria lançar exceção");
        }


    }

    @Test
    void testEnviarMensagemParaTodos() {
            assertThrows(ListaVaziaException.class,
                    () -> sistemaMap.pesquisaTodasAsMensagens().isEmpty());
            sistemaMap.enviarMensagemParaTodos("texto", "romildo@yahoo.com.br", true);
            try {
                List<Mensagem> mensagensAchadas = sistemaMap.pesquisaTodasAsMensagens();
                assertEquals(1, mensagensAchadas.size());
                assertEquals("romildo@yahoo.com.br", mensagensAchadas.getFirst().getEmailRemetente());
            } catch (ListaVaziaException e) {
                fail("Não deveria lançar exceção");

        }
    }

    @Test
    void testEnviarMensagemParaAlguem() {
        try {
            assertThrows(ListaVaziaException.class,
                    () -> sistemaMap.pesquisaTodasAsMensagens().isEmpty());
            sistemaMap.enviarMensagemParaAlguem("texto", "romildo@yahoo.com.br", "kaua@gmail.com", true);
            List<Mensagem> mensagensAchadas = sistemaMap.pesquisaTodasAsMensagens();
            assertEquals(1, mensagensAchadas.size());
            assertTrue(mensagensAchadas.getFirst() instanceof MensagemParaAlguem);
            assertEquals("texto", mensagensAchadas.getFirst().getTexto());
        } catch (ListaVaziaException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        assertThrows(ListaVaziaException.class,
                () -> sistemaMap.pesquisaTodasAsMensagens().isEmpty());
        assertThrows(ListaVaziaException.class,
                () -> sistemaMap.pesquisaMensagensAnonimas().isEmpty());
        try {
            sistemaMap.enviarMensagemParaAlguem("texto 1", "romildo@yahoo.com.br", "gus@dcx.ufpb.br", false);
            sistemaMap.enviarMensagemParaAlguem("texto 2", "romildo@yahoo.com.br", "gus@dcx.ufpb.br", true);
            assertEquals(1, sistemaMap.pesquisaMensagensAnonimas().size());
        } catch (ListaVaziaException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testPesquisaTodasAsMensagens() {
            assertThrows(ListaVaziaException.class,
                    () -> sistemaMap.pesquisaTodasAsMensagens().isEmpty());
            try {
            sistemaMap.enviarMensagemParaAlguem("texto 1", "romildo@gmail.com", "alex@gmail.com", false);
            assertEquals(1, sistemaMap.pesquisaTodasAsMensagens().size());
            sistemaMap.enviarMensagemParaAlguem("texto 2", "romildo@gmail.com", "alex@gmail.com", true);
            assertEquals(2, sistemaMap.pesquisaTodasAsMensagens().size());
        } catch (ListaVaziaException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        assertThrows(AmigoInexistenteException.class,
                ()-> sistemaMap.pesquisaAmigoSecretoDe("ayla@dcx.ufpb.br"));
        try {
            sistemaMap.cadastraAmigo("Mizael", "mizael@gmail.com");
            sistemaMap.cadastraAmigo("Beatriz", "bia@gmail.com");
            sistemaMap.configuraAmigoSecretoDe("mizael@gmail.com", "bia@gmail.com");
            sistemaMap.configuraAmigoSecretoDe("bia@gmail.com", "mizael@gmail.com");
            assertEquals("bia@gmail.com", sistemaMap.pesquisaAmigoSecretoDe("mizael@gmail.com"));
            assertEquals("mizael@gmail.com", sistemaMap.pesquisaAmigoSecretoDe("bia@gmail.com"));
        } catch (AmigoNaoSorteadoException | AmigoInexistenteException | AmigoJaCadastradoException e) {
            fail("Não deveria lançar exceção");
        }
    }


}