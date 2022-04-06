package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.AppUser;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app_user")
public class AppUserController {

    @Autowired
    AppUserRepository repository;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("user", repository.findAll());
        model.addAttribute("newUser", new AppUser());

        return "app_user";
    }

    @GetMapping("/add")
    public String add(AppUser userForm) {

        repository.save(userForm);
        return "redirect:/app_user/list";
    }

}
