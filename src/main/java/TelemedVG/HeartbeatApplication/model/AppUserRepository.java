package TelemedVG.HeartbeatApplication.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    List<AppUser> findAll();
}
