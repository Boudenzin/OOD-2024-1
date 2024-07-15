package br.ufpb.dcx.romildo.quiz;

import java.util.Arrays;
import java.util.Objects;

public class PerguntaME extends Pergunta{

    private String[] alternativas;

    public PerguntaME(String enunciado, String respostaCorreta, String[] alternativas) {
        super(enunciado, respostaCorreta);
        this.alternativas = alternativas;
    }

    public PerguntaME(String[] alternativas) {
        this.alternativas = alternativas;
    }

    public PerguntaME() {
        this("","",new String[]{});
    }

    public String[] getAlternativas() {
        return this.alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerguntaME that)) return false;
        return Objects.equals(super.getEnunciado(), that.getEnunciado())
                && Objects.equals (super.getRespostaCorreta(), that.getRespostaCorreta())
                && Arrays.equals(alternativas, that.alternativas);
    }


    @Override
    public int hashCode() {
        return Arrays.hashCode(alternativas);
    }

    public String alternativasTexto() {
        String texto = "";
        for (String s : this.alternativas) {
            texto += (s +"\n");
        }
        return texto;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                %s
                """,this.getEnunciado(), this.alternativasTexto());
    }

    @Override
    public boolean estahCorretaAResposta(String resposta) {
        return resposta.equals(this.getRespostaCorreta());
    }
}
