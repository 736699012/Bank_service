package com.example.bankservice.interfaces;

public interface INormalUserAction {
//   存款
    void saveMoney(float money);
//    取钱
    float getMoney();
//    贷款
    float loanMoney();
}
