package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import jdk.nashorn.internal.ir.RuntimeNode;
import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;

    //*******************************************Methods for CRUD Users*************************************************
    //Create a user
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public  ResponseEntity createUser(@RequestBody UserTO userTO){
        LOG.info("****Create User****");
        this.IbecaFacade.createUser(userTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //Read a user by ID
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getUserById(@RequestParam(value = "id") Long id){
        LOG.info("*****Get user by id******");
        UserTO userTO = this.IbecaFacade.getUserById(id);
        return new ResponseEntity<>(userTO, HttpStatus.OK);
    }

    //Update User
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@RequestBody UserTO userTO){
        LOG.info("******Update User*****");
        if(this.IbecaFacade.updateUser(userTO)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //Delete User
    @RequestMapping(value = "/user" , method = RequestMethod.DELETE, produces = "application/json")
    public  ResponseEntity deleteUser (@RequestBody UserTO userTO){
        LOG.info("******Update User");
        this.IbecaFacade.deleteUser(userTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    //********************************************Methods for Login*****************************************************
    //Create a Login
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createLogin (@RequestBody LoginTO loginTO){
        LOG.info("***********Create a Login");
        this.IbecaFacade.createLogin(loginTO);
        LOG.info("--->>> " + loginTO.getUser());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
