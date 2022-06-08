package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void update(User user);
    void delete(long id);
    User getUserById(long id);
}
