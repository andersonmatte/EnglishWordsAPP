package me.andersonmatte.englishwords.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.base.AppCompatActivityBase;
import me.andersonmatte.englishwords.entity.Palavra;

public class HomeActivity extends AppCompatActivityBase {

    private AppCompatEditText editTextWord;
    private AppCompatEditText editTextTraducao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home);
        editTextWord = (AppCompatEditText) findViewById(R.id.editTextWord);
        editTextTraducao = (AppCompatEditText) findViewById(R.id.editTraducao);
        Button buttonSalvar = (Button) findViewById(R.id.botaoSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validaForm()) {
                    salvar();
                }
            }
        });
    }

    //Valida os campos na tela.
    private Boolean validaForm() {
        if (editTextWord.getText().toString().isEmpty()) {
            editTextWord.setError(getResources().getString(R.string.erro_wordInvalido));
            return false;
        } else if (editTextTraducao.getText().toString().isEmpty()) {
            editTextTraducao.setError(getResources().getString(R.string.erro_traducaoInvalido));
            return false;
        } else {
            return true;
        }
    }

    //Salva o objeto no Banco,
    public void salvar() {
        super.realm.beginTransaction();
        Palavra palavraSalvar = new Palavra();
        palavraSalvar.setConteudo(this.editTextWord.getText().toString());
        palavraSalvar.setTraducao(this.editTextTraducao.getText().toString());
        super.realm.insertOrUpdate(palavraSalvar);
        super.realm.commitTransaction();
        Toast toast = (Toast) Toast.makeText(getApplicationContext(), R.string.mensageSave, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL, 10, 10);
        toast.show();
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
