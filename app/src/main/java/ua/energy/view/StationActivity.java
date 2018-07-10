package ua.energy;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.energy.model.Block;
import ua.energy.model.Station;
import ua.energy.service.ServiceGenerator;
import ua.energy.service.ServerAPI;

public class StationActivity extends AppCompatActivity {

    DatePickerDialog dialog;
    CoordinatorLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainLayout = (CoordinatorLayout) findViewById(R.id.main_layout);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dialogListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                //TODO реализовать метод для установление текущей даты в запрос
                Toast.makeText(getApplicationContext(), "Date: ", Toast.LENGTH_SHORT).show();

            }
        };

        dialog = new DatePickerDialog(this, dialogListener, year, month, day);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_station);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        // скрыть навигационную панель
        mainLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        //ручной парсинг JSON
//        Parser parser = new Parser();
//        parser.loadJSONFromAsset(StationActivity.this);

        ServerAPI serverAPI = ServiceGenerator.createService(ServerAPI.class, "kmu", "EuroWind111");
        serverAPI.getConditionStations("current").enqueue(new Callback<List<Station>>() {
            @Override
            public void onResponse(Call<List<Station>> call, Response<List<Station>> response) {
                //Log.i("==========\n", response.body().toString());
                List<Station> list = response.body();
                updateStationContent(list);
                //toaster(station.getName());
            }

            @Override
            public void onFailure(Call<List<Station>> call, Throwable t) {
                //Log.i("Из респонса: ", "Респонс не был получен");
            }
        });

    }

    public void updateStationContent(List<Station> stationList) {

        int i = 0;
        List<CompoundStation> compoundStationList = createCompoundStationList();

        for (Station station: stationList){
            if (station.getName() != null) {

                CompoundStation compoundStation = compoundStationList.get(i);

                String coalValue = Float.toString(station.getCoalValue());
                compoundStation.getColumn1().setText(coalValue);

                String oilValue = Float.toString(station.getOilValue());
                compoundStation.getColumn2().setText(oilValue);

                String gasValue = Float.toString(station.getGasValue());
                compoundStation.getColumn3().setText(gasValue);

                compoundStation.getColumn4().setText("ЛуТЭС");

                compoundStation.getColumn5().setText(station.getUnitValue());

                String power = Integer.toString((int)station.getPower());
                compoundStation.getColumn6().setText(power);

                List<Block> blockList = station.getBlockList();

                  i++;
            }
        }

    }

    private void setContentBlock(List<Block> blockList) {

    }

    private List<CompoundStation> createCompoundStationList(){

        //TODO использовать библиотеку ButterKnife
        List<CompoundStation> compoundStationList = new ArrayList<>();

        CompoundStation compoundStation1 = (CompoundStation)findViewById(R.id.station_layout01);
        compoundStationList.add(compoundStation1);

        CompoundStation compoundStation2 = (CompoundStation)findViewById(R.id.station_layout02);
        compoundStationList.add(compoundStation2);

        CompoundStation compoundStation3 = (CompoundStation)findViewById(R.id.station_layout03);
        compoundStationList.add(compoundStation3);

        CompoundStation compoundStation4 = (CompoundStation)findViewById(R.id.station_layout04);
        compoundStationList.add(compoundStation4);

        CompoundStation compoundStation5 = (CompoundStation)findViewById(R.id.station_layout05);
        compoundStationList.add(compoundStation5);

        CompoundStation compoundStation6 = (CompoundStation)findViewById(R.id.station_layout06);
        compoundStationList.add(compoundStation6);

        CompoundStation compoundStation7 = (CompoundStation)findViewById(R.id.station_layout07);
        compoundStationList.add(compoundStation7);

        CompoundStation compoundStation8 = (CompoundStation)findViewById(R.id.station_layout08);
        compoundStationList.add(compoundStation8);

        CompoundStation compoundStation9 = (CompoundStation)findViewById(R.id.station_layout09);
        compoundStationList.add(compoundStation9);

        CompoundStation compoundStation10 = (CompoundStation)findViewById(R.id.station_layout10);
        compoundStationList.add(compoundStation10);

        CompoundStation compoundStation11 = (CompoundStation)findViewById(R.id.station_layout11);
        compoundStationList.add(compoundStation11);

        CompoundStation compoundStation12 = (CompoundStation)findViewById(R.id.station_layout12);
        compoundStationList.add(compoundStation12);

        CompoundStation compoundStation13 = (CompoundStation)findViewById(R.id.station_layout13);
        compoundStationList.add(compoundStation13);

        CompoundStation compoundStation14 = (CompoundStation)findViewById(R.id.station_layout14);
        compoundStationList.add(compoundStation14);

        CompoundStation compoundStation15 = (CompoundStation)findViewById(R.id.station_layout15);
        compoundStationList.add(compoundStation15);

        CompoundStation compoundStation16 = (CompoundStation)findViewById(R.id.station_layout16);
        compoundStationList.add(compoundStation16);

        CompoundStation compoundStation17 = (CompoundStation)findViewById(R.id.station_layout17);
        compoundStationList.add(compoundStation17);

        CompoundStation compoundStation18 = (CompoundStation)findViewById(R.id.station_layout18);
        compoundStationList.add(compoundStation18);

        CompoundStation compoundStation19 = (CompoundStation)findViewById(R.id.station_layout19);
        compoundStationList.add(compoundStation19);

        CompoundStation compoundStation20 = (CompoundStation)findViewById(R.id.station_layout20);
        compoundStationList.add(compoundStation20);

        CompoundStation compoundStation21 = (CompoundStation)findViewById(R.id.station_layout21);
        compoundStationList.add(compoundStation21);

        return compoundStationList;
    }
}
