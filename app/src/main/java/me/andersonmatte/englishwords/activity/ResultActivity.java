package me.andersonmatte.englishwords.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.entity.Word;

public class ResultActivity extends AppCompatActivity {

    private AppCompatTextView firstResult;
    private Word wordReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Recebe os dados passados na Intent da Classe HomeActivity por mecanismo de Bundle.
        Bundle bundle = getIntent().getBundleExtra("word");
        if (bundle != null) {
            this.wordReceived = (Word) bundle.getSerializable("resultado");
            this.firstResult.setText("teste");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

}
