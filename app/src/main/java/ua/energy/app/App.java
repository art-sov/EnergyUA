package ua.energy.app;

import android.app.Application;
import android.content.Context;

import ua.energy.app.dagger.AppComponent;
import ua.energy.app.dagger.ComponentsHolder;

public class App extends Application {

    private ComponentsHolder mComponentsHolder;

    private AppComponent mAppComponent;

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mComponentsHolder = new ComponentsHolder(this);
        mComponentsHolder.init();

    }

    public ComponentsHolder getComponentsHolder() {
        return mComponentsHolder;
    }
}
