package TelemedVG.HeartbeatApplication;

import TelemedVG.HeartbeatApplication.model.AppUser;
import TelemedVG.HeartbeatApplication.model.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("docdesk")
public class DocDeskController {

    @Autowired
    AppUserRepository repository;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("app_users", repository.findAll());

        return "docdesk/list";
    }


    @GetMapping("/add")
    public String add(AppUser userForm, Model model){

        repository.save(userForm);
        return "redirect:/docdesk/list";
    }

    @GetMapping("/show_add_form")
    public String showAddForm(AppUser userForm, Model model) {
        model.addAttribute("newUser", new AppUser());

        return "docdesk/show_add_form";
    }

}
