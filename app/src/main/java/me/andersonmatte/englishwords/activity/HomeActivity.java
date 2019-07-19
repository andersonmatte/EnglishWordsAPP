package me.andersonmatte.englishwords.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;

import java.io.Serializable;

import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.api.OxfordDictionaryAPI;
import me.andersonmatte.englishwords.base.AppCompatActivityBase;
import me.andersonmatte.englishwords.entity.Result;
import me.andersonmatte.englishwords.entity.Word;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static me.andersonmatte.englishwords.R.string.errorApi;

public class HomeActivity extends AppCompatActivityBase {

    private AppCompatEditText editTextWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home);
    }

  /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        editTextWord = (AppCompatEditText) findViewById(R.id.editTextWord);
        AppCompatButton buttonSearchWord = (AppCompatButton) findViewById(R.id.buttonSearchWord);
        buttonSearchWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validaForm()) {
                    OxfordDictionaryAPI oxfordDictionaryAPI = OxfordDictionaryAPI.retrofit.create(OxfordDictionaryAPI.class);
                    final Call<Word> callWord = oxfordDictionaryAPI.getWord(editTextWord.getText().toString());
                    callWord.enqueue(new Callback<Word>() {
                        @Override
                        public void onResponse(Call<Word> call, Response<Word> response) {
                            // Pega o retorno da API.
                            Word word = response.body();
                            //prepara o objeto para passar para a próxima activity.
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("resultado", (Serializable) word);
                            //Chama a Result já com o objeto populado.
                            Intent intentPerfil = new Intent(HomeActivity.this, Result.class);
                            intentPerfil.putExtra("endereco", bundle);
                            startActivity(intentPerfil);
                        }

                        @Override
                        public void onFailure(Call<Word> call, Throwable t) {
                            Log.i("ERRO", getResources().getString(R.string.errorApi) + t.getMessage());
                        }
                    });
                }
            }
        });
    }*/

   /* //Valida se o CEP foi preenchido.
    private Boolean validaForm() {
        if (editTextWord.getText().toString().isEmpty()) {
            editTextWord.setError(getResources().getString(R.string.errorWordEmpty));
            return false;
        } else {
            return true;
        }
    }*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

}
