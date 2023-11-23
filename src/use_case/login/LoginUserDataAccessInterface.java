package use_case.login;

import entity.User;

public interface LoginUserDataAccessInterface {
    void save (User user);
    User get(String id);
}
