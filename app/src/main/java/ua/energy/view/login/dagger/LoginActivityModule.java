package ua.energy.view.login.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.app.dagger.base.ActivityModule;
import ua.energy.model.StationModel;
import ua.energy.view.station.StationActivityPresenter;

@Module
public class LoginActivityModule implements ActivityModule {

    @Provides
    StationActivityPresenter provideStationActivityPresenter(StationModel stationModel){
        return new StationActivityPresenter(stationModel);
    }
}
