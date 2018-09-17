package ua.energy.view.station.dagger;

import dagger.Subcomponent;
import ua.energy.app.dagger.base.ActivityComponent;
import ua.energy.app.dagger.base.ActivityComponentBuilder;
import ua.energy.view.station.StationActivity;

@StationActivityScope
@Subcomponent(modules = {StationActivityModule.class})
public interface StationActivityComponent extends ActivityComponent<StationActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<StationActivityComponent, StationActivityModule> {

    }
}
