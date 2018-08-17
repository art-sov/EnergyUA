package ua.energy.app.dagger.dispatcher;

import dagger.Module;
import dagger.Provides;
import ua.energy.model.StationModel;
import ua.energy.service.ServiceGenerator;


@Module
public class DispatcherModule {

    @Provides
    @DispatcherScope
    StationModel provideStationModel(ServiceGenerator serviceGenerator) {
        return new StationModel(serviceGenerator);
    }
}
