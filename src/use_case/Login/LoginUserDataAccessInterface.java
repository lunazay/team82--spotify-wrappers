package use_case.Login;

import entity.User;

public interface LoginUserDataAccessInterface {
    void save (User user);
    User get(String id);
}
