package me.andersonmatte.englishwords.api;

import me.andersonmatte.englishwords.entity.Word;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface OxfordDictionaryAPI {

    public static final Retrofit retrofit =  new Retrofit.Builder()
            .baseUrl("https://od-api.oxforddictionaries.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Headers({
            "app_id: 3505e876",
            "app_key: a3adb6d39bb99494e0bf3ea00db66b13"
    })
    @GET("/api/v1/entries/en/cat")
    Call<Word> getWord();

}
