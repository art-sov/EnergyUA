package ua.energy.presenter;

import java.util.List;

import ua.energy.entity.HydroStationTable;

public interface ConsolidateContractModel {

    void loadHydroStationStatus(List<HydroStationTable> list);

}
