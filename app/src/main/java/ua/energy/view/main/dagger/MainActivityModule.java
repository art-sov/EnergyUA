package ua.energy.view.main.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.app.dagger.base.ActivityModule;
import ua.energy.view.main.MainActivityPresenter;

@Module
public class MainActivityModule implements ActivityModule{

    @MainActivityScope
    @Provides
    MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenter();
    }
}
