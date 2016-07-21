package edu.oregonstate.myapplication;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by sellersk on 7/12/2016.
 */
public class NetworkRequestor {
    private static final String TAG = "Network Requestor";

    @Inject
    Retrofit retrofit;

    OsuShuttleService service;

    @Inject
    public NetworkRequestor() {
        MyApp.getInstance().getNetComponent().inject(this);
        service = retrofit.create(OsuShuttleService.class);
    }


    private final static int INTERVAL = 1000 * 5; //5 seconds
    Handler mHandler = new Handler();

    Runnable mHandlerTask = new Runnable() {
        @Override
        public void run() {
            doSomething();
            mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    void startRepeatingTask(){
        mHandlerTask.run();
    }

    void stopRepeatingTask(){
        mHandler.removeCallbacks(mHandlerTask);
    }

    private void doSomething(){
        Call<List<VehiclePoint>> vehiclePoints = service.getMapVehiclePoints();

        vehiclePoints.enqueue(new Callback<List<VehiclePoint>>() {
            @Override
            public void onResponse(Call<List<VehiclePoint>> call, Response<List<VehiclePoint>> response) {
                Log.d(TAG, "SUCCESS, response: " + response.raw().toString()
                );
                List<VehiclePoint> list = response.body();
                for(int i = 0; i < list.size(); i++){
                    Log.d(TAG, "list[" + i +"] = " + list.get(i).toString());
                }
            }

            @Override
            public void onFailure(Call<List<VehiclePoint>> call, Throwable t) {
                Log.d(TAG, "FAILURE");
            }
        });


    }



}
