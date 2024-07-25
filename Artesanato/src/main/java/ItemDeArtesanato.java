import java.util.Objects;

public class ItemDeArtesanato implements Comparable<ItemDeArtesanato>{

    private double preco;
    private String nome;
    private String code;

    public ItemDeArtesanato(double preco, String nome, String code) {
        this.preco = preco;
        this.nome = nome;
        this.code = code;
    }

    public ItemDeArtesanato() {
        this(0.0,"","");
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDeArtesanato item = (ItemDeArtesanato) o;
        return Double.compare(preco, item.preco) == 0 && Objects.equals(nome, item.nome) && Objects.equals(code, item.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preco, nome, code);
    }
    @Override
    public int compareTo(ItemDeArtesanato o) {
        return this.nome.compareTo(o.getNome());
        /*
        * if (this.preco < o.getpreco()) {return -1}
        *
        *
        * return (int) (this.preco - o.getPreco);
        * */
    }

    @Override
    public String toString() {
        return String.format("""
                Código : %s
                Nome : %s
                Preço : %.2f
                
                """, this.code, this.nome, this.preco);
    }
}
