package tubespbo.aisherviceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tubespbo.aisherviceapp.entity.Admin;
import tubespbo.aisherviceapp.repository.AdminRepository;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepo;

    @Transactional
    public Admin getDataByUsername(String username) {
        return this.adminRepo.findById(username).orElseThrow(null);
    }
}