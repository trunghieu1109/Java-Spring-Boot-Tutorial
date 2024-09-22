package org.example;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public String createUser(String email) {
        boolean isSucces = userDao.createUser(email);

        if (isSucces) {
            return "Create user successfully";
        } else {
            return "Can't create user with this email";
        }
    }

}
