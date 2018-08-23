package ua.energy.view.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.energy.R;
import ua.energy.app.App;
import ua.energy.entity.User;
import ua.energy.service.ApiService;
import ua.energy.service.ServiceGenerator;
import ua.energy.view.station.StationActivity;

public class LoginActivity extends AppCompatActivity{

    public static final String LOG_TAG = LoginActivity.class.getName();

    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    ServiceGenerator mServiceGenerator;

    private EditText mUsernameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        App.getApp(this).getComponentsHolder().getLoginActivityComponent().inject(this);

        mUsernameView = (EditText) findViewById(R.id.et_username);
        mPasswordView = (EditText) findViewById(R.id.et_password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    return true;
                }
                return false;
            }
        });

        Button signInButton = (Button) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = mUsernameView.getText().toString();
                String password = mPasswordView.getText().toString();

                mSharedPreferences = getSharedPreferences("dispatcher", Context.MODE_PRIVATE);
                final SharedPreferences.Editor editor = mSharedPreferences.edit();

                final String authToken = Credentials.basic(username, password);

                ApiService apiService = mServiceGenerator.createService(ApiService.class, authToken);

                apiService.isAuthorization().enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        editor.putString("authToken", authToken);
                        editor.apply();

                        int responseCode = response.code();


                        Intent intent = new Intent(LoginActivity.this, StationActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        showMessage("Не верный логин или пароль");
                    }
                });




            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isFinishing()) {
            App.getApp(this).getComponentsHolder().releaseLoginActivityComponent();
        }
    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}

