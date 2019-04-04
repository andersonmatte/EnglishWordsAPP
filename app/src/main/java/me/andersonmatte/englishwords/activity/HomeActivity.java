package me.andersonmatte.englishwords.activity;

import android.content.Intent;
import android.os.Bundle;

import me.andersonmatte.englishwords.R;
import me.andersonmatte.englishwords.base.AppCompatActivityBase;

public class HomeActivity extends AppCompatActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

}
