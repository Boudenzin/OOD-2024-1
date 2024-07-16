import java.util.Objects;

public class Bombeiro implements Comparable<Bombeiro> {

    private String nome;
    private int brigada;
    private String sangue;

    private double salario;

    public Bombeiro(String nome, int brigada, String sangue) {
        this.nome = nome;
        this.brigada = brigada;
        this.sangue = sangue;
        this.salario = 8341.28;
    }
    public Bombeiro() {
        this("",-1,"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o== null || getClass() != o.getClass()) return false;
        Bombeiro bombeiro = (Bombeiro) o;
        return brigada == bombeiro.brigada && Objects.equals(nome, bombeiro.nome) && Objects.equals(sangue, bombeiro.sangue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, brigada, sangue);
    }
    @Override
    public int compareTo(Bombeiro bomb) {
        int nomeCompare = this.nome.compareTo(bomb.nome);
        if (nomeCompare != 0) {
            return nomeCompare;
        }
        return Integer.compare(this.brigada, bomb.brigada);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBrigada() {
        return brigada;
    }

    public void setBrigada(int brigada) {
        this.brigada = brigada;
    }

    public String getSangue() {
        return sangue;
    }

    public void setSangue(String sangue) {
        this.sangue = sangue;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
