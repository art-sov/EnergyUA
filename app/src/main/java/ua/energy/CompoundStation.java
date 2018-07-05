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

    private TextView block01tv;
    private CompoundBlock block01cb;

    private TextView block02tv;
    private CompoundBlock block02cb;

    private TextView block03tv;
    private CompoundBlock block03cb;

    private TextView block04tv;
    private CompoundBlock block04cb;

    private TextView block05tv;
    private CompoundBlock block05cb;

    private TextView block06tv;
    private CompoundBlock block06cb;

    private TextView block07tv;
    private CompoundBlock block07cb;

    private TextView block08tv;
    private CompoundBlock block08cb;

    private TextView block09tv;
    private CompoundBlock block09cb;

    private TextView block10tv;
    private CompoundBlock block10cb;

    private TextView block11tv;
    private CompoundBlock block11cb;

    private TextView block12tv;
    private CompoundBlock block12cb;

    private TextView block13tv;
    private CompoundBlock block13cb;

    private TextView block14tv;
    private CompoundBlock block14cb;

    private TextView block15tv;
    private CompoundBlock block15cb;

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

        block01tv = findViewById(R.id.block01tv);
        block01cb = findViewById(R.id.block01cb);

        block02tv = findViewById(R.id.block02tv);
        block02cb = findViewById(R.id.block02cb);

        block03tv = findViewById(R.id.block03tv);
        block03cb = findViewById(R.id.block03cb);

        block04tv = findViewById(R.id.block04tv);
        block04cb = findViewById(R.id.block04cb);

        block06tv = findViewById(R.id.block05tv);
        block06cb = findViewById(R.id.block05cb);

        block07tv = findViewById(R.id.block07tv);
        block07cb = findViewById(R.id.block07cb);

        block08tv = findViewById(R.id.block08tv);
        block08cb = findViewById(R.id.block08cb);

        block09tv = findViewById(R.id.block09tv);
        block09cb = findViewById(R.id.block09cb);

        block10tv = findViewById(R.id.block10tv);
        block10cb = findViewById(R.id.block10cb);

        block11tv = findViewById(R.id.block11tv);
        block11cb = findViewById(R.id.block11cb);

        block12tv = findViewById(R.id.block12tv);
        block12cb = findViewById(R.id.block12cb);

        block13tv = findViewById(R.id.block13tv);
        block13cb = findViewById(R.id.block13cb);

        block14tv = findViewById(R.id.block14tv);
        block14cb = findViewById(R.id.block14cb);

        block15tv = findViewById(R.id.block15tv);
        block15cb = findViewById(R.id.block15cb);

        block01tv = findViewById(R.id.block01tv);
        block01cb = findViewById(R.id.block01cb);
    }
}
