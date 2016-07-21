package edu.oregonstate.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by sellersk on 7/13/2016.
 */
public class MyApp extends Application {

    private NetComponent mNetComponent;
    private static Context mContext;
    private String mBaseUrl = "http://www.osushuttles.com/Services/JSONPRelay.svc/";

    public static MyApp sInstance;
    public static MyApp getInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mContext = getApplicationContext();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(mBaseUrl))
                .build();

    }

    public NetComponent getNetComponent(){
        return mNetComponent;
    }

    public static Context getContext(){
        return mContext;
    }
}
