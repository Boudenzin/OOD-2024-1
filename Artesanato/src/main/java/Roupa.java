public class Roupa extends ItemDeArtesanato{

    private String material;
    private String tipo;
    private String tamanho;

    public Roupa(double preco, String nome, String code, String material, String tipo, String tamanho) {
        super(preco, nome, code);
        this.material = material;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }
}
