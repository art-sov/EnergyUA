package ua.energy.view.consolidate.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.app.dagger.base.ActivityModule;
import ua.energy.model.StationModel;
import ua.energy.presenter.ConsolidatePresenter;

@Module
public class ConsolidateActivityModule implements ActivityModule{

    @ConsolidateActivityScope
    @Provides
    ConsolidatePresenter provideConsolidateActivityPresenter(StationModel stationModel){
        return new ConsolidatePresenter(stationModel);
    }
}
