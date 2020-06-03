package service;

import exception.DBException;
import model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public boolean updateUser(int id,String login, String password, String role, String name, int age);
    public boolean deleteUserById(int id);
    public boolean addUser(User user);
    public boolean authUser(User user) throws DBException;
    public boolean updateUser(int id, String name, int age);
    public User getUserByLogin(String login);
}
