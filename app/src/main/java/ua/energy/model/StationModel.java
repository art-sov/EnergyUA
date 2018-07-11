package ua.energy.model;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.energy.entity.Station;
import ua.energy.presenter.StationContractModel;
import ua.energy.service.ServerAPI;
import ua.energy.service.ServiceGenerator;

public class StationModel {

    //загрузка данных с сервера
    public void loadStations(final StationContractModel mStationContractModel) {

        //TODO реализовать синглтон
        ServerAPI serverAPI = ServiceGenerator.createService(ServerAPI.class, "kmu", "EuroWind111");

        serverAPI.getConditionStations("current").enqueue(new Callback<List<Station>>() {

            @Override
            public void onResponse(Call<List<Station>> call, Response<List<Station>> response) {

                //Log.i("==========\n", response.body().toString());
                List<Station> list = response.body();
                Log.i("RESPONCE===\n", list.toString());
                mStationContractModel.loadStationList(list);
            }

            @Override
            public void onFailure(Call<List<Station>> call, Throwable t) {
                Log.i("onFailure: ", "Респонс не был получен");
            }
        });
    }
}
