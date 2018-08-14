package ua.energy.service.retrofit;

public interface Session {

    boolean isLoggedIn();

    void saveToken(String token);

    String getToken();

    void saveUserName(String userName);

    String getUserName();

    void savePassword(String password);

    String getPassword();

    void invalidate();

}
