package by.chernyavski.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String email, String password);

}
