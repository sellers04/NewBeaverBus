package edu.oregonstate.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sellersk on 7/8/2016.
 */
public interface OsuShuttleService {
    @GET("GetStops")
    Call<List<Stop>> getStops();

    @GET("GetMapVehiclePoints?ApiKey=8882812681")
    Call<List<VehiclePoint>> getMapVehiclePoints();
}
