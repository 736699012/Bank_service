// NormalUserAction.aidl
package com.example.binkservice;

// Declare any non-default types here with import statements

interface NormalUserAction {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
     void  saveMoney(in float money);
     float getMoney();


}
