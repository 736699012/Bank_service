package com.example.bankservice;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bankservice.sendService.NormalService;
import com.example.bankservice.utils.Constant;

public class NormalActivity extends AppCompatActivity {


    private static final String TAG = "NormalActivity";
    private boolean bindService;
    private ServiceConnection serviceConnection;
    private NormalService normalService = new NormalService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        normalService.init(NormalActivity.this,getWindow().getDecorView());
        Log.d(TAG,"初始化了");
        bindService = normalService.bindBankService(Constant.NORMALUSER_ACTION);
        serviceConnection =normalService.serviceConnection;


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bindService && serviceConnection!=null){
            unbindService(serviceConnection);
            serviceConnection =null;
            bindService =false;
            Log.d(TAG,"onServiceDisConnected******");
        }
    }
}
