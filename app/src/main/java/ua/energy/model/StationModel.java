package ua.energy.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.energy.entity.Station;
import ua.energy.service.ServerAPI;
import ua.energy.service.ServiceGenerator;

public class StationModel {

    private List<Station> mList;

    //загрузка данных с сервера
    public List<Station> loadStations() {

        ServerAPI serverAPI = ServiceGenerator.createService(ServerAPI.class, "kmu", "EuroWind111");

        serverAPI.getConditionStations("current").enqueue(new Callback<List<Station>>() {

            @Override
            public void onResponse(Call<List<Station>> call, Response<List<Station>> response) {
                Log.i("==========\n", response.body().toString());
                mList = response.body();
            }

            @Override
            public void onFailure(Call<List<Station>> call, Throwable t) {
                //Log.i("Из респонса: ", "Респонс не был получен");
            }
        });
        return mList;
    }
}
