package mx.com.axity.services.service.impl;

import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.LoginDAO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    LoginDAO loginDAO;



    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDO getUserById(Long id) {
        UserDO userDO = this.userDAO.findById(id).get();
        return userDO;
    }

    @Override
    public void createUser(UserDO userDO) {
        this.userDAO.save(userDO);
    }

    @Override
    public boolean updateUser(UserDO userDO) {
        Long id = userDO.getId();
        UserDO userDOFound = this.userDAO.findById(id).get();
        if (userDOFound != null){
            this.userDAO.save(userDO);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void deleteUser(Long id) {
        this.userDAO.deleteById(id);
    }

    //Methods for Logins
    @Override
    public void createLogin(LoginDO loginDO) {
        this.loginDAO.save(loginDO);
    }

}
