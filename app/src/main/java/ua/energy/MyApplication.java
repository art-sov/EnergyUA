package ua.energy;

import android.app.Application;

import ua.energy.presenter.StationPresenter;
import ua.energy.service.ServiceGenerator;

public class MyApplication extends Application {

    private static ServiceGenerator sServiceGenerator;
    private static StationPresenter mStationPresenter;


    public static ServiceGenerator getServiceGenerator(){

        if (sServiceGenerator != null) {
            return sServiceGenerator;
        }

        sServiceGenerator = new ServiceGenerator();
        return sServiceGenerator;
    }

    //todo реализовать синглтон презентера для станций ???????

    public StationPresenter getStationPresenter(){
        if (mStationPresenter != null) {
            return mStationPresenter;
        }

        mStationPresenter = new StationPresenter();
        return mStationPresenter;
    }
}
