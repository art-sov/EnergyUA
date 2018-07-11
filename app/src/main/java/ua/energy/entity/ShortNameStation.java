package ua.energy.entity;

import java.util.HashMap;
import java.util.Map;

public class ShortNameStation {

    private static Map<String, String> mapShortNameStation;

    public ShortNameStation() {
        mapShortNameStation = new HashMap<>();

        mapShortNameStation.put("Луганская ТЭС", "ЛуТЭС");
        mapShortNameStation.put("Славянская ТЭС", "СлТЭС");
        mapShortNameStation.put("Мироновская ТЭС", "МиТЭС");
        mapShortNameStation.put("Углегорская ТЭС", "УТЭС");
        mapShortNameStation.put("Кураховская ТЭС", "КуТЭС");
        mapShortNameStation.put("Зуевская ТЭС", "ЗуТЭС");
        mapShortNameStation.put("Криворожская ТЭС", "КрТЭС");
        mapShortNameStation.put("Приднепровская ТЭС", "ПдТЭС");
        mapShortNameStation.put("Запорожская ТЭС", "ЗаТЭС");
        mapShortNameStation.put("Змиевская ТЭС", "ЗмТЭС");
        mapShortNameStation.put("Харьковская ТЭЦ-5", "ХТЭЦ-5");
        mapShortNameStation.put("Трипольская ТЭС", "ТрТЭС");
        mapShortNameStation.put("Киевская ТЭЦ-5", "КТЭЦ-5");
        mapShortNameStation.put("Киевская ТЭЦ-6", "КТЭЦ-6");
        mapShortNameStation.put("Ладыжинская ТЭС", "ЛаТЭС");
        mapShortNameStation.put("Бурштынская ТЭС", "БуТЭС");
        mapShortNameStation.put("Добротворская ТЭС", "ДоТЭС");
        mapShortNameStation.put("Эсхар", "ЭсХ");
    }

    public static String getShortName(String key){
        return mapShortNameStation.get(key);
    }
}
