package br.ufpb.dcx.romildo.quiz;

import java.io.Serializable;

public abstract class Pergunta implements Serializable {


    private String enunciado;
    private String respostaCorreta;

    public Pergunta(String enunciado, String respostaCorreta) {
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
    }

    public Pergunta() {
        this("","");
    }
    public abstract boolean estahCorretaAResposta(String resposta);

    public String getEnunciado() {
        return this.enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
}
