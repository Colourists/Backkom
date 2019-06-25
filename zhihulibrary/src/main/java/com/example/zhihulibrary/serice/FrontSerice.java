package com.example.zhihulibrary.serice;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.zhihulibrary.R;

public class FrontSerice extends Service {
    public static final String TAG = "FrontSerice";
    public boolean is = false;
    public final IBinder mBinder = new LocalBinder();
    private Callback callback;

    public class LocalBinder extends Binder {
        // 在Binder中定义一个自定义的接口用于数据交互
        // 这里直接把当前的服务传回给宿主
        public FrontSerice getService() {
            return FrontSerice.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        is = true;
        post();
        return super.onStartCommand(intent, flags, startId);
    }

    private void post() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.getStrign("dsfsdfsd");
                Log.e(TAG, "onStartCommand: ");
                if (is) {
                    post();
                }
            }
        }, 1000);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e(TAG, "onStart: ");

        super.onStart(intent, startId);

    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: ");
        super.onCreate();
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");
        Log.e(TAG, "onStartCommand: ");

        is = true;
        post();
        not();
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        is = false;
        Log.e(TAG, "onDestroy: ");

    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public interface Callback {
        void getStrign(String nnn);
    }

    //Channel ID 必须保证唯一
    private static final String CHANNEL_ID = "com.appname.notification.channel";

    @TargetApi(Build.VERSION_CODES.O)
    private void not() {
        Notification noti = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//设定的通知渠道名称
            String channelName = "dssdd";
            //设置通知的重要程度
            int importance = NotificationManager.IMPORTANCE_LOW;
            //构建通知渠道
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);

            channel.setDescription("设置通知内容设置通知内容设置通知内容设置通知内容设置通知内容");
            //在创建的通知渠道上发送通知
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
            builder.setSmallIcon(R.drawable.ic_launcher_background) //设置通知图标
                    .setContentTitle("设置通知标题")//设置通知标题
                    .setContentText("设置通知内容")//设置通知内容
                    .setAutoCancel(true) //用户触摸时，自动关闭
                    .setOngoing(true)//设置处于运行状态
                    .setWhen(System.currentTimeMillis());
            //向系统注册通知渠道，注册后不能改变重要性以及其他通知行为
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
            //将服务置于启动状态 NOTIFICATION_ID指的是创建的通知的ID
            noti = builder.build();
        } else {
            noti = new Notification.Builder(getApplicationContext())
                    .setContentTitle("设置通知标题")
                    .setContentText("设置通知内容")
                    .setAutoCancel(true)
                    .setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .build();
        }

        startForeground(110, noti);
    }
}
