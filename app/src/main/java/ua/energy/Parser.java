package ua.energy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.energy.entity.Block;
import ua.energy.entity.Station;
import ua.energy.entity.Unit;

public class Parser {


    public void loadJSONFromAsset(Context context) {

        Map<Integer, Station> map = new HashMap<>();
        String json = null;

        try {
            InputStream inputStream = context.getAssets().open("kmu.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            Log.i("JSON: ", json);
        } catch (IOException e){
            e.printStackTrace();

        }

        try {
            JSONArray a = new JSONArray(json);

            for (int i = 0 ; i < a.length(); i++) {

                Integer key = null;
                List<Block> blockList = new ArrayList<>();


                JSONObject jsonObject = a.getJSONObject(i);
                Station station = new Station();

                int id = jsonObject.getInt("id");
                station.setId(id);
                key = id;

                String date = jsonObject.getString("date");
                station.setDate(date);

                String name = jsonObject.getString("name");
                station.setName(name);

                float coalValue = (float)jsonObject.getDouble("coalValue");
                station.setCoalValue(coalValue);

                float oilValue = (float)jsonObject.getDouble("oilValue");
                station.setOilValue(oilValue);

                float gasValue = (float)jsonObject.getDouble("gasValue");
                station.setGasValue(gasValue);

                float power = (float)jsonObject.getDouble("power");
                station.setPower(power);

                int och = jsonObject.getInt("och");
                station.setOch(och);

                String unitValue = jsonObject.getString("unitValue");
                station.setUnitValue(unitValue);

                JSONArray blocks = jsonObject.getJSONArray("blockDtoList");

                for (int j = 0; j < blocks.length(); j++) {

                    JSONObject blockObject = blocks.getJSONObject(j);
                    Block block = new Block();

                    int stationCode = blockObject.getInt("stationCode");
                    block.setStationCode(stationCode);

                    int number = blockObject.getInt("number");
                    block.setNumber(number);

                    int powerBlock = blockObject.getInt("power");
                    block.setPower(powerBlock);

                    JSONObject unitObject = blockObject.optJSONObject("unit1");

                    Unit unit1 = getUnitFromJSON(unitObject);
                    block.setUnit1(unit1);

                    unitObject = blockObject.optJSONObject("unit2");

                    Unit unit2 = getUnitFromJSON(unitObject);
                    block.setUnit2(unit2);

                    blockList.add(block);
                }
                station.setBlockList(blockList);
                map.put(key, station);

            }

            Log.i(" Map: ", "========================================== " + map.toString());
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Nullable
    private Unit getUnitFromJSON(JSONObject object) {

        Unit unit = new Unit();

        if (object == null)
            return null;

            try {

                int id = object.getInt("id");
                unit.setId(id);

                int power = object.getInt("power");
                unit.setPower(power);

                int ti = object.getInt("ti");
                unit.setTi(ti);

                int blockNumber = object.getInt("blockNumber");
                unit.setBlockNumber(blockNumber);

                int stationCode = object.getInt("stationCode");
                unit.setStationCode(stationCode);

                String station = object.getString("station");
                unit.setStation(station);

                String name = object.getString("name");
                unit.setName(name);

                String statusShortName = object.getString("statusShortName");
                unit.setStatusShortName(statusShortName);

                String statusFullName = object.getString("statusFullName");
                unit.setStatusFullName(statusFullName);

                String repairStartTime = object.getString("repairStartTime");
                unit.setRepairStartTime(repairStartTime);

                String repairEndTime = object.getString("repairEndTime");
                unit.setRepairEndTime(repairEndTime);

                String comment = object.getString("comment");
                unit.setComment(comment);

                String operator = object.getString("operator");
                unit.setOperator(operator);

                String editTime = object.getString("editTime");
                unit.setEditTime(editTime);

                String color = object.getString("color");
                unit.setColor(color);

                int och = object.getInt("och");
                unit.setOch(och);

                float workUnit = object.getLong("workUnit");
                unit.setWorkUnit(workUnit);

            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }

        return unit;
    }
}
