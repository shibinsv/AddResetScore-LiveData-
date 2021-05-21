package com.example.addandresetscoreusinglivedata;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyApplication extends Application implements LifecycleObserver {

    private static MyApplication mApplicationInstance;
    private static Context context;

    public static MyApplication getInstance() {
        return mApplicationInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationInstance = this;

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBAckgrounded(){
        Log.e("MyApp", "Going into background");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppForegrounde(){
        Log.e("MyApp", "Resumed");

    }

    private static class AppLifecycleTracker implements ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }


        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }


        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }


        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }


        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }


        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }


        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    }
}
