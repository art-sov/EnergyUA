package ua.energy.view.station.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.app.dagger.dispatcher.DispatcherScope;
import ua.energy.model.StationModel;
import ua.energy.view.station.StationActivityPresenter;

@Module
public class StationActivityModule {

    private StationModel mStationModel;

    public StationActivityModule(StationModel stationModel) {
        mStationModel = stationModel;
    }

    @StationActivityScope
    @Provides
    StationActivityPresenter provideStationActivityPresenter() {
        return new StationActivityPresenter(mStationModel);
    }
}
