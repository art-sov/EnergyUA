package ua.energy.app.dagger.base;

public interface ActivityComponent<A> {

    void inject(A activity);
}
