package ua.energy.app.dagger;

import dagger.Component;
import ua.energy.view.main.dagger.MainActivityComponent;
import ua.energy.view.station.dagger.StationActivityComponent;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    //todo создание сабкомпонентов для активити

    MainActivityComponent createMainActivityComponent();
    StationActivityComponent createStationActivityComponent();
}
