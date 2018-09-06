package ua.energy.view.consolidate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.energy.R;
import ua.energy.app.App;
import ua.energy.compound_view.CompoundTable3;
import ua.energy.entity.HydroStationTable;
import ua.energy.presenter.ConsolidatePresenter;
import ua.energy.util.UtilityListView;

public class ConsolidateActivity extends AppCompatActivity {

    CompoundTable3 viewTable3;

    @BindView(R.id.lvTable2)
    ListView lvTable2;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        init();

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

    public void setDataTable2(String [] from, ArrayList<Map<String, String>> data){

        int [] to = {R.id.tvTable2Cell1, R.id.tvTable2Cell2, R.id.tvTable2Cell3,
                R.id.tvTable2Cell4, R.id.tvTable2Cell5};

        SimpleAdapter adapter =
                new SimpleAdapter(this, data, R.layout.item_row_table2, from, to);

//        BinderViewTable2 binder = new BinderViewTable2(colorHeaderBack, colorHeaderText,
//                colorCellBack,colorCellText);
//
//        adapter.setViewBinder(binder);

        lvTable2 = (ListView) findViewById(R.id.lvTable2);
        lvTable2.setAdapter(adapter);
        UtilityListView.setListViewHeightBasedOnChildren(lvTable2);
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
