package ua.energy.presenter;

import java.util.List;

import ua.energy.CompoundStation;
import ua.energy.entity.Block;
import ua.energy.entity.Station;
import ua.energy.model.StationModel;
import ua.energy.view.StationContractView;

public class StationPresenter {

    private StationContractView view;
    private final StationModel model;

    public StationPresenter(StationModel model) {
        this.model = model;
    }

    public void attachView(StationContractView view) {
        this.view = view;
    }

    public void viewIsReady(){

        //загрузка данных с сервера
        List<Station> stationList = model.loadStations();

        List<CompoundStation> compoundStationList = view.createCompoundStationList();

        updateStationContent(stationList, compoundStationList);

        //view.showStation(stationList);
    }

    public void detachView() {
        view = null;
    }

    public void updateStationContent(List<Station> stationList, List<CompoundStation> compoundStationList) {

        int i = 0;

        for (Station station: stationList){
            if (station.getName() != null) {

                CompoundStation compoundStation = compoundStationList.get(i);

                String coalValue = Float.toString(station.getCoalValue());

                String oilValue = Float.toString(station.getOilValue());

                String gasValue = Float.toString(station.getGasValue());

                String shortName = "ЛуТЭС";

                String unitValue = station.getUnitValue();

                String power = Integer.toString((int)station.getPower());

                view.setFuelContent(compoundStation, coalValue, oilValue, gasValue, shortName, unitValue, power);

                List<Block> blockList = station.getBlockList();

                i++;
            }
        }

    }
}
