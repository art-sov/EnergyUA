package ua.energy.presenter;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import ua.energy.entity.ConsolidateTable;
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

    public void loadConsolidateBalance() {
        mModel.loadDataTable1(this);
    }

    public void loadMaxTime() {
        mModel.loadMaxTime(this);
    }

    public void loadConsumptionControl() {
        mModel.loadDataTable2(this);
    }

    public void loadHydroStationStatus() {
        mModel.loadDataTable3(this);
    }


    @Override
    public void setTable1(List<ConsolidateTable> list) {
        mView.setDataTable1(list);
    }

    @Override
    public void setMaxTime(String maxTime) {
        mView.setTime(maxTime);
    }

    @Override
    public void setTable2(List<ConsumptionTable> list) {
        mView.setDataTable2(list);
    }

    @Override
    public void setTable3(List<HydroStationTable> list) {
        for (HydroStationTable row: list) {
            mView.setDataTable3(row);
        }
    }

    public void dateSelected(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String date = simpleDateFormat.format(calendar.getTime());
        Log.i("!!!!!!!Date: ", date);

        mModel.saveDate(date);
        loadMaxTime();
        loadConsolidateBalance();
        loadConsumptionControl();
        loadHydroStationStatus();

        mModel.saveDate(null);
    }
}
