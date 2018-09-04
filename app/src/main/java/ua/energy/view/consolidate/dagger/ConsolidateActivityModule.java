package ua.energy.view.consolidate.dagger;

import dagger.Module;
import dagger.Provides;
import ua.energy.model.StationModel;
import ua.energy.presenter.ConsolidatePresenter;

@Module
public class ConsolidateActivityModule {

    @ConsolidateActivityScope
    @Provides
    ConsolidatePresenter provideConsolidateActivityPresenter(StationModel stationModel){
        return new ConsolidatePresenter(stationModel);
    }
}
