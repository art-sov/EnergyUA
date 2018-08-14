package ua.energy.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.energy.entity.Station;

public interface ApiService {

    String BASE_URL = "http://disp.nec.energy.gov.ua/";

    @GET("/mobile/condition")
    Call<List<Station>> getConditionStations(@Query("date") String  date);
}