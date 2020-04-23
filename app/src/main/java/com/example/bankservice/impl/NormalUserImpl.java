package com.example.bankservice.impl;

import android.os.Binder;
import android.util.Log;

import com.example.bankservice.interfaces.INormalUserAction;

public class NormalUserImpl extends Binder implements INormalUserAction {
    private static final String TAG = "NormalUserImpl";

    @Override
    public void saveMoney(float money) {
        Log.d(TAG,"存入"+money+"RMB");
    }

    @Override
    public float getMoney() {
        Log.d(TAG,"取出100RMB");
        return 100;
    }

    @Override
    public float loanMoney() {
        Log.d(TAG,"贷款100RMB");
        return 1000;
    }
}
