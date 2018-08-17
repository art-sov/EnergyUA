package ua.energy.app.dagger;

import android.content.Context;

import ua.energy.app.dagger.dispatcher.DispatcherComponent;
import ua.energy.app.dagger.dispatcher.DispatcherModule;
import ua.energy.view.station.dagger.StationActivityComponent;
import ua.energy.view.station.dagger.StationActivityModule;

public class ComponentsHolder {

    private final Context mContext;

    private  AppComponent mAppComponent;
    private DispatcherComponent mDispatcherComponent;
    private StationActivityComponent mStationActivityComponent;

    public ComponentsHolder (Context context) {
        mContext = context;
    }

    public void init() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(mContext)).build();
    }

    // AppComponent
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    //DispatcherComponent
    public DispatcherComponent getDispatcherComponent() {
        if (mDispatcherComponent == null) {
            mDispatcherComponent = mAppComponent.createDispatcherComponent(new DispatcherModule());
        }
        return mDispatcherComponent;
    }

    void releaseDispatcherComponent() {
        mDispatcherComponent = null;
    }

    //StationActivityComponent
    public StationActivityComponent getStationActivityComponent(){
        mStationActivityComponent = getDispatcherComponent().createStationActivityComponent(new StationActivityModule());
        return mStationActivityComponent;
    }

    public void releaseStationActivityComponent(){
        mStationActivityComponent = null;
    }

    //todo остальные компоненты
}
