package ua.energy.view;

import java.util.List;

import ua.energy.CompoundStation;
import ua.energy.entity.Station;
import ua.energy.entity.Unit;

public interface StationContractView {

    List<CompoundStation> createCompoundStationList();

    void setFuelContent(int index, String coalValue,
                        String oilValue, String gasValue, String shortName, String unitValue,
                        String power);

    void setBlockContent(Unit unit1, int index, int numberBlock, String powerBlock, int repairStatus,
                         String stationName);

    void setCompoundBlockContent(Unit unit1, Unit unit2, int index, int numberBlock,
                                 String powerBlock, int repairStatus1, int repairStatus2,
                                 String stationName);

    void showToast(String message);

    void updateUI();

    void showProgressBar();

    void hideProgressBar();
}
