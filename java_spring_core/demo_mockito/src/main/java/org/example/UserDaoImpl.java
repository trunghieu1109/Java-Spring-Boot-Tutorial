package org.example;

public class UserDaoImpl implements UserDao {
    public boolean createUser(String email) {

        if (email.length() > 5) {
            return true;
        } else {
            return false;
        }

    }
}
