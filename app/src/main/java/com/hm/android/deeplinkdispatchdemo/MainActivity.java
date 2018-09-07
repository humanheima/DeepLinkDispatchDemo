package com.hm.android.deeplinkdispatchdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.airbnb.deeplinkdispatch.DeepLink;
import com.hm.android.deeplinkdispatchdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    private static final String ACTION_DEEP_LINK_METHOD = "deep_link_method";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Intent intent = getIntent();
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            Bundle parameters = intent.getExtras();
            Log.e(TAG, "Deeplink params: " + parameters);
            if (ACTION_DEEP_LINK_METHOD.equals(intent.getAction())) {
                if (parameters != null) {
                    binding.tvHelloWorld.setText(parameters.getString("qp"));
                }
            }
        }
    }

    @DeepLink("hm://methodDeepLink/{param1}")
    public static Intent intentForDeepLinkMethod(Context context) {
        return new Intent(context, MainActivity.class).setAction(ACTION_DEEP_LINK_METHOD);
    }

    @DeepLink("hm://methodDeepLink/extras")
    public static Intent intentForDeepLinkMethod(Context context, Bundle extras) {
        return new Intent(context, MainActivity.class).setAction(ACTION_DEEP_LINK_METHOD);
    }

}
