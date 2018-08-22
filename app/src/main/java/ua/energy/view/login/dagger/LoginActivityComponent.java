package ua.energy.view.login.dagger;

import dagger.Subcomponent;
import ua.energy.view.login.LoginActivity;

@Subcomponent(modules = LoginActivityModule.class)
public interface LoginActivityComponent {

    void inject(LoginActivity loginActivity);
}
