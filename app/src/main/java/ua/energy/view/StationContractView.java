package ua.energy.view;

import java.util.List;

import ua.energy.CompoundStation;
import ua.energy.entity.Station;

public interface StationContractView {

    List<CompoundStation> createCompoundStationList();

    void setFuelContent(int index, String coalValue,
                        String oilValue, String gasValue, String shortName, String unitValue,
                        String power);

    void setBlockContent(int index, int numberBlock, String powerBlock);

}
