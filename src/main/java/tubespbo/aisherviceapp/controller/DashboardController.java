package tubespbo.aisherviceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currentPage", "index");
        return "index";
    }

}
