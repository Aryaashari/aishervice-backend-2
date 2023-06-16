package tubespbo.aisherviceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import tubespbo.aisherviceapp.entity.Admin;
import tubespbo.aisherviceapp.service.AdminService;
import tubespbo.aisherviceapp.service.AuthService;

@Controller
public class AuthController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AuthService authService;
    
    @GetMapping("/")
    public String loginView() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
        boolean isTrue = this.authService.login(username, password, request);

        if (isTrue) {
            return "redirect:/index" ;
        }
        
        return "redirect:/login";
    }

}
