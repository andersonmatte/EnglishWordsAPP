package me.andersonmatte.englishwords.entity;

import java.io.Serializable;

import io.realm.RealmObject;

public class Palavra extends RealmObject implements Serializable {

    private String conteudo;

    private String traducao;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getTraducao() {
        return traducao;
    }

    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }

}
