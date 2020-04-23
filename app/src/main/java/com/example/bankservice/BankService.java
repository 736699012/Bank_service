package com.example.bankservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.example.bankservice.impl.BankBossImpl;
import com.example.bankservice.impl.BankWorkImpl;
import com.example.bankservice.impl.NormalUserImpl;
import com.example.bankservice.utils.Constant;

public class BankService extends Service {
    /**
     * @param intent
     * @return 根据Action 返回相应的binder对象
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        if(!TextUtils.isEmpty(action)){
            switch (action){
                case Constant.NORMALUSER_ACTION:
                    return new NormalUserImpl();
                case Constant.BANKWORKER_ACTION:
                    return new BankWorkImpl();
                case Constant.BANKBOSS_ACTION:
                    return new BankBossImpl();
            }
        }
        return null;
    }
}
