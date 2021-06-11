package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.startapp.sdk.ads.banner.Banner;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.VideoListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

public class WatchActivity extends AppCompatActivity {
    TextView point;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate( state );
        setContentView( R.layout.activity_watch );

        point = findViewById( R.id.point );
    }

    public void showRewardedVideo(View view) {
        final StartAppAd rewardedVideo = new StartAppAd( this );

        rewardedVideo.setVideoListener( new VideoListener() {
            @Override
            public void onVideoCompleted() {
                Toast.makeText(getApplicationContext(), "Grant the reward to user", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( point.toString());
            }
        } );

        rewardedVideo.loadAd( StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
            @Override
            public void onReceiveAd(Ad ad) {
                rewardedVideo.showAd();
            }

            @Override
            public void onFailedToReceiveAd(Ad ad) {
                Toast.makeText( getApplicationContext(), "Can't show rewarded video", Toast.LENGTH_SHORT ).show();
            }
        } );

        StartAppSDK.init( this, "204897657", false );

        Banner banner = findViewById( R.id.banner );
        banner.loadAd();
        banner.showBanner();
    }

    public void back(View view) {
        Intent intent = new Intent( WatchActivity.this, MainActivity.class );
        startActivity( intent );
    }
}
