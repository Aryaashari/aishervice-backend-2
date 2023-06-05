package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tubespbo.aisherviceapp.entity.Customer;
import tubespbo.aisherviceapp.entity.Transportation;
import tubespbo.aisherviceapp.model.TransportationCreateRequest;
import tubespbo.aisherviceapp.repository.CustomerRepository;
import tubespbo.aisherviceapp.repository.TransportationRepository;

@Service
public class TransportationService {
    
    @Autowired
    private TransportationRepository transportationRepo;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Transportation> getAll() {
        return this.transportationRepo.findAll();
    }

    @Transactional
    public Transportation getByNoPlat(String noPlat) {
        return this.transportationRepo.findById(noPlat).orElseThrow(null);
    }

    @Transactional
    public void createTransportation(TransportationCreateRequest request) {
        Customer customer = this.customerRepository.findById(request.getIdPelanggan()).orElseThrow(null);
        Transportation transportation = new Transportation();
        transportation.setCustomer(customer);
        transportation.setJenisKendaraan(request.getJenisKendaraan());
        transportation.setNoPlat(request.getNoPlat());
        transportation.setNomorMesin(request.getNomorMesin());

        this.transportationRepo.save(transportation);
    }

}
