package com.example.bankservice.interfaces;

public interface IBankWorkAction extends INormalUserAction {

    //      查用户信用
    void checkUserCredit();
//    冻结用户账号
    void freezeUserAccount();
}
