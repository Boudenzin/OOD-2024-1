import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
public class PreFarmaTest {

    public static void main (String[] args) throws MedicamentoJaCadastradoException {

        List<Medicamento> medicamentos = new ArrayList<>();

        String menu = """
              Bem vindo a FarmaGestão!
              Selecione uma das opções:
              1. Cadastre um medicamento
              2. Veja se algum medicamento cadastrado está no top 10 de medicamentos mais usados no Brasil
              3. Ver todos os medicamentos cadastrados
              4. Sair do FarmaGestao
        """;
        //TODO: FAZER UM SORTING PRA VER QUAL O MEDICAMENTO MAIS BARATO
        //TODO: FAZER UMA OPÇÃO PRA EXIBIR APENAS OS GENERICOS
        boolean continuar = true;
        while (continuar) {

            String opcao = JOptionPane.showInputDialog(null, menu, "FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
            switch (opcao) {
                case "1" :
                    double valor = 0.0;
                    Medicamento med;
                    boolean ehGenerico;
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do medicamento:", "FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do medicamento", "Cadastro de Medicamento", JOptionPane.INFORMATION_MESSAGE));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,"Sistema parado por causa de um inserção, algum texto ou símbolo não especificado foi inserido", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    }
                    String marca = JOptionPane.showInputDialog(null, "Digite o nome da marca: ", "Cadastro de medicamento", JOptionPane.INFORMATION_MESSAGE);
                    String generico = JOptionPane.showInputDialog(null, "O medicamento é genérico? (Sim/Não) ", "Cadastro de Medicamento", JOptionPane.INFORMATION_MESSAGE);
                    ehGenerico = generico.equalsIgnoreCase("Sim");

                    for (Medicamento medicamento : medicamentos) {  // Assuming 'medicamentos' is a list containing existing medications
                        if (medicamento.getNome().equalsIgnoreCase(nome)) {
                            throw new MedicamentoJaCadastradoException("Medicamento já cadastrado");
                        }
                    }
                    med = new Medicamento(nome, valor, marca, ehGenerico);
                    medicamentos.add(med);
                    break;
                case "2":
                    if (!medicamentos.isEmpty()) {

                        String procura = JOptionPane.showInputDialog(null, "Digite o nome do medicamento:", "Medicamentos Mais Vendidos - FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                        for (Medicamento m : medicamentos) {
                            if (m.getNome().equalsIgnoreCase(procura)) {
                                if (m.ehMaisVendido()) {
                                    JOptionPane.showMessageDialog(null, "O medicamento " + m.getNome() + " está entre os top 10 mais vendidos no Brasil", "Medicamentos Mais vendidos - FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null, "O medicamento " + m.getNome() + " não está entre os top 10 mais vendidos no Brasil", "Medicamentos Mais vendidos - FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Não há medicamentos cadastrados", "Medicamentos Mais Vendidos - FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "3":
                    if (!medicamentos.isEmpty()) {
                        StringBuilder saida = new StringBuilder();
                        for (Medicamento m : medicamentos) {
                            saida.append(m).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, saida, "Todos os medicamentos - FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Não há medicamentos cadastrados", "Todos os Medicamentos - FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case "4":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema", "FarmaGestao", JOptionPane.INFORMATION_MESSAGE);
                    break;



            }
        }
    }

}