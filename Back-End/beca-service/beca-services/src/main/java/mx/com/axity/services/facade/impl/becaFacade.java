package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired
    private IbecaService becaService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserTO getUserById(Long id) {
        UserDO userDO = this.becaService.getUserById(id);
        UserTO userTO = this.modelMapper.map(userDO,UserTO.class);
        return userTO;
    }

    @Override
    public void createUser(UserTO userTO) {
        UserDO userDO = this.modelMapper.map(userTO, UserDO.class);
        this.becaService.createUser(userDO);
    }

    @Override
    public boolean updateUser(UserTO userTO) {
        UserDO userDO = this.modelMapper.map(userTO, UserDO.class);
        return this.becaService.updateUser(userDO);
    }

    @Override
    public void deleteUser(UserTO userTo) {
        Long id = userTo.getId();
        this.becaService.deleteUser(id);
    }

    @Override
    public void createLogin(LoginTO loginTO) {
        LoginDO loginDO = this.modelMapper.map(loginTO, LoginDO.class);
        this.becaService.createLogin(loginDO);
    }
}
