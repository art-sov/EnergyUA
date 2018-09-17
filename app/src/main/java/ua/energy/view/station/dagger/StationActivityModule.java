package ua.energy.view.station.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.app.dagger.base.ActivityModule;
import ua.energy.model.StationModel;
import ua.energy.view.station.StationActivityPresenter;

@Module
public class StationActivityModule implements ActivityModule {

    @StationActivityScope
    @Provides
    StationActivityPresenter provideStationActivityPresenter(StationModel stationModel) {
        return new StationActivityPresenter(stationModel);
    }
}
