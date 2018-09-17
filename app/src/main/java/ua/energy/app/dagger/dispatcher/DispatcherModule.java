package ua.energy.app.dagger.dispatcher;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import ua.energy.app.dagger.base.ActivityComponentBuilder;
import ua.energy.model.StationModel;
import ua.energy.service.ServiceGenerator;
import ua.energy.view.consolidate.ConsolidateActivity;
import ua.energy.view.consolidate.dagger.ConsolidateActivityComponent;
import ua.energy.view.login.LoginActivity;
import ua.energy.view.login.dagger.LoginActivityComponent;
import ua.energy.view.main.MainActivity;
import ua.energy.view.main.dagger.MainActivityComponent;
import ua.energy.view.station.StationActivity;
import ua.energy.view.station.dagger.StationActivityComponent;


@Module(subcomponents = {StationActivityComponent.class,
                         ConsolidateActivityComponent.class,
                            MainActivityComponent.class,
                            LoginActivityComponent.class})
public class DispatcherModule {

    @Provides
    @DispatcherScope
    StationModel provideStationModel(ServiceGenerator serviceGenerator) {
        return new StationModel(serviceGenerator);
    }

    @Provides
    @IntoMap
    @ClassKey(StationActivity.class)
    ActivityComponentBuilder provideStationActivityBuilder(StationActivityComponent.Builder builder) {
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(ConsolidateActivity.class)
    ActivityComponentBuilder provideConsolidateActivityBuilder(ConsolidateActivityComponent.Builder builder) {
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(MainActivity.class)
    ActivityComponentBuilder provideMainActivityBuilder(MainActivityComponent.Builder builder) {
        return builder;
    }

    @Provides
    @IntoMap
    @ClassKey(LoginActivity.class)
    ActivityComponentBuilder provideLoginActivityBuilder(LoginActivityComponent.Builder builder) {
        return builder;
    }
}
