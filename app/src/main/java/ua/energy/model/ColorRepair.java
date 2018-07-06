package ua.energy.model;

import java.util.HashMap;
import java.util.Map;

public  class ColorRepair {

    private static Map<String, Integer> mapColor;

    public ColorRepair() {

        mapColor = new HashMap<>();
        mapColor.put("clGreen", 1);
        mapColor.put("clMaroon", 2);
        mapColor.put("clOlive", 3);
        mapColor.put("clNavy", 4);
        mapColor.put("clRed", 5);
        mapColor.put("clTeal", 6);
        mapColor.put("clSilver", 7);
        mapColor.put("clYellow", 8);
        mapColor.put("clWhite", 9);
    }

    public static int getNumberColor(String color) {
       return mapColor.get(color);
    }

}
