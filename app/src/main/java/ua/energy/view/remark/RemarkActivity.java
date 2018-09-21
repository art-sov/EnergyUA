package ua.energy.view.remark;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import ua.energy.R;
import ua.energy.service.ApiService;
import ua.energy.service.retrofit.AuthenticationInterceptor;
import ua.energy.util.DateUtil;
import ua.energy.view.login.LoginActivity;

public class RemarkActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String LOG_TAG = RemarkActivity.class.getName();
    private static final String BASE_URL = "http://disp.nec.energy.gov.ua/";
    private static final String KEY_DATE = "date";

    private TextView mMessage;
    private String mDate;
    private String authToken;

    Retrofit mRetrofit;

    @Inject
    SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remark);

        mPreferences = getSharedPreferences("dispatcher", Context.MODE_PRIVATE);
        authToken = mPreferences.getString("authToken", "");

        if (authToken.equals("")) {
            Intent intent = LoginActivity.newIntent(this);
            startActivity(intent);
        }

        if (savedInstanceState != null) {
            mDate = savedInstanceState.getString(KEY_DATE);
        }

        if (mDate == null) {
            mDate = "current";
        }

        mRetrofit = createRetrofit();

        mMessage = findViewById(R.id.tvRemarks);

        Calendar calendar = DateUtil.getCurrentCalendar();

        final DatePickerDialog datePickerDialog = new DatePickerDialog(this, this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        FloatingActionButton fab = findViewById(R.id.fab_activity_remark);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   datePickerDialog.show();
            }
        });
        loadRemarks();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        mDate = simpleDateFormat.format(calendar.getTime());
        Log.i(LOG_TAG, "Selected date: " + mDate);
        loadRemarks();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_DATE, mDate);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mDate = savedInstanceState.getString(KEY_DATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRetrofit = null;
    }

    //----------------------------------------------------------------------------------------
    // static methods
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, RemarkActivity.class);
        // put something
        return intent;
    }
    //----------------------------------------------------------------------------------------
    // private methods
    private void loadRemarks() {

        ApiService service = mRetrofit.create(ApiService.class);

        Call<String> stringCall = service.getRemarks(mDate);

        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

                if (response.isSuccessful()) {
                    String responseString = response.body();
                    mMessage.setText(responseString);
                }
            }
                @Override
                public void onFailure (@NonNull Call < String > call, @NonNull Throwable t){
                    Log.e(LOG_TAG, "Response not exist, Remark");
            }
        });
    }

    private Retrofit createRetrofit() {

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(authToken);

        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();

        if (!okhttpBuilder.interceptors().contains(interceptor)) {
            okhttpBuilder.addInterceptor(interceptor);
        }

        okhttpBuilder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 *1000, TimeUnit.MILLISECONDS);

        OkHttpClient okHttpClient = okhttpBuilder.build();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create());

        retrofitBuilder.client(okHttpClient);

        return retrofitBuilder.build();
    }
}
