package com.samset.ads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.samset.ads.admobs.AppInstallAds_Activity;
import com.samset.ads.admobs.BannerAdsActivity;
import com.samset.ads.admobs.InterstitialAdsActivity;
import com.samset.ads.admobs.RequestContentAds_Activity;
import com.samset.ads.admobs.RewardVideoAds_Activity;
import com.samset.ads.doubleclickpublisher_DFP.DFP_BannerActivity;
import com.samset.ads.doubleclickpublisher_DFP.DFP_InterstialAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PublisherAdView mAdView,mAdView1,mAdView2;
    Button btnBanner,btnInterstial,btnappInstall,btnRequestAds,btnRewardVideo,dfp_btnbanner,dfp_btnInterstial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBanner=(Button)findViewById(R.id.banner);
        btnInterstial=(Button)findViewById(R.id.inters);
        btnRewardVideo=(Button)findViewById(R.id.rewardvideo);
        btnRequestAds=(Button)findViewById(R.id.requestcontent);
        btnappInstall=(Button)findViewById(R.id.appinstall);

        dfp_btnbanner=(Button)findViewById(R.id.dfp_banner);
        dfp_btnInterstial=(Button)findViewById(R.id.dfp_inters);

        btnBanner.setOnClickListener(this);
        btnInterstial.setOnClickListener(this);
        btnRewardVideo.setOnClickListener(this);
        btnRequestAds.setOnClickListener(this);
        btnappInstall.setOnClickListener(this);

        dfp_btnbanner.setOnClickListener(this);
        dfp_btnInterstial.setOnClickListener(this);

       /* PublisherAdView adView = new PublisherAdView(this);
        adView.setAdUnitId(getResources().getString(R.string.listing_second));
        adView.setAdSizes(AdSize.BANNER);
        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        layout.addView(adView);
        PublisherAdRequest request = new PublisherAdRequest.Builder().build();
        adView.loadAd(request);*/
    }



    /** Called when the refresh button is clicked. */
    public void refreshAd(View unusedView) {
        if (mAdView != null) {
            mAdView.loadAd(new PublisherAdRequest.Builder().build());
        }
    }

    @Override
    public void onClick(View v)
    {
        int id=v.getId();

        switch (id)
        {
            case R.id.banner:
               startActivity(new Intent(MainActivity.this, BannerAdsActivity.class));
                break;
            case R.id.inters:
                startActivity(new Intent(MainActivity.this, InterstitialAdsActivity.class));
                break;
            case R.id.rewardvideo:
                startActivity(new Intent(MainActivity.this, RewardVideoAds_Activity.class));
                break;
            case R.id.requestcontent:
                startActivity(new Intent(MainActivity.this, RequestContentAds_Activity.class));
                break;
            case R.id.appinstall:
                startActivity(new Intent(MainActivity.this, AppInstallAds_Activity.class));
                break;


            case R.id.dfp_banner:
                startActivity(new Intent(MainActivity.this, DFP_BannerActivity.class));
                break;
            case R.id.dfp_inters:
                startActivity(new Intent(MainActivity.this, DFP_InterstialAds.class));
                break;


        }

    }
}
