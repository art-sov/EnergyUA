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

import java.util.Calendar;
import java.util.Date;

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
                // скрыть навигационную панель
                mainLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
            }
        });

        CompoundStation compoundStation = (CompoundStation)findViewById(R.id.station_layout01);


        // скрыть навигационную панель
        mainLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        Parser parser = new Parser();

        parser.loadJSONFromAsset(StationActivity.this);
    }
}
