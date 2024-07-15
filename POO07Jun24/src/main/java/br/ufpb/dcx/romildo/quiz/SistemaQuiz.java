package br.ufpb.dcx.romildo.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SistemaQuiz implements InterfaceQuiz{

    private List<Pergunta> perguntas;
    private Random rd;

    public SistemaQuiz(){
        this.perguntas = new ArrayList<>();
        this.rd = new Random();
    }

    public SistemaQuiz(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
        this.rd = new Random();
    }

    public void cadastraPergunta(Pergunta p) {
        this.perguntas.add(p);


    }
    public Pergunta sorteiaPergunta() throws PerguntaNaoExisteException {
        if (this.perguntas.isEmpty()) {
            throw new PerguntaNaoExisteException("Lista vazia");
        }
        int indiceSorteado = rd.nextInt(this.perguntas.size());
        return this.perguntas.get(indiceSorteado);
    }

    public List<Pergunta> getTodasAsPerguntas() {
        if (this.perguntas.isEmpty()) {
            return null;
        }
        return this.perguntas;
    }
}
