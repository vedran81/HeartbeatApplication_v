package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("add_health_record")
public class PatientsHealthRecordsController {

    @Autowired
    HealthRecordRepository repository;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("Listing all records ...");

        model.addAttribute("records", repository.findAll());
        model.addAttribute("record", new HealthRecord()); // empty user for adding new

        return "patientsHealthRecords";
    }
}