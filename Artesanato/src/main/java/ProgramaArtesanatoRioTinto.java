import javax.swing.JOptionPane;
import java.util.List;
public class ProgramaArtesanatoRioTinto {

    public static void main(String[] args) {

        String menu = """
                1. Cadastrar item
                2. Pesquisar itens pelo nome
                3. Pesquisar itens pelo código
                4. Sair
                """;

        boolean continuar = true;
        SistemaFeiraArtesanato sistema = new SistemaFeiraArtesanatoRioTinto();
        while(continuar) {

            String opcao = JOptionPane.showInputDialog(null, menu, "Feira de Artesanato Rio Tinto", JOptionPane.INFORMATION_MESSAGE);

            switch(opcao) {
                case "1":
                    ItemDeArtesanato item = new ItemDeArtesanato();
                    String codigo = JOptionPane.showInputDialog(null, "Digite o código", "Cadastra Item", JOptionPane.INFORMATION_MESSAGE);
                    item.setCode(codigo);
                    item.setNome(JOptionPane.showInputDialog(null, "Digite o nome do item", "Cadastra Item", JOptionPane.INFORMATION_MESSAGE));
                    item.setPreco(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preço", JOptionPane.INFORMATION_MESSAGE)));
                    if (sistema.cadastraItem(item)) {
                        JOptionPane.showMessageDialog(null, "Item cadastrado", "Cadastra Item",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Item não cadastrado","Erro de Cadastro" ,JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "2":
                    String nomesPesquisar = JOptionPane.showInputDialog(null, "Digite o nome do item a ser pesquisado", "Pesquisa Item Pelo Nome", JOptionPane.INFORMATION_MESSAGE);
                    List<ItemDeArtesanato> itensPeloNome = sistema.pesquisaItensPeloNome(nomesPesquisar);

                    if (itensPeloNome.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum item com o nome " + nomesPesquisar + " encontrado", "Pesquisar Itens Pelo Nome", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        StringBuilder saidaNome = new StringBuilder();
                        for (ItemDeArtesanato i : itensPeloNome) {
                            saidaNome.append(i).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, saidaNome, "Pesquisar Item Pelo Nome", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "3":
                    String codigoPesquisar =JOptionPane.showInputDialog(null, "Digite o código do item a ser pesquisado", "Pesquisa Item Pelo Código", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        ItemDeArtesanato itemAchado = sistema.pesquisaItemPeloCodigo(codigoPesquisar);
                        JOptionPane.showMessageDialog(null, "Item encontrado: " + itemAchado, "Pesquisar Item Pelo Nome", JOptionPane.INFORMATION_MESSAGE);
                    } catch (ItemInexistenteException e) {
                        JOptionPane.showMessageDialog(null, "Nenhum item foi encontrado", "Pesquisar Item Pelo Código", JOptionPane.INFORMATION_MESSAGE);
                        System.err.println(e.getMessage());
                    }
                    break;
                case "4":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o sistema!", "Até mais",JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Digite apenas uma das opções", "Erro de Entrada", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
