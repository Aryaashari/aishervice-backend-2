package tubespbo.aisherviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tubespbo.aisherviceapp.entity.Admin;
import tubespbo.aisherviceapp.service.AdminService;

import java.util.List;

@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String index(Model model) {
        List<Admin> listAdmin = this.adminService.getAll();
        model.addAttribute("currentPage", "admin");
        model.addAttribute("listAdmin", listAdmin);
        return "admin";
    }

}
