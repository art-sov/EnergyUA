package ua.energy.presenter;

import java.util.List;

import ua.energy.entity.ConsumptionTable;
import ua.energy.entity.HydroStationTable;

public interface ConsolidateContractModel {

        void setTable2(List<ConsumptionTable> list);

        void setTable3(List<HydroStationTable> list);
}
