package com.example.bankservice.sendService;


import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bankservice.R;
import com.example.bankservice.interfaces.IBankWorkAction;

public class BankWorkerService extends NormalService {

    public IBankWorkAction bankWorkAction ;

    @Override
    public void init(Context context, View view) {
        super.init(context, view);
        Button checkUserCredit = view.findViewById(R.id.checkUserCredit);
        checkUserCredit.setOnClickListener(this);
        Button freezeUserAccount = view.findViewById(R.id.freezeUserAccount);
        freezeUserAccount.setOnClickListener(this);
        super.serviceConnection = mserviceConnection;
    }

    public ServiceConnection mserviceConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bankWorkAction = (IBankWorkAction) service;
            Log.d("BankWorkerService","onServiceConnected...");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };



    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.checkUserCredit:
                checkUserCreditClick();
                Toast.makeText(v.getContext(),"你的信用分为780",Toast.LENGTH_SHORT).show();
                break;
            case R.id.freezeUserAccount:
                freezeUserAccountClick();
                Toast.makeText(v.getContext(),"你的账号被冻结",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void checkUserCreditClick() {
        bankWorkAction.checkUserCredit();
    }

    public void freezeUserAccountClick() {
        bankWorkAction.freezeUserAccount();
    }
}
