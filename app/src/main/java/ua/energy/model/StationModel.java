package ua.energy.model;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.energy.entity.ConsolidateTable;
import ua.energy.entity.ConsumptionTable;
import ua.energy.entity.HydroStationTable;
import ua.energy.entity.MaxTime;
import ua.energy.entity.Station;
import ua.energy.presenter.ConsolidateContractModel;
import ua.energy.presenter.StationContractModel;
import ua.energy.service.ApiService;
import ua.energy.service.ServiceGenerator;

public class StationModel {

    private String mDate;
    private String mAuthToken;
    ServiceGenerator mServiceGenerator;

    public StationModel(ServiceGenerator serviceGenerator) {
        mServiceGenerator = serviceGenerator;
    }

    private static final String LOG_TAG = StationModel.class.getName();

    private ApiService getApiService(){
        return mServiceGenerator.createService(ApiService.class, mAuthToken);
    }

    //загрузка состояния блоков и станций с сервера
    public void loadStations(final StationContractModel mStationContractModel) {

        String date = "current";
        if (mDate != null)
            date = mDate;

            //date format dd.MM.yyyy
            getApiService().getConditionStations(date).enqueue(new Callback<List<Station>>() {

                @Override
                public void onResponse(@NonNull Call<List<Station>> call,
                                       @NonNull Response<List<Station>> response) {

                    int responseCode = response.code();

                    if (responseCode == 401) {
                        mStationContractModel.showMessage("Вы не авторизовались");
                    }

                    List<Station> list = response.body();
                    //Log.i("RESPONSE===\n", list.toString());
                    mStationContractModel.loadStationList(list);
                }

                @Override
                public void onFailure(@NonNull Call<List<Station>> call, @NonNull Throwable t) {
                    Log.i("onFailure: ", "Response not exist");
                }
            });

            mDate = null;
    }

    //загрузка данных для сведенного отчета
    public void loadDataTable1(final ConsolidateContractModel model){
        String date = "current";
        if (mDate != null)
            date = mDate;

        getApiService().getBalanceTable(date).enqueue(new Callback<List<ConsolidateTable>>() {
            @Override
            public void onResponse(@NonNull Call<List<ConsolidateTable>> call,
                                   @NonNull Response<List<ConsolidateTable>> response) {
                List<ConsolidateTable> list = response.body();
                model.setTable1(list);
            }

            @Override
            public void onFailure(@NonNull Call<List<ConsolidateTable>> call, @NonNull Throwable t) {
                Log.i("onFailure: ", "Response not exist table 1");

            }
        });
    }

    public void loadMaxTime(final ConsolidateContractModel model) {
        String date = "current";
        if (mDate != null)
            date = mDate;


        getApiService().getTimeMax(date).enqueue(new Callback<MaxTime>() {
            @Override
            public void onResponse(@NonNull Call<MaxTime> call,
                                   @NonNull Response<MaxTime> response) {
                if (response.isSuccessful()) {
                    String maxTime = response.body().getTime();
                    model.setMaxTime(maxTime);
                    Log.i(LOG_TAG, "------maxTime: "+ maxTime);
                }
            }
            @Override
            public void onFailure(@NonNull Call<MaxTime> call, @NonNull Throwable t) {
                Log.i("onFailure: ", "Response not exist table 2 maxTime");

            }
        });
    }

    public void loadDataTable2(final ConsolidateContractModel model) {

        String date = "current";
        if (mDate != null)
            date = mDate;

        getApiService().getConsumptionControlTable(date).enqueue(new Callback<List<ConsumptionTable>>() {
            @Override
            public void onResponse(@NonNull Call<List<ConsumptionTable>> call,
                                   @NonNull Response<List<ConsumptionTable>> response) {
                List<ConsumptionTable> list = response.body();
                model.setTable2(list);
            }
            @Override
            public void onFailure(@NonNull Call<List<ConsumptionTable>> call, @NonNull Throwable t) {
                Log.i("onFailure: ", "Response not exist table 2");
            }
        });
    }


    public void loadDataTable3(final ConsolidateContractModel model){

        String date = "current";
        if (mDate != null)
            date = mDate;

        getApiService().getHydroStationTable(date).enqueue(new Callback<List<HydroStationTable>>() {
            @Override
            public void onResponse(@NonNull Call<List<HydroStationTable>> call,
                                   @NonNull Response<List<HydroStationTable>> response) {
                List<HydroStationTable> list = response.body();
                model.setTable3(list);
            }

            @Override
            public void onFailure(Call<List<HydroStationTable>> call, Throwable t) {
                Log.i("onFailure: ", "Response not exist table 3");
            }
        });
    }

    public void saveDate (String date){
        mDate = date;
    }

    public void setAuthToken(String authToken) {
        mAuthToken = authToken;
    }

}