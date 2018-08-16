package ua.energy.app.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context mContext;

    public AppModule (Context context) {
        mContext = context;
    }

    @AppScope
    @Provides
    Context provideContext() {
        return mContext;
    }
}
