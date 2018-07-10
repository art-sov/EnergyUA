package ua.energy.view;

import java.util.List;

import ua.energy.CompoundStation;
import ua.energy.entity.Station;

public interface StationContractView {

    void showStation(List<Station> list);

    List<CompoundStation> createCompoundStationList();

    void setFuelContent(CompoundStation compoundStation, String coalValue,
                        String oilValue, String gasValue, String shortName, String unitValue,
                        String power);

}
