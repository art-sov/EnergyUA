package ua.energy.api;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import ua.energy.entity.Station;
import ua.energy.service.ApiService;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public ApiService provideApiService(){
        //todo удалить реализацию метода

        return new ApiService() {
            @Override
            public Call<List<Station>> getConditionStations(String date) {
                return null;
            }
        };
    }
}
