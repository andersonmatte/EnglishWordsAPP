package me.andersonmatte.englishwords.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Word extends RealmObject implements Serializable {

    @SerializedName("results")
    @Expose
    private RealmList<Result> results;

    public RealmList<Result> getResults() {
        return results;
    }

    public void setResults(RealmList<Result> results) {
        this.results = results;
    }

}
