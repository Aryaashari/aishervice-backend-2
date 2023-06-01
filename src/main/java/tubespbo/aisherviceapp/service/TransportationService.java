package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tubespbo.aisherviceapp.entity.Transportation;
import tubespbo.aisherviceapp.repository.CustomerRepository;
import tubespbo.aisherviceapp.repository.TransportationRepository;

@Service
public class TransportationService {
    
    @Autowired
    private TransportationRepository transportationRepo;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Transportation> getAll() {
        return this.transportationRepo.findAll();
    }

    public Transportation getByNoPlat(String noPlat) {
        return this.transportationRepo.findById(noPlat).orElseThrow(null);
    }

}
