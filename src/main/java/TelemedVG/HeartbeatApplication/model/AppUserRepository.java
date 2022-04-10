package TelemedVG.HeartbeatApplication.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    List<AppUser> findAll();
    List<AppUser> findAllByType(int type);
    List<AppUser> findAllById(int id);

}

