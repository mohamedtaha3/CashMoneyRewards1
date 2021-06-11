package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.adsbase.StartAppSDK;

public class paypal extends AppCompatActivity {

    CardView paypal5usd;
    CardView paypal10usd;
    CardView paypal20usd;
    CardView paypal30usd;
    CardView paypal40usd;
    CardView paypal50usd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_paypal );
        paypal5usd = findViewById( R.id.paypal5usd );
        paypal10usd = findViewById( R.id.paypal10usd );
        paypal20usd = findViewById( R.id.paypal20usd );
        paypal30usd = findViewById( R.id.paypal30usd );
        paypal40usd = findViewById( R.id.paypal40usd );
        paypal50usd = findViewById( R.id.paypal50usd );


        StartAppSDK.init( this, "204897657", false );

        Banner banner = findViewById( R.id.banner );
        banner.loadAd();
        banner.showBanner();


        paypal5usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( paypal.this, paypal5usd.class );
                startActivity( intent );
            }
        } );

        paypal10usd.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent( paypal.this, paypal10usd.class );
            startActivity( intent );
        }
    } );

        paypal20usd.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent( paypal.this, paypal20usd.class );
            startActivity( intent );
        }
    } );

        paypal30usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( paypal.this, paypal30usd.class );
                startActivity( intent );
            }
        } );

        paypal40usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( paypal.this, paypal40usd.class );
                startActivity( intent );
            }
        } );

        paypal50usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( paypal.this, paypal50usd.class );
                startActivity( intent );
            }
        } );
    }
    public void back(View view) {
        Intent intent = new Intent( paypal.this, RewardActivity.class );
        startActivity( intent );
    }
}