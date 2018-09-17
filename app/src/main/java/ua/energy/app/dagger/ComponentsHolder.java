package ua.energy.app.dagger;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import ua.energy.app.dagger.base.ActivityComponent;
import ua.energy.app.dagger.base.ActivityComponentBuilder;
import ua.energy.app.dagger.base.ActivityModule;
import ua.energy.app.dagger.dispatcher.DispatcherComponent;
import ua.energy.app.dagger.dispatcher.DispatcherModule;

public class ComponentsHolder {

    private final Context mContext;

    private AppComponent mAppComponent;
    private DispatcherComponent mDispatcherComponent;

    @Inject
    Map<Class<?>, Provider<ActivityComponentBuilder>> builders;

    private Map<Class<?>, ActivityComponent> components;

    public ComponentsHolder (Context context) {
        mContext = context;
    }

    public void init() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(mContext)).build();
        getDispatcherComponent().injectComponentsHolder(this);
        components = new HashMap<>();
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

    public ActivityComponent getActivityComponent(Class<?> cls) {
        return getActivityComponent(cls, null);
    }

    public ActivityComponent getActivityComponent(Class<?> cls, ActivityModule module){

        ActivityComponent component = components.get(cls);

        if (component == null) {
            ActivityComponentBuilder builder = builders.get(cls).get();
            if (module != null) {
                builder.module(module);
            }
            component = builder.build();
            components.put(cls, component);
        }
        return component;
    }

    public void releaseActivityComponent(Class<?> cls) {
        components.put(cls, null);
    }
}
