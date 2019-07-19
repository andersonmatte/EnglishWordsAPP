package me.andersonmatte.englishwords.base;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import io.realm.Realm;
import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.activity.DescobrirPalavrasActivity;
import me.andersonmatte.englishwords.activity.HistoricoPalavraActivity;
import me.andersonmatte.englishwords.activity.SobreActivity;
import me.andersonmatte.englishwords.activity.TreinarPalavrasActivity;

public class AppCompatActivityBase extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected Realm realm;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView navigationView;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        this.criaBancoRealm();
        this.onCreateDrawer();
    }

    protected void onCreateDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.abrir, R.string.fechar);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Botao voltar com suporte bread crumb.
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle != null && mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_historico:
                Intent a = new Intent(AppCompatActivityBase.this, HistoricoPalavraActivity.class);
                startActivity(a);
                break;
            case R.id.nav_treinar:
                Intent b = new Intent(AppCompatActivityBase.this, TreinarPalavrasActivity.class);
                startActivity(b);
                break;
            case R.id.nav_descobrir:
                Intent c = new Intent(AppCompatActivityBase.this, DescobrirPalavrasActivity.class);
                startActivity(c);
                break;
            case R.id.nav_sobre:
                Intent d = new Intent(AppCompatActivityBase.this, SobreActivity.class);
                startActivity(d);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void criaBancoRealm() {
        Realm.init(this);
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
