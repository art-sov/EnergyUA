package ua.energy.app.dagger.dispatcher;

import dagger.Subcomponent;
import ua.energy.view.login.dagger.LoginActivityComponent;
import ua.energy.view.main.dagger.MainActivityComponent;
import ua.energy.view.station.dagger.StationActivityComponent;
import ua.energy.view.station.dagger.StationActivityModule;

@DispatcherScope
@Subcomponent(modules = {DispatcherModule.class})
public interface DispatcherComponent {

    StationActivityComponent createStationActivityComponent(StationActivityModule stationActivityModule);

    //MainActivityComponent createMainActivityComponent();

    //LoginActivityComponent createLoginActivityComponent();
}
