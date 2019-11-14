package vn.sunasterisk.buoi18_mvppattern.screen.login;

import vn.sunasterisk.buoi18_mvppattern.data.model.User;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void handleLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            mView.loginFailure("Username or Password not empty!");
            return;
        }

        //truy van database hoac lay du lieu tu tren server
        // neu tai khoan da ton tai thi login thanh cong.
        if (username.equals("pa1908") && password.equals("123456")) {
            mView.loginSuccess(new User(username, password));
        } else {
            mView.loginFailure("Username or password not match!");
        }
    }
}
