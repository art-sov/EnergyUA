package ua.energy.service.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import ua.energy.service.ApiService;

public class AuthorizationInterceptor implements Interceptor{

    private ApiService mApiService;
    private Session mSession;

    public AuthorizationInterceptor(ApiService apiService, Session session) {
        mApiService = apiService;
        mSession = session;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response mainResponse = chain.proceed(chain.request());

        if (mainResponse.code() == 401 || mainResponse.code() == 403) {
            mSession.invalidate();
        }

        return mainResponse;
    }
}
