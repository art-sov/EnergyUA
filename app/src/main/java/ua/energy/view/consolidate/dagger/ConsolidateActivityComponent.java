package ua.energy.view.consolidate.dagger;

import dagger.Subcomponent;
import ua.energy.view.consolidate.ConsolidateActivity;

@ConsolidateActivityScope
@Subcomponent(modules = {ConsolidateActivityModule.class})
public interface ConsolidateActivityComponent {

    void inject(ConsolidateActivity consolidateActivity);
}
