package ua.energy.entity;

import java.util.HashMap;
import java.util.Map;

import ua.energy.R;

public  class ColorRepair {

    private static Map<String, Integer> mapColor;

    public ColorRepair() {

        mapColor = new HashMap<>();

        mapColor.put("clGreen", R.drawable.rect_repair_medium);
        mapColor.put("clMaroon", R.drawable.rect_repair_reconstruction);
        mapColor.put("clOlive", R.drawable.rect_repair_overhaul);
        mapColor.put("clNavy", R.drawable.rect_repair_current_planed);
        mapColor.put("clRed", R.drawable.rect_repair_emergency);
        mapColor.put("clTeal", R.drawable.rect_repair_preservation);
        mapColor.put("clSilver", R.drawable.rect_repair_cold_reserve);
        mapColor.put("clYellow", R.drawable.rect_repair_fuel_constraints);
        mapColor.put("clWhite", R.drawable.rect_repair_operative);
    }

    public static int getNumberColor(String key) {
       return mapColor.get(key);
    }

}
