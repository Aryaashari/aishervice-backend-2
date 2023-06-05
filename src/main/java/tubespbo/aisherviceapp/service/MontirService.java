package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.model.MontirCreateRequest;
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

    @Transactional
    public void create(MontirCreateRequest request) {
        Montir montir = new Montir();

        montir.setName(request.getNama());
        montir.setNoHp(request.getNoHp());
        montir.setAlamat(request.getAlamat());
        montir.setEmail(request.getEmail());
        montir.setShift(request.getShift());
        this.montirRepo.save(montir);
    }

}
