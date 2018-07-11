package ua.energy.presenter;

import android.util.Log;

import java.util.List;

import ua.energy.entity.Block;
import ua.energy.entity.ShortNameStation;
import ua.energy.entity.Station;
import ua.energy.model.StationModel;
import ua.energy.view.StationContractView;

public class StationPresenter implements StationContractModel {

    private StationContractView view;
    private final StationModel model;

    public StationPresenter() {
        model = new StationModel();
    }

    public void attachView(StationContractView view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public void viewIsReady(){

        //создания списка строк таблицы
        view.createCompoundStationList();

        //загрузка данных с сервера
        model.loadStations(this);

    }

    public void updateStationContent(List<Station> list) {
        //todo исключить мироновскую ТЭС, Эсхар и добавить Старобешевскую
        int index = 0;
        ShortNameStation shortNameStation = new ShortNameStation();
        for (Station station: list){
            if (station.getName() != null) {

                String coalValue = getValue(station.getCoalValue());

                String oilValue = getValue(station.getOilValue());

                String gasValue = getValue(station.getGasValue());

                String shortName = ShortNameStation.getShortName(station.getName());

                String unitValue = station.getUnitValue();

                String power = Integer.toString((int)station.getPower());

                view.setFuelContent(index, coalValue, oilValue, gasValue,
                        shortName, unitValue, power);

                //todo реализовать получение списка блоков
                List<Block> blockList = station.getBlockList();

                for (Block block: blockList) {
                    int numberBlock = block.getNumber();
                    String powerBlock = Integer.toString(block.getPower());
                    view.setBlockContent(index, numberBlock, powerBlock);

                }

                index++;
            }
        }

    }

    private String getValue (float valueFloat){

        if (valueFloat == 0)
            return "0";
        return Float.toString(valueFloat);
    }

//================================================================
    //методы обратного вызова
    @Override
    public void loadStationList(List<Station> list) {

        updateStationContent(list);
    }
}
