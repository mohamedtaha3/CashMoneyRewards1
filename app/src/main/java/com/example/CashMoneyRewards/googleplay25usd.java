package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class googleplay25usd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_googleplay25usd );
    }

    public void back(View view) {
        Intent intent = new Intent( googleplay25usd.this, googleplay.class );
        startActivity( intent );
    }
}