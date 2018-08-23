package ua.energy.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.energy.entity.Station;
import ua.energy.entity.User;

public interface ApiService {

    @GET("/mobile/condition")
    Call<List<Station>> getConditionStations(@Query("date") String  date);

    @GET("/mobile/authorization")
    Call<User> isAuthorization();
}
