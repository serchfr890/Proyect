package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;

import java.util.List;

public interface IbecaService {

    //Methods for Users
    UserDO getUserById(Long id);    //Get user by Id
    void createUser(UserDO userDO);
    boolean updateUser(UserDO userDO);
    void deleteUser(Long id);

    //Methods for Login
    void createLogin(LoginDO loginDO);
}
