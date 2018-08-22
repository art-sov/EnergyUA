package ua.energy.view.main.dagger;

import dagger.Subcomponent;
import ua.energy.view.main.MainActivity;

@MainActivityScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent  {

    void inject(MainActivity mainActivity);

}
