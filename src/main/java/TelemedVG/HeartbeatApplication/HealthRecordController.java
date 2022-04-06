package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/add_health_record")
public class HealthRecordController {

    @Autowired
    HealthRecordRepository repository;


    @GetMapping("/add")
    public String add(HealthRecord patientHealthRecordForm) {
        repository.save(patientHealthRecordForm);
        return "redirect:/LISTA SA ZAPISIMA";
    }
}
