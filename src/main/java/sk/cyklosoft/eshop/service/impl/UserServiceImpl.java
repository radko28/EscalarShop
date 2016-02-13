package sk.cyklosoft.eshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.eshop.dao.AuthorityDao;
import sk.cyklosoft.eshop.dao.UserDao;
import sk.cyklosoft.eshop.domain.Authority;
import sk.cyklosoft.eshop.domain.User;
import sk.cyklosoft.eshop.service.UserService;
import sk.cyklosoft.eshop.util.EmailTypes;
import sk.cyklosoft.eshop.vo.UserVO;

@Service("userService")
@Component
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserDao userDao;
    @Autowired
    AuthorityDao authorityDao;
    

    @Override
    public List<UserVO> findAllUsers() {
        List<User> userList = userDao.findAllUsers();
        // copy
         List<UserVO> result = new ArrayList<UserVO>();
        for (User user : userList) {
            result.add(user.copy());
        }
        return result;
    }

    @Override
    public String getWholeNameByUsername(String username) {
        User user = userDao.findUserByUsername(username); 
        String wholeName = user.getFirstname() + " " + user.getLastname();
        return wholeName;
    }

    @Override
    public UserVO getUserById(String userId) {
        User user = userDao.findUserById(userId);
        UserVO result = user.copy();
        return result;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userDao.findUserById(userId);
        authorityDao.remove(user.getAuthorities());
        userDao.remove(user);
    }

    @Override
    public void addUser(UserVO userVO) {
        User user = new User();
        user.setFirstname(userVO.getFirstname());
        user.setLastname(userVO.getLastname());
        user.setUsername(userVO.getUsername());
        user.setPassword(userVO.getPassword());
        user.setEnabled(true);
        user.setCreated(new DateTime());
        userDao.save(user);
        
        Authority auth = new Authority();
        auth.setAuthority(userVO.getAuthorityType());
        auth.setUsername(userVO.getUsername());
        auth.setUsers(user);
        authorityDao.save(auth);
        sendUserMail(user,EmailTypes.USER_REGISTER);
    }

    @Override
    public void updateUser(UserVO userVO) {
        User user = userDao.findUserById(userVO.getUserId());
        Authority authority = user.getAuthorities();
        authority.setAuthority(userVO.getAuthorityType());
        authority.setUsername(userVO.getUsername());
        authorityDao.update(authority);
        user.setAuthorities(authority);
        user.setEnabled(userVO.isEnabled());
        user.setFirstname(userVO.getFirstname());
        user.setLastname(userVO.getLastname());
        user.setPassword(userVO.getPassword());
        user.setUsername(userVO.getUsername());
       
        userDao.update(user);

        
    }

    @Override
    public boolean existUser(String username) {
        User user = userDao.findUserByUsername(username); 
        return user == null ? false : true;
    }

    @Override
    public void sendNewPassword(String username) {
        //generate new password
        String password = "newpassword";
        User user = userDao.findUserByUsername(username);
        user.setPassword(password);
        sendUserMail(user,EmailTypes.NEW_PASSWORD);
        
    }

    private void sendUserMail(User user, EmailTypes emailType) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getUserIdByUsername(String username) {
        User user = userDao.findUserByUsername(username); 
        return user.getUserId();
    }

}
