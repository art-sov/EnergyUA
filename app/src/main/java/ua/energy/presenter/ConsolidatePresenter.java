package ua.energy.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.energy.R;
import ua.energy.entity.ConsumptionTable;
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

    public void loadConsumptionControl() {
        mModel.loadDataTable2(this);
    }

    public void loadHydroStationStatus() {
        mModel.loadDataTable3(this);
    }


    @Override
    public void setTable2(List<ConsumptionTable> list) {

        String [] from = {"column1", "column2", "column3", "column4", "column5"};

        //упаковываем данные для адаптера
        ArrayList<Map<String, String>> data = new ArrayList<>();
        Map<String, String> map;

        for (int i = 0; i < list.size(); i++) {
            map = new HashMap<>();
            switch (list.get(i).getColumn1()){
                case 1:
                    continue;
                case 2:
                    map.put("column1", "Дн");
                    break;
                case 3:
                    map.put("column1", "Сев");
                    break;
                case 4:
                    map.put("column1", "Цн");
                    break;
                case 5:
                    map.put("column1", "ЮЗ");
                    break;
                case 6:
                    map.put("column1", "Ю");
                    break;
                case 7:
                    map.put("column1", "Зп");
                    break;
                case 8:
                    continue;
                case 10:
                    map.put("column1", "Украина");
                    break;
            }
            map.put("column2", Integer.toString(list.get(i).getColumn2()));
            map.put("column3", Integer.toString(list.get(i).getColumn3()));
            map.put("column4", Integer.toString(list.get(i).getColumn4()));
            map.put("column5", Integer.toString(list.get(i).getColumn5()));
            data.add(map);
        }
        mView.setDataTable2(from, data);
    }

    @Override
    public void setTable3(List<HydroStationTable> list) {

        for (HydroStationTable row: list) {
            mView.setDataTable3(row);
        }
    }



}
