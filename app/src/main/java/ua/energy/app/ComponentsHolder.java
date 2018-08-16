package ua.energy.app;

import android.content.Context;
import ua.energy.app.dagger.DaggerAppComponent;
import ua.energy.app.dagger.AppComponent;
import ua.energy.app.dagger.AppModule;
import ua.energy.view.main.dagger.MainActivityComponent;
import ua.energy.view.station.dagger.StationActivityComponent;

public class ComponentsHolder {

    private final Context mContext;
    private MainActivityComponent mMainActivityComponent;
    private StationActivityComponent mStationActivityComponent;

    private AppComponent mAppComponent;

    public ComponentsHolder(Context context) {
        mContext = context;
    }

    void init() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(mContext)).build();
    }


    // AppComponent
    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    // MainActivityComponent
    public MainActivityComponent getMainActivityComponent (){
        if (mMainActivityComponent == null) {
            mMainActivityComponent = getAppComponent().createMainActivityComponent();
        }
        return mMainActivityComponent;
    }

    public void releaseMainActivityComponent() {
        mMainActivityComponent = null;
    }

    //StationActivityComponent
    public StationActivityComponent getStetionActivityComponent () {
        if (mStationActivityComponent == null) {
            mStationActivityComponent = getAppComponent().createStationActivityComponent();
        }
        return mStationActivityComponent;
    }

    public void releaseStationActivityComponent(){
        mStationActivityComponent = null;
    }
}
