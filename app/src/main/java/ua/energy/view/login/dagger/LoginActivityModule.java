package ua.energy.view.login.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.model.StationModel;
import ua.energy.view.station.StationActivityPresenter;

@Module
public class LoginActivityModule {

    @Provides
    StationActivityPresenter provideStationActivityPresenter(StationModel stationModel){
        return new StationActivityPresenter(stationModel);
    }
}
