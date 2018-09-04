package ua.energy.presenter;

import java.util.List;

import ua.energy.entity.HydroStationTable;
import ua.energy.model.StationModel;
import ua.energy.view.consolidate.ConsolidateContractView;

public class ConsolidatePresenter implements ConsolidateContractModel{

    private ConsolidateContractView mView;
    private StationModel mModel;

    public ConsolidatePresenter(StationModel stationModel) {
        mModel = stationModel;
    }

    public void attachView(ConsolidateContractView view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }

    public void viewIsReady() {
        //todo something
    }


    @Override
    public void loadHydroStationStatus(List<HydroStationTable> list) {
        //todo метод, котторый переносит данные из джисона в таблицу вьюхи

    }
}
