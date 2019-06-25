package com.example.baselibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.launcher.ARouter;

public abstract class BaseActivity extends AppCompatActivity implements NavigationCallback {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);

        initView();
    }

    public abstract void initView();

    public abstract void loadData();

    public abstract void initListener();

    public void start(String url) {
        // 使用两个参数的navigation方法，可以获取单次跳转的结果
        ARouter.getInstance().build(url).navigation(this, this);


    }

    public void start(String url, Bundle bundle) {
        Postcard build = ARouter.getInstance().build(url);
        build.with(bundle);
        build.navigation(this, this);
    }

    public void popToRoot() {
        ARouter.getInstance()
                .build("main/main")
                .navigation();
//        NavUtils.navigateUpTo();

    }

    //自定义参数 需要手动调用 .navigation(this, this)
    public Postcard startWith(String url) {
        Postcard build = ARouter.getInstance().build(url);
        return build;
    }

    //跳转成功返回
    @Override
    public void onFound(Postcard postcard) {

    }

    //找不到的时候回调
    @Override
    public void onLost(Postcard postcard) {

    }

    //跳转结束
    @Override
    public void onArrival(Postcard postcard) {

    }

    //被拦截
    @Override
    public void onInterrupt(Postcard postcard) {

    }
}
