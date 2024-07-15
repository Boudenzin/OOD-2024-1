package br.ufpb.dcx.romildo.quiz;

public class PerguntaDissertativa extends Pergunta{

    public PerguntaDissertativa(String enunciado, String respostaCorreta) {
        super(enunciado,respostaCorreta);
    }
    public PerguntaDissertativa() {
        this("","");
    }
    @Override
    public boolean estahCorretaAResposta(String resposta) {
        return false;
    }
}
