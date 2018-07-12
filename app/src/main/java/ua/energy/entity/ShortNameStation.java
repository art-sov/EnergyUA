package ua.energy.entity;

import java.util.HashMap;
import java.util.Map;

public class ShortNameStation {

    private static Map<String, String> mapShortNameStation;

    public ShortNameStation() {
        mapShortNameStation = new HashMap<>();

        mapShortNameStation.put("Луганская ТЭС", "Лу\nТЭС");
        mapShortNameStation.put("Славянская ТЭС", "Сл\nТЭС");
        mapShortNameStation.put("Мироновская ТЭС", "Ми\nТЭС");
        mapShortNameStation.put("Углегорская ТЭС", "Уu\nТЭС");
        mapShortNameStation.put("Кураховская ТЭС", "Ку\nТЭС");
        mapShortNameStation.put("Зуевская ТЭС", "Зу\nТЭС");
        mapShortNameStation.put("Криворожская ТЭС", "Кр\nТЭС");
        mapShortNameStation.put("Приднепровская ТЭС", "Пд\nТЭС");
        mapShortNameStation.put("Запорожская ТЭС", "За\nТЭС");
        mapShortNameStation.put("Змиевская ТЭС", "Зм\nТЭС");
        mapShortNameStation.put("Харьковская ТЭЦ-5", "ХТЭЦ\n5");
        mapShortNameStation.put("Трипольская ТЭС", "Тр\nТЭС");
        mapShortNameStation.put("Киевская ТЭЦ-5", "КТЭЦ\n5");
        mapShortNameStation.put("Киевская ТЭЦ-6", "КТЭЦ\n6");
        mapShortNameStation.put("Ладыжинская ТЭС", "Ла\nТЭС");
        mapShortNameStation.put("Бурштынская ТЭС", "Бу\nТЭС");
        mapShortNameStation.put("Добротворская ТЭС", "До\nТЭС");
        mapShortNameStation.put("Эсхар", "Эс\nХАР");
    }

    public static String getShortName(String key){
        return mapShortNameStation.get(key);
    }
}
