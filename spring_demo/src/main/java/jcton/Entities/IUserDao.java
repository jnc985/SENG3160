package jcton.Entities;

import java.util.List;

public interface IUserDao{
    void addUser(User user);

    User getUser(int id);

    List<User> getAllUsers();
}
