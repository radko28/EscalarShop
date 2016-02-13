package sk.cyklosoft.eshop.dao;

import java.util.List;

import sk.cyklosoft.eshop.domain.User;



public interface UserDao {
    
    public User findUserById(String userId);

    public void save(User user);

    public void remove(User user);
    
    public void update(User user);

    public List<User> findAllUsers();

    public User findUserByUsername(String username);

}
