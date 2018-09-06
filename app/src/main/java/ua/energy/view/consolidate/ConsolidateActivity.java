package ua.energy.view.consolidate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
import ua.energy.util.UtilityListView;
import ua.energy.view.consolidate.adapter.BalanceAdapter;
import ua.energy.view.consolidate.adapter.ConsumptionAdapter;

public class ConsolidateActivity extends AppCompatActivity {

    @BindView(R.id.rvTable1)
    RecyclerView mRvTable1;

    @BindView(R.id.rvTable2)
    RecyclerView mRvTable2;

    CompoundTable3 viewTable3;

    @Inject
    ConsolidatePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consolidate);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        viewTable3 = (CompoundTable3) findViewById(R.id.layout_table3);
        App.getApp(this).getComponentsHolder().getConsolidateActivityComponent().inject(this);

        ButterKnife.bind(this);

        mRvTable1.setLayoutManager(new LinearLayoutManager(this));
        mRvTable2.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        init();

        mPresenter.loadConsolidateBalance();
        mPresenter.loadConsumptionControl();
        mPresenter.loadHydroStationStatus();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseConsolidateActivityComponent();
        }
        mPresenter.detachView();
    }

    public void setDataTable1(List<ConsolidateTable> list){
        mRvTable1.setAdapter(new BalanceAdapter(list));
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
