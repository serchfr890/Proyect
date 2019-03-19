package mx.com.axity.services.facade;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;

public interface IbecaFacade {

    //Methods for Users
    UserTO getUserById(Long id);
    void createUser(UserTO userTO);
    boolean updateUser(UserTO userTO);
    void deleteUser(UserTO userTO);

    //Methods for Logins
    void createLogin(LoginTO loginTO);
}
