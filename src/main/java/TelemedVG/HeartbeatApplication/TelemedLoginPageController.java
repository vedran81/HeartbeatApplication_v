package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.AppUser;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;
import TelemedVG.HeartbeatApplication.model.HealthRecordRepository;
import com.fasterxml.jackson.core.JsonPointer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("")
public class TelemedLoginPageController {

    @Autowired
    AppUserRepository appUserRepository;

/*    @Autowired
    HealthRecordRepository healthRecordRepository; */

    @GetMapping("/showLoginPage")
    public String showLoginPage(Model model) {
        AppUser loginTryUser = new AppUser();
        loginTryUser.setPin("");
        model.addAttribute("user", loginTryUser);

        return "telemed_login_page";
    }

    @GetMapping("/get_id_for_login")
    public String userIdByLoginInfo(String eMail, String pin, Model model) {

        System.out.println("searching user with email: " + eMail + " and pin: " + pin);

        List<AppUser> usersWithPin = appUserRepository.findAllByPin(pin);
        if (usersWithPin.size() == 0) {
            System.out.println("no such pin");
        } else {
            AppUser firstUserWithPin = usersWithPin.get(0);
            if (!Objects.equals(firstUserWithPin.geteMail(), eMail)) {
                System.out.println("pin and email not matching");
            } else {
                int userId = firstUserWithPin.getId();
                System.out.println("user found, id = " + userId);
            }
        }

        // e to treba taj userId proslijediti ovamo

        return "redirect:patient/list";
    }
}
