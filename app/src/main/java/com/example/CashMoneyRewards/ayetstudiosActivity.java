package com.example.CashMoneyRewards;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.ayetstudios.publishersdk.AyetSdk;
import com.ayetstudios.publishersdk.interfaces.NativeOffersCallback;
import com.ayetstudios.publishersdk.interfaces.UserBalanceCallback;
import com.ayetstudios.publishersdk.messages.SdkUserBalance;
import com.ayetstudios.publishersdk.models.NativeOfferList;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ayetstudiosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        AyetSdk.init( getApplication(), "username (external identifier)", new UserBalanceCallback() { // UserBalanceCallback is optional if you want to manage balances on your servers
            @Override
            public void userBalanceChanged(SdkUserBalance sdkUserBalance) {
                Log.d( "AyetSdk", "userBalanceChanged - available balance: " + sdkUserBalance.getAvailableBalance() ); // this is the new total available balance for the user
            }

            @Override
            public void userBalanceInitialized(SdkUserBalance sdkUserBalance) {
                Log.d( "AyetSdk", "SDK initialization successful" );
                Log.d( "AyetSdk", "userBalanceInitialized - available balance: " + sdkUserBalance.getAvailableBalance() ); // this is the total available balance for the user
                Log.d( "AyetSdk", "userBalanceInitialized - spent balance: " + sdkUserBalance.getSpentBalance() ); // this is the total amount spent with "AyetSdk.deductUserBalance(..)"
                Log.d( "AyetSdk", "userBalanceInitialized - pending balance: " + sdkUserBalance.getPendingBalance() ); // this is the amount currently pending for conversion (e.g. user still has offer requirements to meet)
            }

            @Override
            public void initializationFailed() {
                Log.d( "AyetSdk", "initializationFailed - please check APP API KEY & internet connectivity" );
            }
        } );

        setContentView( R.layout.activity_ayetstudios );

        if (AyetSdk.isInitialized()) {
            Log.d( "AyetSdk", "SDK is ready" );
        } else {
            Log.d( "AyetSdk", "SDK is NOT ready" );
        }
        AyetSdk.showOfferwall( getApplication(), "offerwall adslot name" );

        AyetSdk.getNativeOffers( getApplication(), "native adslot name", new NativeOffersCallback() {
            @Override
            public void onResult(boolean success, NativeOfferList responseMessage) {
                if (success) {
                    Log.e( "JSON Native Offers", new Gson().toJson( responseMessage.offers ) );
                }
            }
        } );

        String id; // the id of the offer, used in activateOffer call
        String name; // display name of the offer
        String icon; // url to the offer icon
        int category; // NativeOfferList.CATEGORY_INCENT | NativeOfferList.CATEGORY_NONINCENT
        int type; // NativeOfferList.TYPE_CPI | NativeOfferList.TYPE_CPA | NativeOfferList.TYPE_CPL
        String description; // a short description of the offer
        String instructions; // conversion instructions for the user
        int conversionTime; // average / estimated conversion time in seconds
        int payout; // the payout in the configured virtual currency
        ArrayList<NativeOfferList.AyetOffer.AyetCreative> creatives; // optional: additional creative data (images, videos) for the offer
    }
}
