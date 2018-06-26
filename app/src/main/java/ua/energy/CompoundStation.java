package ua.energy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CompoundStation extends LinearLayout {

    private TextView column1;
    private TextView column2;
    private TextView column3;
    private TextView column4;
    private TextView column5;
    private TextView column6;

    private TextView block01;
    private TextView block02;
    private TextView block03;
    private CompoundBlock block04;
    private CompoundBlock block05;
    private TextView block06;
    private TextView block07;
    private TextView block08;
    private TextView block09;
    private TextView block10;
    private TextView block11;
    private TextView block12;
    private TextView block13;
    private TextView block14;
    private TextView block15;

    public CompoundStation(Context context) {
        super(context);
        initViews(context);
    }

    public CompoundStation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public CompoundStation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    private void initViews(Context context){
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_compound_station, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        column1 = findViewById(R.id.column1);
        column2 = findViewById(R.id.column2);
        column3 = findViewById(R.id.column3);
        column4 = findViewById(R.id.column4);
        column5 = findViewById(R.id.column5);
        column6 = findViewById(R.id.column6);

        block01 = findViewById(R.id.block01);
        block02 = findViewById(R.id.block02);
        block03 = findViewById(R.id.block03);
        block04 = findViewById(R.id.block04);
        block05 = findViewById(R.id.block05);
        block06 = findViewById(R.id.block06);
        block07 = findViewById(R.id.block07);
        block08 = findViewById(R.id.block08);
        block09 = findViewById(R.id.block09);
        block10 = findViewById(R.id.block10);
        block11 = findViewById(R.id.block11);
        block12 = findViewById(R.id.block12);
        block13 = findViewById(R.id.block13);
        block14 = findViewById(R.id.block14);
        block15 = findViewById(R.id.block15);
    }
}
