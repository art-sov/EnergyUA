package ua.energy;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.energy.service.ApiService;
import ua.energy.service.retrofit.AuthenticationInterceptor;
import ua.energy.service.retrofit.AuthenticationListener;
import ua.energy.service.retrofit.InternetConnectionListener;
import ua.energy.service.retrofit.NetworkConnectionInterceptor;

public class App extends Application {

    private static App instance;

    private static AppComponent appComponent;


    private ApiService mApiService;
    private InternetConnectionListener mInternetConnectionListener;
    private AuthenticationListener mAuthenticationListener;

    private Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private Retrofit mRetrofit = retrofitBuilder.build();

    private OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();


    public ApiService getApiService (ApiService apiService) {

        if (mApiService == null) {
            mApiService = getApiService(apiService, null, null);
        }
        return mApiService;
    }

    public ApiService getApiService(ApiService apiService, String username, String password) {

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            String authToken = Credentials.basic(username, password);
            return getApiService(apiService, authToken);
        }
        return getApiService(apiService, null);
    }

    public ApiService getApiService(ApiService apiService, String authToken) {

        if (!TextUtils.isEmpty(authToken)) {
            AuthenticationInterceptor authenticationInterceptor = new AuthenticationInterceptor(authToken);

            if (!okHttpClientBuilder.interceptors().contains(authenticationInterceptor)){
                okHttpClientBuilder.addInterceptor(authenticationInterceptor);
            }
        }

        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);

        // логирование http запросов
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (!okHttpClientBuilder.interceptors().contains(loggingInterceptor)) {
            okHttpClientBuilder.addInterceptor(loggingInterceptor);
        }

        // проверка наличия подключения к интернету (слушатель)
        okHttpClientBuilder.addInterceptor(new NetworkConnectionInterceptor() {
            @Override
            public boolean isInternetAvailable() {
                return App.this.isInternetAvailable();
            }

            @Override
            public void onInternetAvailable() {
                if (mInternetConnectionListener != null)
                    mInternetConnectionListener.onInternetUnavailable();
            }
        });

        retrofitBuilder.client(okHttpClientBuilder.build());
        mRetrofit = retrofitBuilder.build();

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        appComponent = DaggerAppComponent.create();
    }

    public void setInternetConnectionListener(InternetConnectionListener listener) {
        mInternetConnectionListener = listener;
    }

    public void setAuthenticationListener (AuthenticationListener authenticationListener) {
        mAuthenticationListener = authenticationListener;
    }

    public void removeInternetConnectionListener() {
        mInternetConnectionListener = null;
    }


    private boolean isInternetAvailable() {

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
