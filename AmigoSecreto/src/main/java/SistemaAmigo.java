import javax.naming.ConfigurationException;
import java.util.ArrayList;
import java.util.List;
public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(List<Mensagem> mensagens, List<Amigo> amigos) {
        this.mensagens = mensagens;
        this.amigos = amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaCadastradoException{

        Amigo a = new Amigo(nomeAmigo, emailAmigo);
        if (!this.amigos.contains(a)) {
            this.amigos.add(a);
        } throw new AmigoJaCadastradoException("Amigo já cadastrado");
    }

    public Amigo pesquisaAmigo(String emailAmigo) {
        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(emailAmigo)) {
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem m = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        System.out.println(m.getTextoCompletoAExibir());

    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem m = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        System.out.println(m.getTextoCompletoAExibir());

    }

    public List<Mensagem> pesquisaMensagensAnonimas() throws ListaVaziaException {
        if (!this.mensagens.isEmpty()) {
            List<Mensagem> mensagensAnonimas = new ArrayList<>();
            for (Mensagem m : this.mensagens) {
                if (m.ehAnonima()) {
                    mensagensAnonimas.add(m);
                }
            }
        }
        throw new ListaVaziaException("Nenhuma mensagem cadastrada/encontrada");
    }

    public List<Mensagem> pesquisaTodasAsMensagens() throws ListaVaziaException{
        if (!this.mensagens.isEmpty()) {
            return this.mensagens;
        }
        throw new ListaVaziaException("Nenhuma mensagem cadastrada/encontrada");
    }


    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo a = pesquisaAmigo(emailDaPessoa);
        if (a==null) {
            throw new AmigoInexistenteException("Amigo não existe");
        }

    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) {

    }
}
