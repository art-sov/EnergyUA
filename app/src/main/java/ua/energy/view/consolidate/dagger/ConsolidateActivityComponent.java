package ua.energy.view.consolidate.dagger;

import dagger.Subcomponent;
import ua.energy.app.dagger.base.ActivityComponent;
import ua.energy.app.dagger.base.ActivityComponentBuilder;
import ua.energy.view.consolidate.ConsolidateActivity;

@ConsolidateActivityScope
@Subcomponent(modules = {ConsolidateActivityModule.class})
public interface ConsolidateActivityComponent extends ActivityComponent<ConsolidateActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<ConsolidateActivityComponent,
            ConsolidateActivityModule> {

    }

    //void inject(ConsolidateActivity consolidateActivity);
}
