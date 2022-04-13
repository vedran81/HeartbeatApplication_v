package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.AppUser;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;
import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Repository
@Controller
@RequestMapping("patient")
public class HealthRecordController {

    @Autowired
    HealthRecordRepository healthRecordRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/showHealthRecord")
    public String showAddRecord(Model model, HttpSession session) {
        AppUser user = (AppUser) session.getAttribute("user");

        if(user == null)
            return "redirect:/";

        model.addAttribute("record", new HealthRecord()); // empty user for adding new
        model.addAttribute("user", user); // empty user for adding new

        return "patient/health_record";
    }

    @GetMapping("/add")
    public String add(HealthRecord oneHealthRecord, HttpSession session) {
        AppUser user = (AppUser) session.getAttribute("user");

        if(user == null)
            return "redirect:/";

        System.out.println("Adding new record ...");

        oneHealthRecord.setAppUser(user);
        oneHealthRecord.setAutoDateOfInput(new Date());

        healthRecordRepository.save(oneHealthRecord);
        return "redirect:/patient/list";
    }
}
