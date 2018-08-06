package jcton.service;

import jcton.Entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    void register(User user);

}
