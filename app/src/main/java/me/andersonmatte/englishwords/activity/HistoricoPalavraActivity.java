package me.andersonmatte.englishwords.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import io.realm.RealmResults;
import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.adapter.HistoricoPalavraAdapter;
import me.andersonmatte.englishwords.base.AppCompatActivityBase;
import me.andersonmatte.englishwords.entity.Palavra;

public class HistoricoPalavraActivity extends AppCompatActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_palavra);
        this.recuperarpalavras();
    }

    private void recuperarpalavras() {
        RealmResults<Palavra> palavrasRealmResults = this.realm.where(Palavra.class).findAllAsync();
        palavrasRealmResults.load();
        if (!palavrasRealmResults.isEmpty()) {
            this.populaListViewPalavras(palavrasRealmResults);
        }
    }

    //Popula a listView com as palavras do BD.
    public void populaListViewPalavras(List<Palavra> palavrasRecebidas) {
        ListView listView = (ListView) findViewById(R.id.listView);
        final HistoricoPalavraAdapter adapter = new HistoricoPalavraAdapter(this, palavrasRecebidas);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.realm.close();
    }

}
