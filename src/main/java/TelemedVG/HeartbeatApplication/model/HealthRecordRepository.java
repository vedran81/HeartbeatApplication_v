package TelemedVG.HeartbeatApplication.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HealthRecordRepository<H, I extends Number> extends CrudRepository<HealthRecord, Integer> {

    List<HealthRecord> findAll();
    List<HealthRecord> findAllRecordsById(int id);

}
