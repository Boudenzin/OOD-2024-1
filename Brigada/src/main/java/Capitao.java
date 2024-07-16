public class Capitao extends Bombeiro{

    private String patente;

    public Capitao(String nome, int brigada, String sangue) {
        super(nome, brigada, sangue);
        this.patente = "Capitão";
        super.setSalario(10214.99);
    }


}
