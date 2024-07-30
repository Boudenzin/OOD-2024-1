import java.util.List;

/**
* Sistema para gerenciar itens de artesanato
* */
public interface SistemaFeiraArtesanato {

    /**
     *
     * Cadastra um novo item no sistema
     * @param item O item a ser adicionado
     * @throws ItemJaExisteException se o item já foi cadastrado
     * */
    public void cadastraItem(ItemDeArtesanato item) throws ItemJaExisteException, CodigoInvalidoException;

    /**
     * Pesquisa todos os itens cujo o nome começa com o nome de acordo com o parametro
     * @param nome O nome a ser pesquisado
     * @return uma lista contendo os itens cujo nome começa com o parâmetro passado
     */
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome);

    /**
     * Pesquisa os itens cujo preço é menor ou igual ao valor passado no parâmetro
     * @param preco O valor dos itens a ser pesquisado
     * @return uma lista contendo os itens cujo preço é menor ou igual ao valor passado no parâmetro
     */

    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco);

    /**
     *
     * Pesquisa os itens a partir do codigo de acordo com o parametro
     * @param codigo O codigo a ser pesquisado
     * @return um item encontrado de acordo com o codigo passado de acordo com o parametro
     * @throws ItemInexistenteException se não encontrar ninguém com esse código
     */

    public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws ItemInexistenteException;
}
