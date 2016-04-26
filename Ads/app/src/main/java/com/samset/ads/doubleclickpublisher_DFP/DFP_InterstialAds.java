package com.samset.ads.doubleclickpublisher_DFP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.samset.ads.R;

public class DFP_InterstialAds extends AppCompatActivity {
    private PublisherInterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfp__interstial_ads);

        mInterstitialAd = new PublisherInterstitialAd(this);
        // Defined in res/values/strings.xml
        mInterstitialAd.setAdUnitId(getString(R.string.dfp_interstialads_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                displayInterstitial();
            }

            @Override
            public void onAdLoaded() {
                Log.e("DFP"," AdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("DFP"," AdFailedToLoad");
            }
        });

        PublisherAdRequest adRequest = new PublisherAdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

    }
    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
