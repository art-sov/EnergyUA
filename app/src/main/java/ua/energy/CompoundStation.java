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

        block05tv = findViewById(R.id.block05tv);
        block05cb = findViewById(R.id.block05cb);

        block06tv = findViewById(R.id.block06tv);
        block06cb = findViewById(R.id.block06cb);

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

    public TextView getColumn1() {
        return column1;
    }

    public void setColumn1(TextView column1) {
        this.column1 = column1;
    }

    public TextView getColumn2() {
        return column2;
    }

    public void setColumn2(TextView column2) {
        this.column2 = column2;
    }

    public TextView getColumn3() {
        return column3;
    }

    public void setColumn3(TextView column3) {
        this.column3 = column3;
    }

    public TextView getColumn4() {
        return column4;
    }

    public void setColumn4(TextView column4) {
        this.column4 = column4;
    }

    public TextView getColumn5() {
        return column5;
    }

    public void setColumn5(TextView column5) {
        this.column5 = column5;
    }

    public TextView getColumn6() {
        return column6;
    }

    public void setColumn6(TextView column6) {
        this.column6 = column6;
    }

    public TextView getBlock01tv() {
        return block01tv;
    }

    public void setBlock01tv(TextView block01tv) {
        this.block01tv = block01tv;
    }

    public CompoundBlock getBlock01cb() {
        return block01cb;
    }

    public void setBlock01cb(CompoundBlock block01cb) {
        this.block01cb = block01cb;
    }

    public TextView getBlock02tv() {
        return block02tv;
    }

    public void setBlock02tv(TextView block02tv) {
        this.block02tv = block02tv;
    }

    public CompoundBlock getBlock02cb() {
        return block02cb;
    }

    public void setBlock02cb(CompoundBlock block02cb) {
        this.block02cb = block02cb;
    }

    public TextView getBlock03tv() {
        return block03tv;
    }

    public void setBlock03tv(TextView block03tv) {
        this.block03tv = block03tv;
    }

    public CompoundBlock getBlock03cb() {
        return block03cb;
    }

    public void setBlock03cb(CompoundBlock block03cb) {
        this.block03cb = block03cb;
    }

    public TextView getBlock04tv() {
        return block04tv;
    }

    public void setBlock04tv(TextView block04tv) {
        this.block04tv = block04tv;
    }

    public CompoundBlock getBlock04cb() {
        return block04cb;
    }

    public void setBlock04cb(CompoundBlock block04cb) {
        this.block04cb = block04cb;
    }

    public TextView getBlock05tv() {
        return block05tv;
    }

    public void setBlock05tv(TextView block05tv) {
        this.block05tv = block05tv;
    }

    public CompoundBlock getBlock05cb() {
        return block05cb;
    }

    public void setBlock05cb(CompoundBlock block05cb) {
        this.block05cb = block05cb;
    }

    public TextView getBlock06tv() {
        return block06tv;
    }

    public void setBlock06tv(TextView block06tv) {
        this.block06tv = block06tv;
    }

    public CompoundBlock getBlock06cb() {
        return block06cb;
    }

    public void setBlock06cb(CompoundBlock block06cb) {
        this.block06cb = block06cb;
    }

    public TextView getBlock07tv() {
        return block07tv;
    }

    public void setBlock07tv(TextView block07tv) {
        this.block07tv = block07tv;
    }

    public CompoundBlock getBlock07cb() {
        return block07cb;
    }

    public void setBlock07cb(CompoundBlock block07cb) {
        this.block07cb = block07cb;
    }

    public TextView getBlock08tv() {
        return block08tv;
    }

    public void setBlock08tv(TextView block08tv) {
        this.block08tv = block08tv;
    }

    public CompoundBlock getBlock08cb() {
        return block08cb;
    }

    public void setBlock08cb(CompoundBlock block08cb) {
        this.block08cb = block08cb;
    }

    public TextView getBlock09tv() {
        return block09tv;
    }

    public void setBlock09tv(TextView block09tv) {
        this.block09tv = block09tv;
    }

    public CompoundBlock getBlock09cb() {
        return block09cb;
    }

    public void setBlock09cb(CompoundBlock block09cb) {
        this.block09cb = block09cb;
    }

    public TextView getBlock10tv() {
        return block10tv;
    }

    public void setBlock10tv(TextView block10tv) {
        this.block10tv = block10tv;
    }

    public CompoundBlock getBlock10cb() {
        return block10cb;
    }

    public void setBlock10cb(CompoundBlock block10cb) {
        this.block10cb = block10cb;
    }

    public TextView getBlock11tv() {
        return block11tv;
    }

    public void setBlock11tv(TextView block11tv) {
        this.block11tv = block11tv;
    }

    public CompoundBlock getBlock11cb() {
        return block11cb;
    }

    public void setBlock11cb(CompoundBlock block11cb) {
        this.block11cb = block11cb;
    }

    public TextView getBlock12tv() {
        return block12tv;
    }

    public void setBlock12tv(TextView block12tv) {
        this.block12tv = block12tv;
    }

    public CompoundBlock getBlock12cb() {
        return block12cb;
    }

    public void setBlock12cb(CompoundBlock block12cb) {
        this.block12cb = block12cb;
    }

    public TextView getBlock13tv() {
        return block13tv;
    }

    public void setBlock13tv(TextView block13tv) {
        this.block13tv = block13tv;
    }

    public CompoundBlock getBlock13cb() {
        return block13cb;
    }

    public void setBlock13cb(CompoundBlock block13cb) {
        this.block13cb = block13cb;
    }

    public TextView getBlock14tv() {
        return block14tv;
    }

    public void setBlock14tv(TextView block14tv) {
        this.block14tv = block14tv;
    }

    public CompoundBlock getBlock14cb() {
        return block14cb;
    }

    public void setBlock14cb(CompoundBlock block14cb) {
        this.block14cb = block14cb;
    }

    public TextView getBlock15tv() {
        return block15tv;
    }

    public void setBlock15tv(TextView block15tv) {
        this.block15tv = block15tv;
    }

    public CompoundBlock getBlock15cb() {
        return block15cb;
    }

    public void setBlock15cb(CompoundBlock block15cb) {
        this.block15cb = block15cb;
    }
}
