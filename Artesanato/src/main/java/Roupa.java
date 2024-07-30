public class Roupa extends ItemDeArtesanato{

    private String material;
    private String tamanho;

    public Roupa(double preco, String nome, String code, String material, String tamanho) {
        super(preco, nome, code, TipoItem.ROUPA);
        this.material = material;
        this.tamanho = tamanho;
    }

    public Roupa() {
        this(0.0, "","", "", "");
    }

    public String getDescricao() {
        return String.format("""
        Roupa -----
        Código : %s
        Nome : %s
        Preço : %.2f

        """, super.getCode(), super.getNome(), super.getPreco());
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
