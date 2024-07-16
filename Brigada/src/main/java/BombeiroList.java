import java.util.ArrayList;
import java.util.List;

public class BombeiroList implements BrigadaInterface{

    private List<Bombeiro> bombeiros;

    public BombeiroList() {
        this.bombeiros = new ArrayList<>();
    }

    public void cadastrarBombeiro(Bombeiro bombeiro) throws OficialJaExisteException {

        if (!bombeiros.contains(bombeiro)) {
            bombeiros.add(bombeiro);
        } else {
            throw new OficialJaExisteException("Oficial já cadastrado no sistema.");
        }
    }


    public Bombeiro buscarBombeiro(Bombeiro bombeiro) throws BombeiroNaoExisteException{
        for (Bombeiro b : this.bombeiros) {
            if (b.equals(bombeiro)) {
                return b;
        }
        throw new BombeiroNaoExisteException("Bombeiro não Encontrado");
    }
        return null;
    }

    public void cadastraCapitao(Capitao capitao) throws OficialJaExisteException{
        if (!bombeiros.contains(capitao)) {
            bombeiros.add(capitao);
        } else {
            throw new OficialJaExisteException("Capitão já cadastrado no sistema.");
        }
    }


    public void removerBombeiro(Bombeiro bombeiro) throws BombeiroNaoExisteException {

        try {
            Bombeiro bombeiro1 = this.buscarBombeiro(bombeiro);
                    bombeiros.remove(bombeiro1);
        } catch (BombeiroNaoExisteException e) {
            throw new BombeiroNaoExisteException(e.getMessage());
        }
    }


}
