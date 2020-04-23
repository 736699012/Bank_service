package com.example.bankservice.sendService;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bankservice.R;
import com.example.bankservice.interfaces.INormalUserAction;

public class NormalService implements View.OnClickListener{
    private static final String TAG = "NormalService";
    protected boolean bindService;
    private Context context;

    public void init (Context context,View view){
        this.context = context;
        Button saveMoney = view.findViewById(R.id.saveMoney);
        saveMoney.setOnClickListener(NormalService.this);
        Button getMoney = view.findViewById(R.id.getMoney);
        getMoney.setOnClickListener(NormalService.this);
        Button loanMoney = view.findViewById(R.id.loanMoney);
        loanMoney.setOnClickListener(NormalService.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveMoney:
                saveMoneyClick();
                Toast.makeText(v.getContext(),"你存钱了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.getMoney:
                getMoneyClick();
                Toast.makeText(v.getContext(),"你取钱了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.loanMoney:
                loanMoneyClick();
                Toast.makeText(v.getContext(),"你贷款了",Toast.LENGTH_SHORT).show();
                break;
        }
    }



    public ServiceConnection serviceConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            userAction = (INormalUserAction) service;
            Log.d("NormalService","onServiceConnected...");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    protected INormalUserAction userAction;

    public boolean bindBankService(String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage(context.getPackageName());
        Log.d("NormalService","onBinder");
        bindService = context.bindService(intent, serviceConnection, context.BIND_AUTO_CREATE);
        Log.d("NormalService","bindService=="+bindService);
        return bindService;
    }

    public void saveMoneyClick(){
        userAction.saveMoney(10000);

    }

    public void getMoneyClick()  {
        userAction.getMoney();
    }
    public void loanMoneyClick()  {
        userAction.loanMoney();
    }


}
