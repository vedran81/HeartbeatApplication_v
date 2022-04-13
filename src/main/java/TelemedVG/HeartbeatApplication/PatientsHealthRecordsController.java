package TelemedVG.HeartbeatApplication;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;
import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("patient")
public class PatientsHealthRecordsController {

    @Autowired
    HealthRecordRepository healthRecordRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("records", healthRecordRepository.findAll());
        model.addAttribute("record", new HealthRecord()); // empty user for adding new

        return "patient/patients_health_records";
    }

    @GetMapping("/listRecordsForPatients")
    public String listRecordsForPatients(Model model) {
        System.out.println("Listing all records ...");
        model.addAttribute("records", healthRecordRepository.findAll());

        return "redirect:/list";
    }
}
