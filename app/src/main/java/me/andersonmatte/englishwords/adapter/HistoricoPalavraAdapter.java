package me.andersonmatte.englishwords.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.entity.Palavra;

public class HistoricoPalavraAdapter extends ArrayAdapter<Palavra> {

    private List<Palavra> palavras;
    private Context context;

    public HistoricoPalavraAdapter(Context context, List<Palavra> palavrasRecebido) {
        super(context, 0, palavrasRecebido);
        this.palavras = palavrasRecebido;
        this.context = context;
    }

    @NonNull
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(final int position, View view, @NonNull ViewGroup parent) {
        view = LayoutInflater.from(this.context).inflate(R.layout.lista_historico_palavra, null);
        //Aqui ocorre a mágica no setTag onde é passado a posição da ListView!
        view.setTag(position);
        if (this.palavras.get(position) != null) {
            TextView textViewPalavra = (TextView) view.findViewById(R.id.palavra);
            textViewPalavra.setText(this.palavras.get(position).getConteudo() != null ? this.palavras.get(position).getConteudo() : "");
            TextView textViewTraducao = (TextView) view.findViewById(R.id.traducao);
            textViewTraducao.setText(this.palavras.get(position).getTraducao() != null ? this.palavras.get(position).getTraducao() : "");
        }
        return view;
    }

}
