package com.example.zhihulibrary;


import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.baselibrary.BaseActivity;
import com.example.zhihulibrary.serice.FrontSerice;

//@RuntimePermissions
@Route(path = "/zhihu/activity")
public class ZhiHuMainActivity extends BaseActivity {
    private FrontSerice frontSerice = null;
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            frontSerice = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 获取服务上的IBinder对象，调用IBinder对象中定义的自定义方法，获取Service对象
            FrontSerice.LocalBinder binder = (FrontSerice.LocalBinder) service;
            frontSerice = binder.getService();
            frontSerice.setCallback(new FrontSerice.Callback() {
                @Override
                public void getStrign(String nnn) {
                    Log.e("FrontSerice", "getStrign: " + nnn);
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hu_main);
//        ZhiHuMainActivityPermissionsDispatcher
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(ZhiHuMainActivity.this, FrontSerice.class);
//                startService(startIntent);
                bindService(startIntent, mConnection, Service.BIND_AUTO_CREATE);

//                Intent intentService = new Intent(ZhiHuMainActivity.this, FrontIntentSerice.class);
//                startService(intentService);
//                start("/kotlin/main1");
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
//        Notification.Builder(this,"id")
    }

    public void onStop(View view) {
//        Intent stopIntent = new Intent(this, FrontSerice.class);
//        stopService(stopIntent);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initListener() {

    }

//    @NeedsPermission({Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
//    void need() {
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        ZhiHuMainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
//    }
}
