package ua.energy.app.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import ua.energy.app.App;

@Module
public class AppModule {

    private App mApp;
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
        mApp = App.getApp(mContext);
    }

    @Provides
    @AppScope
    public App provideApp(){
        return mApp;
    }

    @Provides
    @AppScope
    public Context provideContext() {
        return mContext;
    }

    @Provides
    @AppScope
    public SharedPreferences provideSharedPreferences(){
        SharedPreferences sharedPreferences = mApp.getSharedPreferences("dispatcher",
                Context.MODE_PRIVATE);
        return sharedPreferences;
    }
}
