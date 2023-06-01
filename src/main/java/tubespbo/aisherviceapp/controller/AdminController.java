package tubespbo.aisherviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tubespbo.aisherviceapp.entity.Admin;
import tubespbo.aisherviceapp.model.AdminCreateRequest;
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

    @PostMapping("/admin")
    public String create(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
        AdminCreateRequest request = new AdminCreateRequest();
        request.setUsername(username);
        request.setPassword(password);
        this.adminService.createAdmin(request);
        return "redirect:/admin";
    }

}
