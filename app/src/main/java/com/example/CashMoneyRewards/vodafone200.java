package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class vodafone200 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vodafone200 );
    }

    public void back(View view) {
        Intent intent = new Intent( vodafone200.this, vodafonecash.class );
        startActivity( intent );
    }
}