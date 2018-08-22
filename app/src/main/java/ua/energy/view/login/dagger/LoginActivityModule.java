package ua.energy.view.login.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.presenter.LoginActivityPresenter;

@Module
public class LoginActivityModule {

    @LoginActivityScope
    @Provides
    LoginActivityPresenter provideLoginActivityPresenter(){
        return new LoginActivityPresenter();
    }
}
