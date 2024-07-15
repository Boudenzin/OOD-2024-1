package br.ufpb.dcx.romildo.quiz;

public class PerguntaVF extends Pergunta{

    private String afirmativa;

    public PerguntaVF(String enunciado, String respostaCorreta, String afirmativa) {
        super(enunciado, respostaCorreta);
        this.afirmativa = afirmativa;
    }

    public PerguntaVF() {
        this("","","");
    }

    @Override
    public boolean estahCorretaAResposta(String resposta) {
        return false;
    }
}
