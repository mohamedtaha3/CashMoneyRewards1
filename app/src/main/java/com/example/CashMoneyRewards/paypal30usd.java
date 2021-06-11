package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class paypal30usd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_paypal30usd );
    }

    public void back(View view) {
        Intent intent = new Intent( paypal30usd.this, paypal.class );
        startActivity( intent );
    }
}