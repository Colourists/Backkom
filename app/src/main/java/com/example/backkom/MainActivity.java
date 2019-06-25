package com.example.backkom;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.BaseActivity;
import com.example.zhihulibrary.ZhiHuMainActivity;
import com.tinkerpatch.sdk.TinkerPatch;
@Route(path = "/main/main")
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void to(View view) {
        start("/zhihu/activity");
    }
}
