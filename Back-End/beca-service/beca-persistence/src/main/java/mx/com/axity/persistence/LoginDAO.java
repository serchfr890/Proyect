package mx.com.axity.persistence;

import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import org.springframework.data.repository.CrudRepository;

public interface LoginDAO extends CrudRepository<LoginDO, Long> {
}
