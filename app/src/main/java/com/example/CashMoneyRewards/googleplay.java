package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.adsbase.StartAppSDK;

public class googleplay extends AppCompatActivity {

    CardView googleplay10usd;
    CardView googleplay25usd;
    CardView googleplay50usd;
    CardView googleplay100usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_googleplay );

        googleplay10usd = findViewById( R.id.googleplay10usd );
        googleplay25usd = findViewById( R.id.googleplay25usd );
        googleplay50usd = findViewById( R.id.googleplay50usd );
        googleplay100usd = findViewById( R.id.googleplay100usd );


        StartAppSDK.init( this, "204897657", false );

        Banner banner = findViewById( R.id.banner );
        banner.loadAd();
        banner.showBanner();


        googleplay10usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( googleplay.this, googleplay10usd.class );
                startActivity( intent );
            }
        } );
        googleplay25usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( googleplay.this, googleplay25usd.class );
                startActivity( intent );
            }
        } );
        googleplay50usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( googleplay.this, googleplay50usd.class );
                startActivity( intent );
            }
        } );
        googleplay100usd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( googleplay.this, googleplay100usd.class );
                startActivity( intent );
            }
        } );
    }
    public void back(View view) {
        Intent intent = new Intent( googleplay.this, RewardActivity.class );
        startActivity( intent );

    }

}