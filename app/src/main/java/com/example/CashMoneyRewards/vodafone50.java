package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class vodafone50 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vodafone50 );
    }

    public void back(View view) {
        Intent intent = new Intent( vodafone50.this, vodafonecash.class );
        startActivity( intent );
    }
}