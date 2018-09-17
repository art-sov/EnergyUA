package ua.energy.view.consolidate;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.energy.R;
import ua.energy.app.App;
import ua.energy.compound_view.CompoundTable3;
import ua.energy.entity.ConsolidateTable;
import ua.energy.entity.ConsumptionTable;
import ua.energy.entity.HydroStationTable;
import ua.energy.presenter.ConsolidatePresenter;
import ua.energy.util.DateUtil;
import ua.energy.view.consolidate.adapter.BalanceAdapter;
import ua.energy.view.consolidate.adapter.ConsumptionAdapter;

public class ConsolidateActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @BindView(R.id.rvTable1)
    RecyclerView mRvTable1;

    @BindView(R.id.rvTable2)
    RecyclerView mRvTable2;

    @BindView(R.id.tvTitleConsolidateReport)
    TextView tvTitle;

    @BindView(R.id.tvTitleTable2)
    TextView tvTitleTable2;

    @BindView(R.id.tvTitleTable3)
    TextView tvTitleTable3;

    CompoundTable3 viewTable3;

    @Inject
    ConsolidatePresenter mPresenter;

    DatePickerDialog mDialod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consolidate);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        viewTable3 = (CompoundTable3) findViewById(R.id.layout_table3);
        App.getApp(this).getComponentsHolder().getConsolidateActivityComponent().inject(this);

        ButterKnife.bind(this);

//        CustomLinearLayoutManager layoutManager = new CustomLinearLayoutManager(this);
//        layoutManager.setScrollEnabled(false);
     //   mRvTable1.setLayoutManager(layoutManager);
        mRvTable1.setLayoutManager(new LinearLayoutManager(this));
        mRvTable2.setLayoutManager(new LinearLayoutManager(this));

        Calendar calendar = DateUtil.getCurrentCalendar();
        mDialod = new DatePickerDialog(this, this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialod.show();
            }
        });

        init();

        mPresenter.loadMaxTime();
        mPresenter.loadConsolidateBalance();
        mPresenter.loadConsumptionControl();
        mPresenter.loadHydroStationStatus();

        tvTitleTable3.setText(String.format(getResources().getString(R.string.title_table_3), DateUtil.getStringCurrentDate()));
        tvTitle.setText(String.format(getResources().getString(R.string.title_consolidate_statements), DateUtil.getStringCurrentDate()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseConsolidateActivityComponent();
        }
        mPresenter.detachView();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mPresenter.dateSelected(year, month, dayOfMonth);
        tvTitleTable3.setText(String.format(getResources().getString(R.string.title_table_3),
                DateUtil.getStringDate(year, month,dayOfMonth)));
        tvTitle.setText(String.format(getResources().getString(R.string.title_consolidate_statements),
                DateUtil.getStringDate(year, month,dayOfMonth)));
    }

    public void setDataTable1(List<ConsolidateTable> list){
        mRvTable1.setAdapter(new BalanceAdapter(list));
    }

    public void setTime(String maxTime) {
        Resources resource = getResources();
        String titleTable2 = resource.getString(R.string.title_table_2, maxTime);
        tvTitleTable2.setText(titleTable2);

    }

    public void setDataTable2(List<ConsumptionTable> list){
        mRvTable2.setAdapter(new ConsumptionAdapter(list));
    }

    public void setDataTable3(HydroStationTable row) {
        viewTable3.setRow(row);
    }

    //------------------------------------------------------------------------------------------
    //static methods
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ConsolidateActivity.class);
        //put something
        return intent;
    }

    //------------------------------------------------------------------------------------------
    //private methods
    private void init() {
        mPresenter.attachView(this);
        mPresenter.viewIsReady();
    }
}
