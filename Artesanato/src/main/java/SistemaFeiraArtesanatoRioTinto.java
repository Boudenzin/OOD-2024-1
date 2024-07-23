import java.util.*;

public class SistemaFeiraArtesanatoRioTinto implements SistemaFeiraArtesanato{

    private Map<String, ItemDeArtesanato> itensDeArtesanato;

    public SistemaFeiraArtesanatoRioTinto() {
        this.itensDeArtesanato = new HashMap<>();
    }
    @Override
    public boolean cadastraItem(ItemDeArtesanato item) {
        if(!this.itensDeArtesanato.containsKey(item.getCode())) {
            itensDeArtesanato.put(item.getCode(), item);
            return true;
        }
        return false;
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
