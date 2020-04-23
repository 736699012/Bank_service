package com.example.bankservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ServiceConnection;
import android.os.Bundle;

import com.example.bankservice.sendService.BankWorkerService;
import com.example.bankservice.utils.Constant;

public class BankWorkerActivity extends AppCompatActivity {

    private boolean bindService;
    private ServiceConnection serviceConnection;
    private BankWorkerService bankWorkerService = new BankWorkerService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_worker);

        bankWorkerService.init(BankWorkerActivity.this,getWindow().getDecorView());
        bindService = bankWorkerService.bindBankService(Constant.BANKWORKER_ACTION);
        serviceConnection = bankWorkerService.mserviceConnection;
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
