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
import com.example.bankservice.interfaces.IBankBossAction;
import com.example.bankservice.interfaces.IBankWorkAction;

public class BankBossService extends BankWorkerService{

    private IBankBossAction bankBossAction;

    @Override
    public void init(Context context, View view) {
        super.init(context, view);
        Button nodifyUserAccountMoney = view.findViewById(R.id.nodifyUserAccountMoney);
        nodifyUserAccountMoney.setOnClickListener(this);
        super.serviceConnection = mserviceConnection;
    }
    public ServiceConnection mserviceConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bankBossAction = (IBankBossAction) service;
            Log.d("BankBossService","onServiceConnected...");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if(v.getId() == R.id.nodifyUserAccountMoney){
            nodifyUserAccountMoneyClick();
            Toast.makeText(v.getContext(),"你修改钱了",Toast.LENGTH_SHORT).show();
        }
    }

    public void nodifyUserAccountMoneyClick(){
        bankBossAction.nodifyUserAccountMoney(9999);
    }
}
