package ua.energy;

import ua.energy.presenter.StationPresenter;

public class MasterMVP {

    private static MasterMVP instance;
    private static StationPresenter presenter;

    private MasterMVP(){

    }

    public static MasterMVP getInstance() {
        if (instance == null) {
            instance = new MasterMVP();
        }
        return instance;
    }
}
