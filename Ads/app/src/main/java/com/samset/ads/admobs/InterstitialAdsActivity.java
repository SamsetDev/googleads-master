package com.samset.ads.admobs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.samset.ads.R;

public class InterstitialAdsActivity extends AppCompatActivity {

    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ads);
        interstitial = new InterstitialAd(InterstitialAdsActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getResources().getString(R.string.interstialads_unit_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        // Load ads into Interstitial Ads
        interstitial.loadAd(adRequest);
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
    }

    public void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}




