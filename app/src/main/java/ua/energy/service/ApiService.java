package ua.energy.service;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.energy.entity.ConsolidateTable;
import ua.energy.entity.ConsumptionTable;
import ua.energy.entity.HydroStationTable;
import ua.energy.entity.MaxTime;
import ua.energy.entity.Station;
import ua.energy.entity.User;

public interface ApiService {

    @GET("/mobile/condition")
    Call<List<Station>> getConditionStations(@Query("date") String  date);

    @GET("/mobile/authorization")
    Call<User> isAuthorization();

    //ConsolidateActivity

    @GET("/mobile/consolidate_balance")
    Call<List<ConsolidateTable>> getBalanceTable(@Query("date") String date);

    @GET("/mobile/consolidate_consumption")
    Call<List<ConsumptionTable>> getConsumptionControlTable(@Query("date") String date);

    @GET("/mobile/consolidate_hydrostation")
    Call<List<HydroStationTable>> getHydroStationTable(@Query("date") String date);

    @GET("/mobile/consolidate_consumption_maxtime")
    Call<MaxTime> getTimeMax(@Query("date") String date);

}
