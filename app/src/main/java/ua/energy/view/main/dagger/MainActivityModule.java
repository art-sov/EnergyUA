package ua.energy.view.main.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.view.main.MainActivityPresenter;

@Module
public class MainActivityModule {

    @MainActivityScope
    @Provides
    MainActivityPresenter provideMainActivityPresenter() {
        return new MainActivityPresenter();
    }
}
