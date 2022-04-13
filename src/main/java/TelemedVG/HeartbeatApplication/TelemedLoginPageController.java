package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.AppUser;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("")
public class TelemedLoginPageController {

    @Autowired
    AppUserRepository appUserRepository;

/*    @Autowired
    HealthRecordRepository healthRecordRepository; */

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        AppUser loginTryUser = new AppUser();
        loginTryUser.setPin("");
        model.addAttribute("user", loginTryUser);

        return "telemed_login_page";
    }

    /*@GetMapping("/get_id_for_login")
    public String userIdByLoginInfo(String eMail, String pin, Model model) {

        System.out.println("searching user with email: " + eMail + " and password: " + pin);

        AppUser tryLoginUser = appUserRepository.findByEmail(eMail);
        if (tryLoginUser == null) {
            System.out.println("no such email");
            return "redirect:/login";
        }

        if (tryLoginUser.geteMail() != eMail) {
            System.out.println("no user with such password and email");
            return "redirect:/login";
        } else {
            System.out.println("user found, id = " + tryLoginUser.getId());

            return "redirect:patient/______?id=" + tryLoginUser.getId();

        }
    }*/

}

