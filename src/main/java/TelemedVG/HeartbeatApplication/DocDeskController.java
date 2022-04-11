package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.HealthRecord;
import TelemedVG.HeartbeatApplication.model.AppUser;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Service("DocDeskController")
@Controller
@RequestMapping("docdesk")
public class DocDeskController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    HealthRecordRepository healthRecordRepository;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("app_users", appUserRepository.findAllByType(1));

        return "docdesk/list";
    }

    @GetMapping("/add")
    public String add(AppUser userForm){

        appUserRepository.save(userForm);
        return "redirect:/docdesk/list";
    }

    @GetMapping("/show_add_form")
    public String showAddForm(AppUser userForm, Model model) {
        model.addAttribute("newUser", new AppUser());

        return "docdesk/show_add_form";
    }

    @GetMapping("/show_patient_information")
    public String showPatientInformationById(Model model, int userId) {
        model.addAttribute("app_users", appUserRepository.findAllById(userId));
        model.addAttribute("record", healthRecordRepository.findAllRecordsByAppUserId(userId));

        return "docdesk/show_patient_information";
    }

    @GetMapping("/show_pressure_add_form")
    public String showPressureAddForm(Model model) {
        model.addAttribute("newPressure", new HealthRecord());

        return "docdesk/show_pressure_add_form";
    }

    @GetMapping("/save_pressure")
    public String savePressure(HealthRecord pressureForm) {
        healthRecordRepository.save(pressureForm);

        return "redirect:/docdesk/show_patient_information";
    }
}
