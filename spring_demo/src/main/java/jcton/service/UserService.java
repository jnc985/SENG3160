package jcton.service;

import jcton.Entities.IUserDao;
import jcton.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public List<User> getAll(){
        return userDao.getAllUsers();
    }

    @Override
    public void register(User u){
        userDao.addUser(u);
    }
}
