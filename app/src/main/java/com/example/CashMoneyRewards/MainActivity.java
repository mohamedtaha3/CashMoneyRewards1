package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.adsbase.StartAppSDK;

public class MainActivity extends AppCompatActivity {
    CardView profile;
    CardView video;
    CardView offers;
    CardView Reward;
    CardView support;
    CardView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        profile = findViewById( R.id.profile );
        video = findViewById( R.id.video );
        offers = findViewById( R.id.offers );
        Reward = findViewById( R.id.Reward );
        support = findViewById( R.id.support );
        logout = findViewById( R.id.logout );

        StartAppSDK.init( this, "204897657", false );

        Banner banner = findViewById( R.id.banner );
        banner.loadAd();
        banner.showBanner();

        profile.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, ProfileActivity.class );
                startActivity( intent );
            }
        } );
        video.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this, "Watch and win Loading...", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent( MainActivity.this, WatchActivity.class );
                startActivity( intent );
            }
        } );
        offers.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this, "offers Loading...", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent( MainActivity.this, offersActivity.class );
                startActivity( intent );
            }
        } );

        Reward.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this, "Reward Loading...", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent( MainActivity.this, RewardActivity.class );
                startActivity( intent );
            }
        } );
        support.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( MainActivity.this, "support Loading...", Toast.LENGTH_SHORT ).show();
                Intent intent = new Intent( MainActivity.this, supportActivity.class );
                startActivity( intent );
            }
        } );
        logout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();//logout
                startActivity( new Intent( getApplicationContext(), Login.class ) );
                finish();
            }
        } );
    }
}