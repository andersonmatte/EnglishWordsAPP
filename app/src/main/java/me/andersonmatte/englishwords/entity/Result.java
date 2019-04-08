package me.andersonmatte.englishwords.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Result extends RealmObject implements Serializable {

    @SerializedName("lexicalEntries")
    @Expose
    private RealmList<LexicalEntries> lexicalEntries;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("word")
    @Expose
    private String word;

    public RealmList<LexicalEntries> getLexicalEntries() {
        return lexicalEntries;
    }

    public void setLexicalEntries(RealmList<LexicalEntries> lexicalEntries) {
        this.lexicalEntries = lexicalEntries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
