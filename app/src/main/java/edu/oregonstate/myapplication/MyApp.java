package edu.oregonstate.myapplication;

import android.app.Application;

/**
 * Created by sellersk on 7/13/2016.
 */
public class MyApp extends Application {

    private NetComponent mNetComponent;
    private String mBaseUrl = "https://api.github.com";

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(mBaseUrl))
                .build();

    }

    public NetComponent getNetComponent(){
        return mNetComponent;
    }
}
