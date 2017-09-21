package com.dotalist.dalviik.dota2heroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void heroes(View v){
        Intent i = new Intent(getApplicationContext(),HeroesActivity.class);
        startActivity(i);
    }
    public void items(View v){
        Intent i = new Intent(getApplicationContext(),ItemsActivity.class);
        startActivity(i);
    }
}
