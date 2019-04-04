package me.andersonmatte.englishwords.base;

import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

public class AppCompatActivityBase extends AppCompatActivity {

    protected Realm realm;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        this.criaBancoRealm();
    }

    public void criaBancoRealm() {
        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

}
