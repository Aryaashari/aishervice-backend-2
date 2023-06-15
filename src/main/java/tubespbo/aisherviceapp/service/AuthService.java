package tubespbo.aisherviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import tubespbo.aisherviceapp.entity.Admin;
import tubespbo.aisherviceapp.repository.AdminRepository;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class AuthService {
    
    @Autowired
    private AdminRepository adminRepo;

    @Transactional
    public boolean login(String username, String password, HttpServletRequest request) {
        Admin admin = this.adminRepo.findById(username).orElse(null);

        if (admin == null || !BCrypt.checkpw(password, admin.getPassword())) {
            return false;
        }

        request.getSession().setAttribute("admin", admin);
        return true;
    }

}
