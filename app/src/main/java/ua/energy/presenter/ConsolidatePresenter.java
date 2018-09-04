package ua.energy.presenter;

import java.util.List;

import ua.energy.entity.HydroStationTable;
import ua.energy.model.StationModel;
import ua.energy.view.consolidate.ConsolidateActivity;

public class ConsolidatePresenter implements ConsolidateContractModel{

    private ConsolidateActivity mView;
    private StationModel mModel;

    public ConsolidatePresenter(StationModel stationModel) {
        mModel = stationModel;
    }

    public void attachView(ConsolidateActivity view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
    }

    public void viewIsReady() {
        //todo something
    }

    public void loadHydroStationStatus() {
        mModel.loadDataTable3(this);
    }

    @Override
    public void loadDataTable3(List<HydroStationTable> list) {

        for (HydroStationTable row: list) {
            mView.setDataTable3(row);
        }
    }
}
