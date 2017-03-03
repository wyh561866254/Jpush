package com.example.acer.myobserble;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by acer on 2017/2/7.
 */

public class Serv extends Service{


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        MyBinder myBinder = new MyBinder();


        return myBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

     class MyBinder extends Binder {
        public Serv getMyServ(){

            return Serv.this;
        }


    }
}
