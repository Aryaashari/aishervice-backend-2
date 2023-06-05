package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.repository.MontirRepository;

@Service
public class MontirService {
    
    @Autowired
    private MontirRepository montirRepo;

    @Transactional
    public List<Montir> getAll() {
        return this.montirRepo.findAll();
    }


    @Transactional
    public Montir getById(Long id) {
        return this.montirRepo.findById(id).orElse(null);
    }

}
