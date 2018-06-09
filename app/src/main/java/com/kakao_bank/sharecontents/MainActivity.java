package com.kakao_bank.sharecontents;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kakao_bank.sharecontents.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setHandler(new Handler());
    }

    public class Handler {
        public void shareButtonClicked() {
            ContentShareDialog dialog = new ContentShareDialog();
            dialog.show(getFragmentManager(), "");
        }
    }
    //merge test
}
