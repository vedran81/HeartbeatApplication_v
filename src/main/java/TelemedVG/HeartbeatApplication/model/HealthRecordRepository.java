package TelemedVG.HeartbeatApplication.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface HealthRecordRepository extends CrudRepository<HealthRecord, Integer> {

    List<HealthRecord> findAll();
    List<HealthRecord> findAllRecordsByAppUserId(int id);

}
