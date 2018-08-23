package ua.energy.service;

import android.text.TextUtils;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import ua.energy.service.retrofit.AuthenticationInterceptor;

public class ServiceGenerator {

    Retrofit.Builder retrofitBuilder;
    OkHttpClient.Builder httpClientBuilder;
    Retrofit retrofit;

    public ServiceGenerator(Retrofit.Builder retrofitBuilder, OkHttpClient.Builder httpClientBuilder) {
        this.retrofitBuilder = retrofitBuilder;
        this.httpClientBuilder = httpClientBuilder;
    }

    public <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null, null);
    }

    public <S> S createService(Class<S> serviceClass, String username, String password){
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            String authToken = Credentials.basic(username, password);
            return createService(serviceClass, authToken);
        }
        return createService(serviceClass, null);
    }

    public <S> S createService(Class<S> serviceClass, final String authToken){

        retrofitBuilder.client(httpClientBuilder.build());
        retrofit = retrofitBuilder.build();

        if (!TextUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptor = new AuthenticationInterceptor(authToken);

                if (!httpClientBuilder.interceptors().contains(interceptor)) {
                httpClientBuilder.addInterceptor(interceptor);
                retrofitBuilder.client(httpClientBuilder.build());
                retrofit = retrofitBuilder.build();
            }
        }
        return retrofit.create(serviceClass);
    }
}
