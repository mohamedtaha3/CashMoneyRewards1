package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class pubgmobile_uc690 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pubgmobile_uc690 );
    }

    public void back(View view) {
        Intent intent = new Intent( pubgmobile_uc690.this, pubgmobile.class );
        startActivity( intent );
    }
}