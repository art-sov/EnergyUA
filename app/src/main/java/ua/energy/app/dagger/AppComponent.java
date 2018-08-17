package ua.energy.app.dagger;

import dagger.Component;
import ua.energy.app.dagger.dispatcher.DispatcherComponent;
import ua.energy.app.dagger.dispatcher.DispatcherModule;
import ua.energy.service.dagger.ApiModule;

@AppScope
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    DispatcherComponent createDispatcherComponent(DispatcherModule dispatcherModule);
}
