package com.example.bankservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.Bundle;

import com.example.bankservice.sendService.BankBossService;
import com.example.bankservice.utils.Constant;

public class BankBossActivity extends AppCompatActivity {

    private boolean bindService;
    private ServiceConnection serviceConnection;
    private BankBossService bankBossService = new BankBossService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_boss);

        bankBossService.init(BankBossActivity.this,getWindow().getDecorView());
        bindService = bankBossService.bindBankService(Constant.BANKBOSS_ACTION);
        serviceConnection = bankBossService.mserviceConnection;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bindService && serviceConnection!=null){
            unbindService(serviceConnection);
            serviceConnection =null;
            bindService =false;
        }
    }
}
