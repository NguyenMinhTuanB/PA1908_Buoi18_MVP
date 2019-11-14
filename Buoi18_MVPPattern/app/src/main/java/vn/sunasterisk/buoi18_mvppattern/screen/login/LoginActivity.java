package vn.sunasterisk.buoi18_mvppattern.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import vn.sunasterisk.buoi18_mvppattern.R;
import vn.sunasterisk.buoi18_mvppattern.data.model.User;
import vn.sunasterisk.buoi18_mvppattern.screen.main.MainActivity;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener, LoginContract.View {

    private EditText mTextUsername;
    private EditText mTextPassword;
    private Button mButtonLogin;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponents();
        registerListeners();
    }

    private void registerListeners() {
        mButtonLogin.setOnClickListener(this);
    }

    private void initComponents() {
        mTextUsername = findViewById(R.id.text_username);
        mTextPassword = findViewById(R.id.text_password);
        mButtonLogin = findViewById(R.id.button_login);

        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                mLoginPresenter.handleLogin(
                        mTextUsername.getText().toString(),
                        mTextPassword.getText().toString()
                );
                break;
            default:
                break;
        }
    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(this, user.getUsername() + "login success!",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void loginFailure(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
