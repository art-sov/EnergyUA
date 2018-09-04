package ua.energy.compound_view;

import android.content.Context;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import ua.energy.R;

public class CompoundBlock extends LinearLayout {

    private TextView unit1;
    private TextView unit2;
    private TextView unit3;

    public CompoundBlock(Context context) {
        super(context);
        initViews(context);
    }

    public CompoundBlock(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public CompoundBlock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    private void initViews(Context context){
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.layout_compound_block, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        unit1 = findViewById(R.id.tv_unit1);
        unit2 = findViewById(R.id.tv_unit2);
        unit3 = findViewById(R.id.tv_unit3);
    }

     public TextView getUnit1() {
        return unit1;
    }

    public void setUnit1(TextView unit1) {
        this.unit1 = unit1;
    }

    public TextView getUnit2() {
        return unit2;
    }

    public void setUnit2(TextView unit2) {
        this.unit2 = unit2;
    }

    public TextView getUnit3() {
        return unit3;
    }

    public void setUnit3(TextView unit3) {
        this.unit3 = unit3;
    }
}
