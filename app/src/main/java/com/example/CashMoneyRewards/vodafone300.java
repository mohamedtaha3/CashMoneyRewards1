package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class vodafone300 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vodafone300 );
    }

    public void back(View view) {
        Intent intent = new Intent( vodafone300.this, vodafonecash.class );
        startActivity( intent );
    }
}