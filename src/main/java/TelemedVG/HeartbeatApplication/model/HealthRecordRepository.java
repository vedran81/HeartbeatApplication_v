package TelemedVG.HeartbeatApplication.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HealthRecordRepository extends CrudRepository<HealthRecord, Integer> {

    List<HealthRecord> findAll();

}
