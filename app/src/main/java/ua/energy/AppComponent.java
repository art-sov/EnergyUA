package ua.energy;

import javax.inject.Singleton;

import dagger.Component;
import ua.energy.api.ApiModule;

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

}
