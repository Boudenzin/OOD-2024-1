import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaAmigo amigos = new SistemaAmigo();

        System.out.println("Digite a quantidade de pessoas que vai participar da brincadeira");
        int quantPessoas = Integer.parseInt(sc.nextLine());

        List<String> emails = new ArrayList<>();

        for (int i = 1; i < quantPessoas + 1; i++) {
            System.out.println("Digite o nome do amigo: ");

            String name = sc.nextLine(); // Linha bugada do java

            System.out.println("Digite o email: ");
            String email = sc.nextLine();

            emails.add(email);

            try {
                amigos.cadastraAmigo(name, email);
            } catch (AmigoJaCadastradoException e) {
                e.printStackTrace();
            }
            Sorteio sorteio = new Sorteio(emails);
            sorteio.sortear();
        }
        System.out.println("Digite o texto que você quer enviar:");
        String texto = sc.nextLine();
        System.out.println("É anônimo?");
        String ehAnonimo = sc.nextLine();

        if (ehAnonimo.equalsIgnoreCase("Sim")) {
            amigos.enviarMensagemParaTodos(texto, "anonimo", true);
        } else {
            System.out.println("Digite o seu email");
            String emailRemetente = sc.nextLine();
            amigos.enviarMensagemParaTodos(texto, emailRemetente, false);
        }

        sc.close();
    }

}
