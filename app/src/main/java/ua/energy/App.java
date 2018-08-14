package ua.energy;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.energy.service.ApiService;
import ua.energy.service.retrofit.AuthenticationListener;
import ua.energy.service.retrofit.AuthorizationInterceptor;
import ua.energy.service.retrofit.InternetConnectionListener;
import ua.energy.service.retrofit.NetworkConnectionInterceptor;
import ua.energy.service.retrofit.Session;
import ua.energy.service.retrofit.TokenRenewInterceptor;

public class App extends Application {

    private Session mSession;
    private ApiService mApiService;
    private HttpLoggingInterceptor mLoggingInterceptor;
    private InternetConnectionListener mInternetConnectionListener;
    private AuthenticationListener mAuthenticationListener;

    @Override
    public void onCreate() {
        super.onCreate();
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

    public ApiService getApiService() {
        if (mApiService == null) {
            mApiService = provideRetrofit(ApiService.BASE_URL).create(ApiService.class);
        }
        return mApiService;
    }

    public Session getSession() {
        if (mSession == null) {
            mSession = new Session() {
                @Override
                public boolean isLoggedIn() {

                    // check if token exist or not
                    // return true if exist otherwise false
                    // assuming that token exists
                    return true;
                }

                @Override
                public void saveToken(String token) {
                    // save the token
                }

                @Override
                public String getToken() {
                    // return the token that was saved earlier
                    String token = null;
                    return token;
                }

                @Override
                public void saveUserName(String userName) {

                }

                @Override
                public String getUserName() {
                    String userName = "kmu";
                    return userName;
                }

                @Override
                public void savePassword(String password) {

                }

                @Override
                public String getPassword() {
                    String password = "EuroWind111";
                    return password;
                }

                @Override
                public void invalidate() {
                    // get called when user become logged out
                    // delete token and other user info
                    // (i.e: email, password)
                    // from the storage

                    // sending logged out event to it's listener
                    // i.e: Activity, Fragment, Service
                    if (mAuthenticationListener != null) {
                        mAuthenticationListener.onUserLoggedOut();
                    }
                }
            };
        }
        return mSession;
    }

    //---------------------------------------------------------------------------
    // private methods
    private Retrofit provideRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);


        // логирование http запросов
        mLoggingInterceptor = new HttpLoggingInterceptor();

        mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (!okHttpClientBuilder.interceptors().contains(mLoggingInterceptor)) {
            okHttpClientBuilder.addInterceptor(mLoggingInterceptor);
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
        okHttpClientBuilder.addInterceptor(new TokenRenewInterceptor(mSession));

        //
        AuthorizationInterceptor authorizationInterceptor = new AuthorizationInterceptor(getApiService(), getSession());
        if (!okHttpClientBuilder.interceptors().contains(authorizationInterceptor)) {
            okHttpClientBuilder.addInterceptor(new AuthorizationInterceptor(getApiService(), getSession()));
        }

        return okHttpClientBuilder.build();
    }

    private boolean isInternetAvailable() {

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    //todo реализовать синглтон презентера для станций ???????


}
