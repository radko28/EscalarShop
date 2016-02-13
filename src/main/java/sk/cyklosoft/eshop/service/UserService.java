package sk.cyklosoft.eshop.service;

import java.util.List;

import sk.cyklosoft.eshop.vo.UserVO;

public interface UserService {

    List<UserVO> findAllUsers();

    String getWholeNameByUsername(String username);

    UserVO getUserById(String userId);

    void deleteUser(String userId);

    void addUser(UserVO userVO);

    void updateUser(UserVO userVO);

    boolean existUser(String username);

    void sendNewPassword(String username);

    String getUserIdByUsername(String username);
    
   

}
