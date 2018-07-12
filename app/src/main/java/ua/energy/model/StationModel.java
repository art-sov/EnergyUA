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

    private String mDate;

    //загрузка данных с сервера
    public void loadStations(final StationContractModel mStationContractModel) {

        String date = "current";
        if (mDate != null)
            date = mDate;

        //TODO реализовать синглтон
        ServerAPI serverAPI = ServiceGenerator.createService(ServerAPI.class, "kmu", "EuroWind111");



            //date format dd.MM.yyyy
            serverAPI.getConditionStations(date).enqueue(new Callback<List<Station>>() {

                @Override
                public void onResponse(Call<List<Station>> call, Response<List<Station>> response) {

                    List<Station> list = response.body();
                    Log.i("RESPONCE===\n", list.toString());
                    mStationContractModel.loadStationList(list);
                }

                @Override
                public void onFailure(Call<List<Station>> call, Throwable t) {
                    Log.i("onFailure: ", "Response not exist");
                }
            });

            mDate = null;
    }

    public void saveDate (String date){
        mDate = date;
    }
}
