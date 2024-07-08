import java.util.ArrayList;
public class Medicamento {

    private String nome;
    private double valor;
    private String marca;
    private boolean ehGenerico;

    public Medicamento(String nome, double valor, String marca, boolean ehGenerico){
        this.nome = nome;
        this.valor = valor;
        this.marca = marca;
        this.ehGenerico = ehGenerico;

    }
    public Medicamento(String nome, double valor, String marca) {
        this.nome = nome;
        this.valor = valor;
        this.marca = marca;
        this.ehGenerico = false;
    }

    public Medicamento() {
        this("",0.0,"", false);
    }

    public String getNome() {
        return this.nome;
    }

    public double getValor() {
        return this.valor;
    }

    public String getMarca() {
        return this.marca;
    }
    public boolean getEhGenerico() {
        return this.ehGenerico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setEhGenerico(boolean ehGenerico) {
        this.ehGenerico = ehGenerico;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Medicamento medicamento = (Medicamento) other;
        return Double.compare(valor, medicamento.valor) == 0 &&
                nome.equals(medicamento.nome) &&
                marca.equals(medicamento.marca);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (int) Double.doubleToLongBits(valor);
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        return result;
    }

    public boolean ehMaisVendido() {
        String[] medMaisVendidos = {
                "Neosoro",
                "Amoxicillina",
                "Azitromicina",
                "Rivotril",
                "Losartana",
                "Aradois",
                "Escitalopram",
                "Cefalexina",
                "Dorflex",
                "Glifage XR"
        };

        for (String s : medMaisVendidos) {
            if (s.equalsIgnoreCase(this.nome)) {
                return true;
            }
        }
        return false;
    }


    public String getGenericoString() {
        if (ehGenerico) {
            return "Sim";
        }
        return "Não";
    }


    public String toString() {
        return String.format("""
              Nome: %s
              Valor: %.2f
              Marca: %s
              Genérico: %s
        """, this.nome, this.valor, this.marca, this.getGenericoString());
    }



}