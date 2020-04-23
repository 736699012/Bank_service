package com.example.bankservice.impl;

import android.os.RemoteException;
import android.util.Log;

import com.example.binkservice.NormalUserAction;

public class NormalUserAIDLImpl extends NormalUserAction.Stub {

    private final static String TAG = "NormalUserAIDLImpl";
    @Override
    public void saveMoney(float money) {
        Log.d(TAG,"normal save money..."+money);
    }

    @Override
    public float getMoney() {
        Log.d(TAG,"normal get money1000...");
        return 0;
    }
}
