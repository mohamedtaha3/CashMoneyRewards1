package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class pubgmobile extends AppCompatActivity {

    CardView uc60;
    CardView uc340;
    CardView uc690;
    CardView uc1875;
    CardView uc4000;
    CardView uc8400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_pubgmobile );
        uc60 = findViewById( R.id.uc60 );
        uc340 = findViewById( R.id.uc340 );
        uc690 = findViewById( R.id.uc690 );
        uc1875 = findViewById( R.id.uc1875 );
        uc4000 = findViewById( R.id.uc4000 );
        uc8400 = findViewById( R.id.uc8400 );

        uc60.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( pubgmobile.this, pubgmobile_uc60.class );
                startActivity( intent );
            }
        } );
        uc340.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( pubgmobile.this, pubgmobile_uc340.class );
                startActivity( intent );
            }
        } );
        uc690.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( pubgmobile.this, pubgmobile_uc690.class );
                startActivity( intent );
            }
        } );
        uc1875.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( pubgmobile.this, pubgmobile_uc1875.class );
                startActivity( intent );
            }
        } );
        uc4000.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( pubgmobile.this, pubgmobile_uc4000.class );
                startActivity( intent );
            }
        } );
        uc8400.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( pubgmobile.this, pubgmobile_uc8400.class );
                startActivity( intent );
            }
        } );
    }

    public void back(View view) {
        Intent intent = new Intent( pubgmobile.this, RewardActivity.class );
        startActivity( intent );
    }
}