package com.example.backkom;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.baselibrary.BaseApp;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;
import com.tinkerpatch.sdk.server.callback.ConfigRequestCallback;

import java.util.HashMap;
import java.util.logging.Handler;

public class MyAPP extends BaseApp {

    private ApplicationLike tinkerApplicationLike;

    @Override
    public void onCreate() {
        super.onCreate();

//        // 我们可以从这里获得Tinker加载过程的信息
//        tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
//
//        // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
//        TinkerPatch.init(tinkerApplicationLike)
//                .reflectPatchLibrary()
//                .setPatchRollbackOnScreenOff(true)
//                .setPatchRestartOnSrceenOff(true)
//                .setFetchPatchIntervalByHours(3);
//
//        // 每隔3个小时(通过setFetchPatchIntervalByHours设置)去访问后台时候有更新,通过handler实现轮训的效果
//
//        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval()
//                .fetchDynamicConfig(new ConfigRequestCallback() {
//                    @Override
//                    public void onSuccess(HashMap<String, String> hashMap) {
////                        Log.e("TAG", "onSuccess: "+001 );
//                    }
//
//                    @Override
//                    public void onFail(Exception e) {
////                        Log.e("TAG", "onFail: "+001 );
//
////                        Toast.makeText(getApplicationContext(), "2ss22sss ", Toast.LENGTH_LONG).show();
//
//                    }
//                }, true);

    }
}
