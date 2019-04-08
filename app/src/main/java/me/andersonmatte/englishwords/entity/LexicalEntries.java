package me.andersonmatte.englishwords.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;

public class LexicalEntries extends RealmObject implements Serializable {

    @SerializedName("entries")
    @Expose
    private RealmList<Entries> entries;

    @SerializedName("language")
    @Expose
    private String language;

    public RealmList<Entries> getEntries() {
        return entries;
    }

    public void setEntries(RealmList<Entries> entries) {
        this.entries = entries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
