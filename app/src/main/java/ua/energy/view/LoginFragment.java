package ua.energy.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ua.energy.R;

public class LoginFragment extends Fragment{

    private EditText mEditTextLogin;
    private EditText mEditTextPassword;
    private Button mButtonLogin;

    private String login;
    private String password;

    private SharedPreferences mPreferences;

    public static final String LOGIN_TEXT = "login";
    public static final String PASSWORD_TEXT = "password";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mEditTextLogin = (EditText) view.findViewById(R.id.et_login);
        mEditTextLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                login = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mEditTextPassword = (EditText) view.findViewById(R.id.et_password);
        mEditTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mButtonLogin = (Button) view.findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //todo передать логин пароль сервису, получить токен и сохранить его в преференсах
                Toast.makeText(getActivity(), "login: " + login + "\npassword: " + password, Toast.LENGTH_LONG).show();

                mPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putString(LOGIN_TEXT, login);
                editor.putString(PASSWORD_TEXT, password);
                editor.apply();
            }
        });
        return view;
    }
}
