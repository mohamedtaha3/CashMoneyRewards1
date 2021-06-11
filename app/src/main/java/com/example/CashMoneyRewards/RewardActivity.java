package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.adsbase.StartAppSDK;

public class RewardActivity extends AppCompatActivity {

    CardView googleplay;
    CardView  paypal;
    CardView  pubgmobile;
    CardView  vodafone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_reward );

        StartAppSDK.init( this, "204897657", false );

        Banner banner = findViewById( R.id.banner );
        banner.loadAd();
        banner.showBanner();

        googleplay = findViewById( R.id.googleplay );
        paypal = findViewById( R.id.paypal );
        pubgmobile = findViewById( R.id.pubgmobile );
        vodafone = findViewById( R.id.vodafone );


        googleplay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RewardActivity.this, googleplay.class );
                startActivity( intent );
            }
        } );
        paypal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RewardActivity.this, paypal.class );
                startActivity( intent );
            }
        } );
        pubgmobile.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RewardActivity.this, pubgmobile.class );
                startActivity( intent );
            }
        } );

        vodafone.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RewardActivity.this, vodafonecash.class );
                startActivity( intent );
            }
        } );
    }
    public void back(View view) {
        Intent intent = new Intent( RewardActivity.this, MainActivity.class );
        startActivity( intent );
        }
    }