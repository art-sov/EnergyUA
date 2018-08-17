package ua.energy.view.station.dagger;

import dagger.Subcomponent;
import ua.energy.view.station.StationActivity;

@StationActivityScope
@Subcomponent(modules = {StationActivityModule.class})
public interface StationActivityComponent {

    void injectStationActivity(StationActivity stationActivity);
}
