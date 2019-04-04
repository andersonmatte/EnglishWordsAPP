package me.andersonmatte.englishwords.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pronunciations extends RealmObject {

    @SerializedName("audioFile")
    @Expose
    private String audioFile;

    @SerializedName("phoneticSpelling")
    @Expose
    private String phoneticSpelling;

}
