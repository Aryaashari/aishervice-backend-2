package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tubespbo.aisherviceapp.entity.Admin;
import tubespbo.aisherviceapp.model.AdminCreateRequest;
import tubespbo.aisherviceapp.repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepo;

    @Transactional
    public List<Admin> getAll() {
        return this.adminRepo.findAll();
    }

    @Transactional
    public Admin getDataByUsername(String username) {
        return this.adminRepo.findById(username).orElseThrow(null);
    }

    @Transactional
    public void createAdmin(AdminCreateRequest request) {
        Admin admin = new Admin();
        admin.setUsername(request.getUsername());
        admin.setPassword(request.getPassword());
        this.adminRepo.save(admin);
    }

    @Transactional
    public void deleteAdmin(String username) {
        this.adminRepo.deleteById(username);
    }
}