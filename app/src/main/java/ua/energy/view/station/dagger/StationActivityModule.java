package ua.energy.view.station.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.view.station.StationActivityPresenter;

@Module
public class StationActivityModule {

    @StationActivityScope
    @Provides
    StationActivityPresenter provideStationActivityPresenter(){
        return new StationActivityPresenter();
    }
}
