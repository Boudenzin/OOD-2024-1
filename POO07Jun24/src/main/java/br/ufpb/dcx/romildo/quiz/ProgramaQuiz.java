package br.ufpb.dcx.romildo.quiz;

import javax.swing.JOptionPane;
import java.util.List;

public class ProgramaQuiz {

    public static void main(String[] args) {
        InterfaceQuiz sistema = new SistemaQuiz();

        String menu = """
                Digite uma opção:
                1. Cadastrar Pergunta
                2. Sortear Pergunta
                3. Todas as Perguntas
                4. Sair
                
                
                """;
        boolean continuar = true;

        while (continuar) {

        String opcao = JOptionPane.showInputDialog(null, menu, "Menu - Quiz", JOptionPane.INFORMATION_MESSAGE);

        switch (opcao) {
                case "1":
                    PerguntaME pergunta = new PerguntaME();
                    pergunta.setEnunciado(JOptionPane.showInputDialog(null, "Digite a pergunta: ", "Cadastrar Pergunta", JOptionPane.INFORMATION_MESSAGE));
                    int quantAlternativa = 4;
                    String[] alternativas = new String[quantAlternativa];
                    for (int k = 0; k < quantAlternativa; k++) {
                        alternativas[k] = JOptionPane.showInputDialog(null, "Digite a " + (k + 1) + "º alternativa: ", "Registrando Alternativas...", JOptionPane.INFORMATION_MESSAGE);
                    }
                    pergunta.setAlternativas(alternativas);
                    pergunta.setRespostaCorreta(JOptionPane.showInputDialog(null, "Qual a resposta correta?", "Registrando Resposta Correta...", JOptionPane.INFORMATION_MESSAGE));
                    sistema.cadastraPergunta(pergunta);
                    break;
                case "2":
                    try {
                        Pergunta sorteada = sistema.sorteiaPergunta();
                        String resposta = JOptionPane.showInputDialog(null, sorteada.toString(), "Sorteando Pergunta", JOptionPane.INFORMATION_MESSAGE);
                        if (sorteada.estahCorretaAResposta(resposta)) {
                            JOptionPane.showMessageDialog(null, "Parabéns, você acertou!", "Parabéns!", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "A resposta correta era: " + sorteada.getRespostaCorreta(), "Resposta Incorreta", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (PerguntaNaoExisteException e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível sortear uma pergunta", "Sorteando Pergunta", JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    List<Pergunta> perguntas = sistema.getTodasAsPerguntas();
                    StringBuilder saida = new StringBuilder();
                    for (Pergunta p : perguntas) {
                        saida.append(p.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, "As perguntas são: \n" + saida, "Mostrando as Perguntas", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Obrigado por usar o programa!", "Até mais!", JOptionPane.INFORMATION_MESSAGE);
                    continuar = false;
            }
        }



    }
}
