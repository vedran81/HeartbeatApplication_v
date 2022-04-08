package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("patient")
public class HealthRecordController {

    @Autowired
    HealthRecordRepository repository;

    @GetMapping("/showHealthRecord")
    public String showAddRecord(Model model) {
        model.addAttribute("record", new HealthRecord()); // empty user for adding new

        return "patient/health_record";
    }

    @GetMapping("/add")
    public String add(HealthRecord oneHealthRecord) {
        System.out.println("Adding new record ...");
        repository.save(oneHealthRecord);
        return "redirect:/patient/list";
    }

}
