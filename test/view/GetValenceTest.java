package view;

import app.Main;
import data_access.UserDataAccessObject;

import javax.swing.*;

public class GetValenceTest {

    String id = "312x6t6bf2nas7jiahsll6ajmjba"; // this is the id for my tester account
    UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
    @org.junit.Test
    public void testDAOGetValence() throws Exception {
        assert(userDataAccessObject.getValence(id, "short_term").equals(0.7));
    }

}
