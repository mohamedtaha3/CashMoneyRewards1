package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class paypal20usd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_paypal20usd );
    }

    public void back(View view) {
        Intent intent = new Intent( paypal20usd.this, paypal.class );
        startActivity( intent );
    }
}