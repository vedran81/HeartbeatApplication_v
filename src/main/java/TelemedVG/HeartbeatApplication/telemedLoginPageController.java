package TelemedVG.HeartbeatApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("landing_page")
public class telemedLoginPageController {
    @GetMapping("/showLoginPage")
    public String showLoginPage() {

        return "patient/telemed_login_page";
    }
}
