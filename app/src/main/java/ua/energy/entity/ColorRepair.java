package ua.energy.entity;

import java.util.HashMap;
import java.util.Map;

import ua.energy.R;

public  class ColorRepair {

    private static Map<String, Integer> mapColor;

    public ColorRepair() {

        mapColor = new HashMap<>();
        mapColor.put("clGreen", R.color.repair_medium);
        mapColor.put("clMaroon", R.color.repair_reconstruction);
        mapColor.put("clOlive", R.color.repair_overhaul);
        mapColor.put("clNavy", R.color.repair_current_planed);
        mapColor.put("clRed", R.color.repair_emergency);
        mapColor.put("clTeal", R.color.repair_preservation);
        mapColor.put("clSilver", R.color.repair_cold_reserve);
        mapColor.put("clYellow", R.color.repair_fuel_constraints);
        mapColor.put("clWhite", R.color.repair_operative);
    }

    public static int getNumberColor(String color) {
       return mapColor.get(color);
    }

}
