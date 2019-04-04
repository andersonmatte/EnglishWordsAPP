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
public class Senses extends RealmObject {

    @SerializedName("notes")
    @Expose
    private List<Notes> notes;

    @SerializedName("definitions")
    @Expose
    private List<String> definitions;

}
