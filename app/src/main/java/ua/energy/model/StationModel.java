package ua.energy.model;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.energy.app.App;
import ua.energy.entity.Station;
import ua.energy.presenter.StationContractModel;
import ua.energy.service.ApiService;
import ua.energy.service.ServiceGenerator;

public class StationModel {

    private String mDate;

    private ServiceGenerator mServiceGenerator;

    public StationModel(ServiceGenerator serviceGenerator) {
        mServiceGenerator = serviceGenerator;
    }

    //загрузка данных с сервера
    public void loadStations(final StationContractModel mStationContractModel) {

        String date = "current";
        if (mDate != null)
            date = mDate;

        ApiService apiService = mServiceGenerator.createService(ApiService.class,
                "kmu", "EuroWind111");

            //date format dd.MM.yyyy
            apiService.getConditionStations(date).enqueue(new Callback<List<Station>>() {

                @Override
                public void onResponse(@NonNull Call<List<Station>> call,
                                       @NonNull Response<List<Station>> response) {

                    List<Station> list = response.body();
                    Log.i("RESPONCE===\n", list.toString());
                    mStationContractModel.loadStationList(list);
                }

                @Override
                public void onFailure(@NonNull Call<List<Station>> call, Throwable t) {
                    Log.i("onFailure: ", "Response not exist");
                }
            });

            mDate = null;
    }

    public void saveDate (String date){
        mDate = date;
    }
}