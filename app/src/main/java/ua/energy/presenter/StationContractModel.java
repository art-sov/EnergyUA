package ua.energy.presenter;

import java.util.List;

import ua.energy.entity.Station;

public interface StationContractModel {

    void loadStationList(List<Station> list);

    void showMessage(String message);
}
