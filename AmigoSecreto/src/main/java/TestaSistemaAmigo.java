import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {

        SistemaAmigo amigos = new SistemaAmigo();
        List<Mensagem> mensagensExibir = new ArrayList<>();
        try {
            amigos.cadastraAmigo("José", "jose2024@hotmail.com");
            amigos.cadastraAmigo("Maria", "maria2023@hotmail.com");
        } catch (AmigoJaCadastradoException e) {
            e.printStackTrace();
        }

        try {
            amigos.configuraAmigoSecretoDe("jose2024@hotmail.com", "maria2023@hotmail.com");
            amigos.configuraAmigoSecretoDe("maria2023@hotmail.com", "jose2024@hotmail.com");
        } catch (AmigoInexistenteException e) {
            e.printStackTrace();
        }

            amigos.enviarMensagemParaAlguem("Olá José!", "maria2023@hotmail.com", "jose2024@hotmail.com", true);
            amigos.enviarMensagemParaTodos("Olá a todos!", "maria2023@hotmail.com", true);

            try {
                mensagensExibir = amigos.pesquisaMensagensAnonimas();
            } catch (ListaVaziaException e) {
                e.printStackTrace();
            }
            StringBuilder saida = new StringBuilder();
            for (Mensagem m : mensagensExibir) {
                saida.append(m.getTextoCompletoAExibir()).append("\n");
            }
        JOptionPane.showMessageDialog(null, saida, "Amigo Secreto", JOptionPane.INFORMATION_MESSAGE);
            try {
                if (amigos.pesquisaAmigoSecretoDe("maria2023@hotmail.com").equals("jose2024@hotmail.com")) {
                    JOptionPane.showMessageDialog(null, "OK", "Amigo Secreto", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
                e.printStackTrace();
            }

    }
}
