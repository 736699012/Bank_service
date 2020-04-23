package com.example.bankservice.impl;

import android.os.Binder;
import android.util.Log;

import com.example.bankservice.interfaces.IBankBossAction;

public class BankBossImpl extends Binder implements IBankBossAction {
    private static final String TAG = "BankBossImpl";

    @Override
    public void nodifyUserAccountMoney(float money) {
        Log.d(TAG,"nodifyUserAccountMoney  更改钱为"+money);
    }

    @Override
    public void checkUserCredit() {
        Log.d(TAG,"checkUserCredit ==  790");
    }

    @Override
    public void freezeUserAccount() {
        Log.d(TAG,"freezeUserAccount ==  0");
    }

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
