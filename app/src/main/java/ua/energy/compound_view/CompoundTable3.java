package ua.energy.compound_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.energy.R;
import ua.energy.entity.HydroStationTable;

public class CompoundTable3 extends TableLayout {

    @BindView(R.id.tvTable3row1cell2)
    TextView tvRow1Cell2;
    @BindView(R.id.tvTable3row1cell3)
    TextView tvRow1Cell3;
    @BindView(R.id.tvTable3row1cell4)
    TextView tvRow1Cell4;
    @BindView(R.id.tvTable3row1cell5)
    TextView tvRow1Cell5;

    @BindView(R.id.tvTable3row2cell2)
    TextView tvRow2Cell2;
    @BindView(R.id.tvTable3row2cell3)
    TextView tvRow2Cell3;
    @BindView(R.id.tvTable3row2cell4)
    TextView tvRow2Cell4;
    @BindView(R.id.tvTable3row2cell5)
    TextView tvRow2Cell5;

    @BindView(R.id.tvTable3row3cell2)
    TextView tvRow3Cell2;
    @BindView(R.id.tvTable3row3cell3)
    TextView tvRow3Cell3;
    @BindView(R.id.tvTable3row3cell4)
    TextView tvRow3Cell4;
    @BindView(R.id.tvTable3row3cell5)
    TextView tvRow3Cell5;

    @BindView(R.id.tvTable3row4cell2)
    TextView tvRow4Cell2;
    @BindView(R.id.tvTable3row4cell3)
    TextView tvRow4Cell3;
    @BindView(R.id.tvTable3row4cell4)
    TextView tvRow4Cell4;
    @BindView(R.id.tvTable3row4cell5)
    TextView tvRow4Cell5;

    @BindView(R.id.tvTable3row5cell2)
    TextView tvRow5Cell2;
    @BindView(R.id.tvTable3row5cell3)
    TextView tvRow5Cell3;
    @BindView(R.id.tvTable3row5cell4)
    TextView tvRow5Cell4;
    @BindView(R.id.tvTable3row5cell5)
    TextView tvRow5Cell5;

    @BindView(R.id.tvTable3row6cell2)
    TextView tvRow6Cell2;
    @BindView(R.id.tvTable3row6cell3)
    TextView tvRow6Cell3;
    @BindView(R.id.tvTable3row6cell4)
    TextView tvRow6Cell4;
    @BindView(R.id.tvTable3row6cell5)
    TextView tvRow6Cell5;

    @BindView(R.id.tvTable3row7cell2)
    TextView tvRow7Cell2;
    @BindView(R.id.tvTable3row7cell3)
    TextView tvRow7Cell3;
    @BindView(R.id.tvTable3row7cell4)
    TextView tvRow7Cell4;
    @BindView(R.id.tvTable3row7cell5)
    TextView tvRow7Cell5;

    @BindView(R.id.tvTable3row8cell2)
    TextView tvRow8Cell2;

    public CompoundTable3(Context context) {
        super(context);
        initViews(context);
    }

    public CompoundTable3(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setRow (HydroStationTable row) {
        int id = row.getColumn1();

        switch(id){
            case 1:
                tvRow1Cell2.setText(String.format("%.2f", row.getColumn3()));
                tvRow1Cell3.setText(String.format("%.2f", row.getColumn4()));
                tvRow1Cell4.setText(Integer.toString(row.getColumn5()));
                tvRow1Cell5.setText(Integer.toString(row.getColumn6()));
            case 2:
                tvRow2Cell2.setText(String.format("%.2f", row.getColumn3()));
                tvRow2Cell3.setText(String.format("%.2f", row.getColumn4()));
                tvRow2Cell4.setText(Integer.toString(row.getColumn5()));
                tvRow2Cell5.setText(Integer.toString(row.getColumn6()));
            case 3:
                tvRow3Cell2.setText(String.format("%.2f", row.getColumn3()));
                tvRow3Cell3.setText(String.format("%.2f", row.getColumn4()));
                tvRow3Cell4.setText(Integer.toString(row.getColumn5()));
                tvRow3Cell5.setText(Integer.toString(row.getColumn6()));
            case 4:
                tvRow4Cell2.setText(String.format("%.2f", row.getColumn3()));
                tvRow4Cell3.setText(String.format("%.2f", row.getColumn4()));
                tvRow4Cell4.setText(Integer.toString(row.getColumn5()));
                tvRow4Cell5.setText(Integer.toString(row.getColumn6()));
            case 5:
                tvRow5Cell2.setText(String.format("%.2f", row.getColumn3()));
                tvRow5Cell3.setText(String.format("%.2f", row.getColumn4()));
                tvRow5Cell4.setText(Integer.toString(row.getColumn5()));
                tvRow5Cell5.setText(Integer.toString(row.getColumn6()));
            case 6:
                tvRow6Cell2.setText(String.format("%.2f", row.getColumn3()));
                tvRow6Cell3.setText(String.format("%.2f", row.getColumn4()));
                tvRow6Cell4.setText(Integer.toString(row.getColumn5()));
                tvRow6Cell5.setText(Integer.toString(row.getColumn6()));
            case 7:
                tvRow7Cell2.setText(String.format("%.2f", row.getColumn3()));
                tvRow7Cell3.setText(String.format("%.2f", row.getColumn4()));
                tvRow7Cell4.setText(Integer.toString(row.getColumn5()));
                tvRow7Cell5.setText(Integer.toString(row.getColumn6()));
            case 8:
                tvRow8Cell2.setText(Integer.toString(row.getColumn5()));

        }
    }

    private void initViews(Context context){
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout_compound_table3, this);
    }
}
