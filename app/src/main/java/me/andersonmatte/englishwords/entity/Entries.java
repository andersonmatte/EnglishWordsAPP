package me.andersonmatte.englishwords.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Entries extends RealmObject implements Serializable {

    @SerializedName("senses")
    @Expose
    private RealmList<Senses> senses;

    public RealmList<Senses> getSenses() {
        return senses;
    }

    public void setSenses(RealmList<Senses> senses) {
        this.senses = senses;
    }

}
