package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Services;
import tubespbo.aisherviceapp.model.ServicesCreateRequest;
import tubespbo.aisherviceapp.repository.ServicesRepository;

@Service
public class ServicesService{
    
    @Autowired
    private ServicesRepository servicerepo;

    @Transactional
    public List<Services> getAll() {
        return this.servicerepo.findAll();
    }

    @Transactional
    public void createService(ServicesCreateRequest request) {
        Services service = new Services();
        service.setCatatankerusakan(request.getCatatankeruksan());
        service.setWaktumulai(request.getWaktumulai());
        service.setEstimasiselesai(request.getEstimasiwaktu());

        this.servicerepo.save(service);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        this.servicerepo.deleteById(id);
    }

}