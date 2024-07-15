package br.ufpb.dcx.romildo.quiz;
import java.util.List;
public interface InterfaceQuiz {

    public void cadastraPergunta(Pergunta p);
    public Pergunta sorteiaPergunta() throws PerguntaNaoExisteException;
    public List<Pergunta> getTodasAsPerguntas();
}
