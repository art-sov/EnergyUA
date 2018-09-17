package ua.energy.view.login.dagger;

import dagger.Subcomponent;
import ua.energy.app.dagger.base.ActivityComponent;
import ua.energy.app.dagger.base.ActivityComponentBuilder;
import ua.energy.view.login.LoginActivity;

@Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent extends ActivityComponent<LoginActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<LoginActivityComponent, LoginActivityModule>{

    }

}
