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
public class Notes extends RealmObject {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("type")
    @Expose
    private String type;

}
