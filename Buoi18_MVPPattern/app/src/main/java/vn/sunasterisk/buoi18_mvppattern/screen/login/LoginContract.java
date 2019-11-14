package vn.sunasterisk.buoi18_mvppattern.screen.login;

import vn.sunasterisk.buoi18_mvppattern.data.model.User;

public interface LoginContract {

    interface View {
        void loginSuccess(User user);

        void loginFailure(String msg);
    }

    interface Presenter {
        void handleLogin(String username, String password);
    }
}
