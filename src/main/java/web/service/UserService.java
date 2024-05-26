package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public void saveUser (User user);

    public User getUser (int id);

    public User deleteUser(int id);
}
