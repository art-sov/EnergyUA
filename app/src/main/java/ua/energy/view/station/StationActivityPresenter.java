package ua.energy.view.station;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import ua.energy.entity.Block;
import ua.energy.entity.ColorRepair;
import ua.energy.entity.ShortNameStation;
import ua.energy.entity.Station;
import ua.energy.entity.Unit;
import ua.energy.model.StationModel;
import ua.energy.presenter.StationContractModel;
import ua.energy.view.StationContractView;

public class StationActivityPresenter implements StationContractModel {

    private StationContractView view;

    private final StationModel model;

    public StationActivityPresenter(StationModel model) {
        this.model = model;
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

    private void updateStationContent(List<Station> list) {
        int index = 0;
        ShortNameStation shortNameStation = new ShortNameStation();
        ColorRepair colorRepair = new ColorRepair();
        for (Station station: list){
            //исключение Мироновской ТЭС
            if (station.getId() == 513004 || station.getId() == 513326) {
                continue;
            }
            if (station.getName() != null) {

                String coalValue = getValue(station.getCoalValue());

                String oilValue = getValue(station.getOilValue());

                String gasValue = getValue(station.getGasValue());

                String shortName = ShortNameStation.getShortName(station.getName());

                String unitValue = station.getUnitValue();

                String power = Integer.toString((int)station.getPower());

                String stationName = station.getName();

                view.setFuelContent(index, coalValue, oilValue, gasValue,
                        shortName, unitValue, power);

                List<Block> blockList = station.getBlockList();

                for (Block block: blockList) {

                    int numberBlock = block.getNumber();
                    String powerBlock = Integer.toString(block.getPower());

                    Unit unit1 = block.getUnit1();
                    Unit unit2 = block.getUnit2();

                    if (unit2 == null) {

                        int repairStatus = 0;

                        if (unit1.getColor() != null){
                            repairStatus = ColorRepair.getNumberColor(unit1.getColor());
                        }

                        view.setBlockContent(unit1, index, numberBlock, powerBlock, repairStatus, stationName);
                    }
                    else {

                        int repairStatus1 = 0;
                        int repairStatus2 = 0;

                        if (unit1.getColor() != null) {
                            repairStatus1 = ColorRepair.getNumberColor(unit1.getColor());
                        }

                        if (unit2.getColor() != null) {
                            repairStatus2 = ColorRepair.getNumberColor(unit2.getColor());
                        }

                        view.setCompoundBlockContent(unit1, unit2, index, numberBlock, powerBlock,
                                repairStatus1, repairStatus2, stationName);
                    }
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
        view.showProgressBar();
        updateStationContent(list);
        view.hideProgressBar();
    }

    @Override
    public void showMessage(String message) {
        view.showToast(message);
    }

    //пользователь выбрал дату
    public void dateSelected(int year, int month, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        Calendar selectedCalendar = Calendar.getInstance();
        selectedCalendar.set(year, month, dayOfMonth);

        //todo реализовать progress bar
        if (selectedCalendar.after(calendar) || selectedCalendar.equals(calendar)) {
            view.showToast("Необходимо выбрать дату на день меньше текущей");
            view.updateUI();
            model.saveDate("current");
            model.loadStations(this);}

        else {
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            String date = simpleDateFormat.format(selectedCalendar.getTime());
            Log.i("!!!!!!!Date: ", date);
            model.saveDate(date);
            view.updateUI();
            model.loadStations(this);
        }
    }

    public void setAuthToken(String authToken){
        model.setAuthToken(authToken);
    }
}
