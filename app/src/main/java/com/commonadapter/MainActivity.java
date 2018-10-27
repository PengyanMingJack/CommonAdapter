package com.commonadapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.commonadapter.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = new MainViewModel(this);
        binding.setVariable(BR.model, mainViewModel);
        mainViewModel.afterCreate();
    }

}
