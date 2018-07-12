package ua.energy.view;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ua.energy.CompoundBlock;
import ua.energy.CompoundStation;
import ua.energy.MasterMVP;
import ua.energy.R;
import ua.energy.model.StationModel;
import ua.energy.presenter.StationPresenter;

public class StationActivity extends AppCompatActivity implements StationContractView {

    DatePickerDialog dialog;
    CoordinatorLayout mainLayout;
    List<CompoundStation> compoundStationList;
    StationPresenter mPresenter;

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

        init();
    }

    private void init() {

        mPresenter = new StationPresenter();
        mPresenter.attachView(this);
        mPresenter.viewIsReady();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public List<CompoundStation> createCompoundStationList(){

        //TODO использовать библиотеку ButterKnife
        compoundStationList = new ArrayList<>();

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


    @Override
    public void setFuelContent(int index, String coalValue, String oilValue,
                               String gasValue, String shortName, String unitValue, String power){
        compoundStationList.get(index).getColumn1().setText(coalValue);
        compoundStationList.get(index).getColumn2().setText(oilValue);
        compoundStationList.get(index).getColumn3().setText(gasValue);
        compoundStationList.get(index).getColumn4().setText(shortName);
        compoundStationList.get(index).getColumn5().setText(unitValue);
        compoundStationList.get(index).getColumn6().setText(power);

    }

    @Override
    public void setBlockContent(int index, int numberBlock, String power, int repairStatus) {

        TextView textView = getTextView(index, numberBlock);

        if (Integer.parseInt(power) > 10)
            textView.setText(power);

        if (repairStatus != 0){
            Drawable drawable = getDrawable(repairStatus);
            textView.setBackground(drawable);
        }
        else {
            textView.setBackground(getDrawable(R.drawable.simple_rect));

        }
    }

    @Override
    public void setCompoundBlockContent(int index, int numberBlock, String powerBlock,
                                        int repairStatus1, int repairStatus2) {

        Drawable drawableSimpleRect = getDrawable(R.drawable.simple_rect);

        TextView textView = getTextView(index, numberBlock);
        textView.setVisibility(View.GONE);

        CompoundBlock compoundBlock = getCompoundBlock(index, numberBlock);
        compoundBlock.setVisibility(View.VISIBLE);

        TextView textViewUnit1 = compoundBlock.getUnit1();
        TextView textViewUnit2 = compoundBlock.getUnit2();
        TextView textViewUnit3 = compoundBlock.getUnit3();

        if (repairStatus1 != 0) {
            Drawable drawable = getDrawable(repairStatus1);
            textViewUnit1.setBackground(drawable);
        }
        else {
            textViewUnit1.setBackground(drawableSimpleRect);
        }

        if (repairStatus2 != 0) {
            Drawable drawable = getDrawable(repairStatus2);
            textViewUnit2.setBackground(drawable);
        }
        else {
            textViewUnit2.setBackground(drawableSimpleRect);
        }

        textViewUnit3.setBackground(drawableSimpleRect);

        if (Integer.parseInt(powerBlock) > 10){
            textViewUnit3.setText(powerBlock);
        }

        if (repairStatus1 != 0 && repairStatus2 != 0 && repairStatus1 == repairStatus2){
            Drawable drawable = getDrawable(repairStatus1);
            textViewUnit3.setBackground(drawable);
        }
    }

    private CompoundBlock getCompoundBlock(int index, int numberBlock) {

        CompoundBlock compoundBlock = null;

        switch (numberBlock){
            case 1:
                compoundBlock = compoundStationList.get(index).getBlock01cb();
                break;
            case 2:
                compoundBlock = compoundStationList.get(index).getBlock02cb();
                break;
            case 3:
                compoundBlock = compoundStationList.get(index).getBlock03cb();
                break;
            case 4:
                compoundBlock = compoundStationList.get(index).getBlock04cb();
                break;
            case 5:
                compoundBlock = compoundStationList.get(index).getBlock05cb();
                break;
            case 6:
                compoundBlock = compoundStationList.get(index).getBlock06cb();
                break;
            case 7:
                compoundBlock = compoundStationList.get(index).getBlock07cb();
                break;
            case 8:
                compoundBlock = compoundStationList.get(index).getBlock08cb();
                break;
            case 9:
                compoundBlock = compoundStationList.get(index).getBlock09cb();
                break;
            case 10:
                compoundBlock = compoundStationList.get(index).getBlock10cb();
                break;
            case 11:
                compoundBlock = compoundStationList.get(index).getBlock11cb();
                break;
            case 12:
                compoundBlock = compoundStationList.get(index).getBlock12cb();
                break;
            case 13:
                compoundBlock = compoundStationList.get(index).getBlock13cb();
                break;
            case 14:
                compoundBlock = compoundStationList.get(index).getBlock14cb();
                break;
            case 15:
                compoundBlock = compoundStationList.get(index).getBlock15cb();
                break;
        }
        return  compoundBlock;
    }

    public TextView getTextView(int index, int numberBlock){

        TextView textView = null;

        switch (numberBlock){
            case 1:
                textView = compoundStationList.get(index).getBlock01tv();
                break;
            case 2:
                textView = compoundStationList.get(index).getBlock02tv();
                break;
            case 3:
                textView = compoundStationList.get(index).getBlock03tv();
                break;
            case 4:
                textView = compoundStationList.get(index).getBlock04tv();
                break;
            case 5:
                textView = compoundStationList.get(index).getBlock05tv();
                break;
            case 6:
                textView = compoundStationList.get(index).getBlock06tv();
                break;
            case 7:
                textView = compoundStationList.get(index).getBlock07tv();
                break;
            case 8:
                textView = compoundStationList.get(index).getBlock08tv();
                break;
            case 9:
                textView = compoundStationList.get(index).getBlock09tv();
                break;
            case 10:
                textView = compoundStationList.get(index).getBlock10tv();
                break;
            case 11:
                textView = compoundStationList.get(index).getBlock11tv();
                break;
            case 12:
                textView = compoundStationList.get(index).getBlock12tv();
                break;
            case 13:
                textView = compoundStationList.get(index).getBlock13tv();
                break;
            case 14:
                textView = compoundStationList.get(index).getBlock14tv();
                break;
            case 15:
                textView = compoundStationList.get(index).getBlock15tv();
                break;
        }
        return textView;
    }
}
