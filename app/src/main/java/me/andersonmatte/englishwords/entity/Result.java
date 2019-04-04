package me.andersonmatte.englishwords.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result extends RealmObject {


    @SerializedName("lexicalEntries")
    @Expose
    private List<LexicalEntries> lexicalEntries;

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

}
