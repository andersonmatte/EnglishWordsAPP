package me.andersonmatte.englishwords.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Senses extends RealmObject implements Serializable {

    @SerializedName("notes")
    @Expose
    private RealmList<Notes> notes;

    @SerializedName("definitions")
    @Expose
    private RealmList<String> definitions;

    public RealmList<Notes> getNotes() {
        return notes;
    }

    public void setNotes(RealmList<Notes> notes) {
        this.notes = notes;
    }

    public RealmList<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(RealmList<String> definitions) {
        this.definitions = definitions;
    }

}
