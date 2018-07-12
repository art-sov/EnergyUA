package ua.energy.presenter;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import ua.energy.entity.Block;
import ua.energy.entity.ColorRepair;
import ua.energy.entity.ShortNameStation;
import ua.energy.entity.Station;
import ua.energy.entity.Unit;
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
        ColorRepair colorRepair = new ColorRepair();
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

                        String statusShortName = unit1.getStatusShortName();
                        String statusFullName = unit1.getStatusFullName();
                        String repairStartTime = unit1.getRepairStartTime();
                        String repairEndTime = unit1.getRepairEndTime();
                        String comment = unit1.getComment();
                        String operator = unit1.getOperator();
                        String editTime = unit1.getEditTime();
                        String name = unit1.getName();

                        //todo реализовать класс для подробной информации о ремонте

                        view.setBlockContent(index, numberBlock, powerBlock, repairStatus);

                    }
                    else {

                        int repairStatus1 = 0;
                        int repairStatus2 = 0;

                        if (unit1.getColor() != null) {
                            repairStatus1 = ColorRepair.getNumberColor(unit1.getColor());
                        }

                        String statusShortName1 = unit1.getStatusShortName();
                        String statusFullName1 = unit1.getStatusFullName();
                        String repairStartTime1 = unit1.getRepairStartTime();
                        String repairEndTime1 = unit1.getRepairEndTime();
                        String comment1 = unit1.getComment();
                        String operator1 = unit1.getOperator();
                        String editTime1 = unit1.getEditTime();
                        String name1 = unit1.getName();

                        if (unit2.getColor() != null) {
                            repairStatus2 = ColorRepair.getNumberColor(unit2.getColor());
                        }

                        String statusShortName2 = unit2.getStatusShortName();
                        String statusFullName2 = unit2.getStatusFullName();
                        String repairStartTime2 = unit2.getRepairStartTime();
                        String repairEndTime2 = unit2.getRepairEndTime();
                        String comment2 = unit2.getComment();
                        String operator2 = unit2.getOperator();
                        String editTime2 = unit2.getEditTime();
                        String name2 = unit2.getName();

                        view.setCompoundBlockContent(index, numberBlock, powerBlock, repairStatus1, repairStatus2);
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

        updateStationContent(list);
    }

    //пользователь выбрал дату
    public void dateSelected(int year, int month, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        Calendar selectedCalendar = Calendar.getInstance();
        selectedCalendar.set(year, month, dayOfMonth);

        //todo реализовать progress bar
        if (selectedCalendar.after(calendar)) {
            view.showToast("Необходимо выбрать дату на день меньше текущей");
            view.updateUI();
            model.saveDate("current");
            model.loadStations(this);}

        else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String date = simpleDateFormat.format(selectedCalendar.getTime());
            Log.i("!!!!!!!Date: ", date);
            model.saveDate(date);
            view.updateUI();
            model.loadStations(this);
        }
    }
}
