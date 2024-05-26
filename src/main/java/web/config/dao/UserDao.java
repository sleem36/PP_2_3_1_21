package web.config.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> allUser ();

    public void saveUser(User user);

    public User getUser(int id);

    public User deleteUser(int id);
}
