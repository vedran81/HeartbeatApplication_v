package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("add_health_record")
public class HealthRecordController {

    @Autowired
    HealthRecordRepository repository;

    @GetMapping("/add")
    public String add(HealthRecord oneHealthRecord, Model model) {

        model.addAttribute("records", repository.findAll());
        model.addAttribute("record", new HealthRecord());

        repository.save(oneHealthRecord);
        return "patient_information_entry";
    }
}
