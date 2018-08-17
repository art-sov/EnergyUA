package ua.energy.service.dagger;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.energy.R;
import ua.energy.app.App;
import ua.energy.app.dagger.AppScope;
import ua.energy.service.ServiceGenerator;

@Module
public class ApiModule {

    @Provides
    @AppScope
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 *1000, TimeUnit.MILLISECONDS);

        return builder;
    }

    @Provides
    @AppScope
    public Retrofit.Builder provideRetrofit(App app) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(app.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create());

        return builder;
    }

    @Provides
    @AppScope
    public ServiceGenerator provideServiceGenerator (Retrofit.Builder retrofitBuilder,
                                                     OkHttpClient.Builder okHttpClientBuilder) {
        return new ServiceGenerator(retrofitBuilder, okHttpClientBuilder);
    }



}
