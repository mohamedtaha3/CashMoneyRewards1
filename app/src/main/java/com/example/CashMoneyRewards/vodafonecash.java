package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class vodafonecash extends AppCompatActivity {
    CardView vodafone50;
    CardView vodafone100;
    CardView vodafone150;
    CardView vodafone200;
    CardView vodafone250;
    CardView vodafone300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vodafonecash );
        vodafone50 = findViewById( R.id.vodafone50 );
        vodafone100 = findViewById( R.id.vodafone100 );
        vodafone150 = findViewById( R.id.vodafone150 );
        vodafone200 = findViewById( R.id.vodafone200 );
        vodafone250 = findViewById( R.id.vodafone250 );
        vodafone300 = findViewById( R.id.vodafone300 );


        vodafone50.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( vodafonecash.this, vodafone50.class );
                startActivity( intent );
            }
        } );

        vodafone100.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( vodafonecash.this, vodafone100.class );
                startActivity( intent );
            }
        } );
        vodafone150.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( vodafonecash.this, vodafone150.class );
                startActivity( intent );
            }
        } );
        vodafone200.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( vodafonecash.this, vodafone200.class );
                startActivity( intent );
            }
        } );
        vodafone250.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( vodafonecash.this, vodafone250.class );
                startActivity( intent );
            }
        } );
        vodafone300.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( vodafonecash.this, vodafone300.class );
                startActivity( intent );
            }
        } );
    }
    public void back(View view) {
        Intent intent = new Intent( vodafonecash.this, RewardActivity.class );
        startActivity( intent );
    }
}