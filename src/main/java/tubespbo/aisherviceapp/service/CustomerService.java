package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Customer;
import tubespbo.aisherviceapp.model.CustomerCreateRequest;
import tubespbo.aisherviceapp.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepo;

    @Transactional
    public List<Customer> getAll() {
        return this.customerRepo.findAll();
    }

    @Transactional
    public void createCustomer(CustomerCreateRequest request) {
        Customer customer = new Customer();
        customer.setNama(request.getNama());
        customer.setNoHp(request.getNoHp());
        customer.setAlamat(request.getAlamat());
        customer.setEmail(request.getEmail());

        this.customerRepo.save(customer);
    }

    @Transactional
    public void deleteCustomer(Long id) {
        this.customerRepo.deleteById(id);
    }

}
