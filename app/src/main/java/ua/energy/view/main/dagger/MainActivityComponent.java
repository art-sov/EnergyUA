package ua.energy.view.main.dagger;

import dagger.Subcomponent;
import ua.energy.app.dagger.base.ActivityComponent;
import ua.energy.app.dagger.base.ActivityComponentBuilder;
import ua.energy.view.main.MainActivity;

@MainActivityScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent extends ActivityComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<MainActivityComponent, MainActivityModule> {

    }
}
