package com.example.CashMoneyRewards;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementVideoListener;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class offersActivity extends AppCompatActivity implements TJPlacementVideoListener, TJEarnedCurrencyListener {
    String TAG="FAILEDERR";
    private TJPlacement offerwallPlacement;
    TextView currancy;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String id;
    private RewardedAd mRewardedAd;
    ImageView tapjoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_offers );

        Tapjoy.setDebugEnabled(true);

        Intent intent = getIntent();
        id= intent.getStringExtra("user");

        /*AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, "ca-app-pub-8094329271100703/4514025463",
                adRequest, new RewardedAdLoadCallback(){
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        Log.d(TAG, loadAdError.getMessage());
                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                        Log.d(TAG, "onAdFailedToLoad");
                    }
                });
        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad was shown.");
                mRewardedAd = null;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                Log.d(TAG, "Ad failed to show.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Don't forget to set the ad reference to null so you
                // don't show the ad a second time.
                Log.d(TAG, "Ad was dismissed.");
            }
        });
        if (mRewardedAd != null) {
            Activity activityContext = MainActivity.this;
            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    // Handle the reward.
                    Log.d("TAG", "The user earned the reward.");
                    int rewardAmount = rewardItem.getAmount();
                    String rewardType = rewardItem.getType();
                }
            });
        } else {
            Log.d("TAG", "The rewarded ad wasn't ready yet.");
        }*/






        Hashtable<String, Object> connectFlags = new Hashtable<String, Object>();
        connectFlags.put(TapjoyConnectFlag.ENABLE_LOGGING, "true");
        Tapjoy.connect(this.getApplicationContext(), "shSl3YBXT02xWGvArhF9TQECXxKlyep0sOsw7d18LSZMbUy90ErYnS6MY-4o", connectFlags, new TJConnectListener() {
            @Override
            public void onConnectSuccess() {
                offersActivity.this.onConnectSuccess();
            }

            @Override
            public void onConnectFailure() {
                offersActivity.this.onConnectFail();
            }
        });




        Tapjoy.setEarnedCurrencyListener(this);



    }



    public void onConnectSuccess() {

        Tapjoy.setActivity(this);

    }

    /**
     * Handles a failed connect to Tapjoy
     */
    public void onConnectFail() {
        Log.e(TAG, "Tapjoy connect call failed");
        //updateTextInUI("Tapjoy connect failed!");
    }
    private void callShowOffers() {
        // NOTE: Current activity can be explicitly set via: Tapjoy.setActivity(this);
        //
        // This is needed before making a TJPlacement requestContent() if supported
        // minSdkVersion<14 and if Tapjoy session tracking is not used via: Tapjoy.onActivityStart(this);
        //
        Tapjoy.setActivity(this);

        // Construct TJPlacement to show Offers web view from where users can download the latest offers for virtual currency.
        offerwallPlacement = Tapjoy.getPlacement("offerwall_unit", new TJPlacementListener() {
            @Override
            public void onRequestSuccess(TJPlacement placement) {
                //updateTextInUI("onRequestSuccess for placement " + placement.getName());
                Log.v("PLACEGETNAME",placement.getName());

            /* if (!placement.isContentAvailable()) {
               //updateTextInUI("No Offerwall content available");
             }*/

                //setButtonEnabledInUI(currentButton, true);
            }

            @Override
            public void onRequestFailure(TJPlacement placement, TJError error) {
            /*setButtonEnabledInUI(currentButton, true);
            updateTextInUI("Offerwall error: " + error.message);*/
            }

            @Override
            public void onContentReady(TJPlacement placement) {
                TapjoyLog.i(TAG, "onContentReady for placement " + placement.getName());

                //updateTextInUI("Offerwall request success");
                placement.showContent();
            }

            @Override
            public void onContentShow(TJPlacement placement) {
                TapjoyLog.i(TAG, "onContentShow for placement " + placement.getName());
            }

            @Override
            public void onContentDismiss(TJPlacement placement) {
                TapjoyLog.i(TAG, "onContentDismiss for placement " + placement.getName());


            }

            @Override
            public void onPurchaseRequest(TJPlacement placement, TJActionRequest request, String productId) {

            }

            @Override
            public void onRewardRequest(TJPlacement placement, TJActionRequest request, String itemId, int quantity) {

            }

            @Override
            public void onClick(TJPlacement placement) {
                TapjoyLog.i(TAG, "onClick for placement " + placement.getName());
            }
        });

        // Add this class as a video listener
        offerwallPlacement.setVideoListener(this);
        offerwallPlacement.requestContent();

    }
    @Override
    protected void onStart() {
        super.onStart();

        Tapjoy.onActivityStart(this);

    }

    //session end
    @Override
    protected void onStop() {
        Tapjoy.onActivityStop(this);
        super.onStop();
    }

    @Override
    public void onVideoStart(TJPlacement tjPlacement) {

    }

    @Override
    public void onVideoError(TJPlacement tjPlacement, String s) {

    }

    @Override
    public void onVideoComplete(TJPlacement tjPlacement) {

    }

    @Override
    public void onEarnedCurrency(String s, int i) {
        Log.i("Tapjoy", "You've just earned " + i + " " +s);
        checkThedoc(i);

    }
    public void checkThedoc(int i){

        DocumentReference docRef = db.collection("users").document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());

                        updateDoc(i, (Long) document.getData().get("currency"));

                    } else {
                        Log.d(TAG, "No such document");
                        makeNewDoc(i);

                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());

                }
            }
        });
    }
    public void makeNewDoc(int i){
        Map<String, Object> data = new HashMap<>();
        data.put("currency", i);
        db.collection("users").document(id)
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }
    public void updateDoc(int i,Long s){
        Map<String, Object> data = new HashMap<>();
        data.put("currency", i+ Integer.parseInt(s.toString()));
        db.collection("users").document(id)
                .set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });

    }
    public void getthecurrency(){
        DocumentReference docRef = db.collection("users").document(id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        Long s=(Long) document.getData().get("currency");
                        currancy.setText("currency"+" "+s.toString());

                    } else {
                        Log.d(TAG, "No such document");
                        currancy.setText("currency"+"0");

                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());

                }
            }
        });
    }


    public void back(View view) {
        Intent intent = new Intent( offersActivity.this, MainActivity.class );
        startActivity( intent );
    }

    public void adgame(View view) {
        Intent intent = new Intent( offersActivity.this, adgameActivity.class );
        startActivity( intent );
    }
}