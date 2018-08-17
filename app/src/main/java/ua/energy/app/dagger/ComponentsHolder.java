package ua.energy.app.dagger;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import ua.energy.app.dagger.dispatcher.DispatcherComponent;
import ua.energy.app.dagger.dispatcher.DispatcherModule;
import ua.energy.model.StationModel;
import ua.energy.service.ServiceGenerator;
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
    public StationActivityComponent getStationActivityComponent() {
        if (mStationActivityComponent == null){
            mStationActivityComponent = getDispatcherComponent()
                    .createStationActivityComponent(new StationActivityModule(new StationModel(new ServiceGenerator(new Retrofit.Builder(), new OkHttpClient.Builder()))));
        }
        return mStationActivityComponent;
    }

    public void releaseStationActivityComponent(){
        mStationActivityComponent = null;
    }

    //todo остальные компоненты
}
