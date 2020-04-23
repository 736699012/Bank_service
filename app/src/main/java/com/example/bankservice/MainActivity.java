package com.example.bankservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void normalClick(View view) {
        startActivity(new Intent(MainActivity.this,NormalActivity.class));
    }

    public void workerClick(View view) {
        startActivity(new Intent(MainActivity.this,BankWorkerActivity.class));
    }

    public void bossClick(View view) {
        startActivity(new Intent(MainActivity.this,BankBossActivity.class));
    }
}
