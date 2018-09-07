package com.hm.android.deeplinkdispatchdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.deeplinkdispatch.DeepLinkHandler;

@DeepLinkHandler({AppDeepLinkModule.class})
public class DeepLinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeepLinkDelegate deepLinkDelegate = new DeepLinkDelegate(new AppDeepLinkModuleLoader());
        deepLinkDelegate.dispatchFrom(this);
        finish();
    }
}
