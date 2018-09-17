package ua.energy.app.dagger.dispatcher;

import dagger.Subcomponent;
import ua.energy.app.dagger.ComponentsHolder;

@DispatcherScope
@Subcomponent(modules = {DispatcherModule.class})
public interface DispatcherComponent {

    void injectComponentsHolder(ComponentsHolder componentsHolder);
}
