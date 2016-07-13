package edu.oregonstate.myapplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sellersk on 7/13/2016.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MapsActivity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);

}
