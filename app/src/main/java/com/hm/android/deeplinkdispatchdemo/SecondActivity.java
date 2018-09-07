package com.hm.android.deeplinkdispatchdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.deeplinkdispatch.DeepLink;
import com.hm.android.deeplinkdispatchdemo.databinding.ActivitySecondBinding;

/**
 * 可以匹配多个link
 */
@DeepLink({"hm://hm.com/deepLink/{id}", "hm://dmw.com/deepLink"})
public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        Intent intent = getIntent();
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            Bundle parameters = intent.getExtras();
            if (parameters != null) {
                String idString = parameters.getString("id");
                binding.tvHelloDeepLink.setText(idString);
            }
        }
    }
}
