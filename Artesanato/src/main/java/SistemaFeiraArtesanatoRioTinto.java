import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
public class SistemaFeiraArtesanatoRioTinto implements SistemaFeiraArtesanato{

    private Map<String, ItemDeArtesanato> itensDeArtesanato;

    public static final String PREFIXO_CODIGO = "COD";

    public SistemaFeiraArtesanatoRioTinto() {
        this.itensDeArtesanato = new HashMap<>();
    }
    @Override
    public void cadastraItem(ItemDeArtesanato item) throws ItemJaExisteException, CodigoInvalidoException {
        if(!this.itensDeArtesanato.containsKey(item.getCode())) {
            if (item.getCode().startsWith(PREFIXO_CODIGO)) {
                itensDeArtesanato.put(item.getCode(), item);
            } else {
                throw new CodigoInvalidoException("Código não começa com o prefixo " + PREFIXO_CODIGO);
            }
        } else {
            throw new ItemJaExisteException("Item já cadastrado no sistema");
        }
    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome) {
        List<ItemDeArtesanato> itensPeloNome = new LinkedList<>();
        for (ItemDeArtesanato i : this.itensDeArtesanato.values()) {
            if (i.getNome().startsWith(nome)) {
                itensPeloNome.add(i);
            }
        }
        Collections.sort(itensPeloNome);
        return itensPeloNome;

    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco) {
        List<ItemDeArtesanato> itensPorPreco = new LinkedList<>();
        for (ItemDeArtesanato i : this.itensDeArtesanato.values()) {
            if (i.getPreco() <= preco) {
                itensPorPreco.add(i);
            }
        }

        Collections.sort(itensPorPreco);
        return itensPorPreco;
    }

    @Override
    public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws ItemInexistenteException {

        ItemDeArtesanato item = this.itensDeArtesanato.get(codigo);
        if (item == null) {
            throw new ItemInexistenteException("Item não encontrado/existe" + codigo);
        } else {
            return item;
        }
    }
}
