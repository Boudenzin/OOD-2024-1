import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class SistemaAmigoMap {

    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaCadastradoException{

        Amigo a = new Amigo(nomeAmigo, emailAmigo);
        if (!this.amigos.containsKey(emailAmigo)) {
            this.amigos.put(emailAmigo, a);
        } else {
            throw new AmigoJaCadastradoException("Amigo já cadastrado");
        }
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        if (this.amigos.containsKey(emailAmigo)) {
            return this.amigos.get(emailAmigo);
        } else {
            throw new AmigoInexistenteException("Amigo não encontrado");
        }
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem m = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(m);
        System.out.println(m.getTextoCompletoAExibir());

    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem m = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(m);
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
            return mensagens;
        }
        throw new ListaVaziaException("Nenhuma mensagem cadastrada/encontrada");
    }

    public List<Mensagem> pesquisaTodasAsMensagens() throws ListaVaziaException {
        if (!this.mensagens.isEmpty()) {
            return this.mensagens;
        } else {
            throw new ListaVaziaException("Nenhuma mensagem cadastrada/encontrada");
        }
    }


    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo presenteador = pesquisaAmigo(emailDaPessoa);
        if (presenteador==null) {
            throw new AmigoInexistenteException("Amigo não existe");
        }
        presenteador.setEmailAmigoSorteado(emailAmigoSorteado);

    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        Amigo a = pesquisaAmigo(emailDaPessoa);
        if (a == null) {
            throw new AmigoInexistenteException("Amigo não existe");
        }
        if (a.getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("Amigo ainda não sorteado");
        }
        return a.getEmailAmigoSorteado();
    }
}
