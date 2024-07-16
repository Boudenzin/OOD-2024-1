public interface BrigadaInterface {

    public void cadastrarBombeiro(Bombeiro bombeiro) throws OficialJaExisteException;

    public Bombeiro buscarBombeiro(Bombeiro bombeiro) throws BombeiroNaoExisteException;

    public void cadastraCapitao(Capitao capitao) throws OficialJaExisteException;

    public void removerBombeiro(Bombeiro bombeiro) throws BombeiroNaoExisteException;
}
