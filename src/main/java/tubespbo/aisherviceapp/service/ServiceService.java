package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tubespbo.aisherviceapp.entity.Customer;
import tubespbo.aisherviceapp.entity.Montir;
import tubespbo.aisherviceapp.entity.Progress;
import tubespbo.aisherviceapp.entity.Transaksi;
import tubespbo.aisherviceapp.model.ServiceCreateRequest;
import tubespbo.aisherviceapp.repository.CustomerRepository;
import tubespbo.aisherviceapp.repository.MontirRepository;
import tubespbo.aisherviceapp.repository.ProgressRepository;
import tubespbo.aisherviceapp.repository.ServiceRepository;
import tubespbo.aisherviceapp.repository.TransaksiRepository;

@Service
public class ServiceService {
    
    @Autowired
    private ServiceRepository serviceRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private MontirRepository montirRepo;

    @Autowired
    private ProgressRepository progressRepo;

    @Autowired
    private TransaksiRepository transaksiRepo;

    @Transactional
    public List<tubespbo.aisherviceapp.entity.Service> getAll() {
        return this.serviceRepo.findAll();
    }

    @Transactional
    public tubespbo.aisherviceapp.entity.Service getById(Long id) {
        return this.serviceRepo.findById(id).orElse(null);
    }

    @Transactional
    public void create(ServiceCreateRequest request) {
        tubespbo.aisherviceapp.entity.Service service = new tubespbo.aisherviceapp.entity.Service();
        Customer customer = this.customerRepo.findById(request.getIdPelanggan()).orElse(null);
        Montir montir = this.montirRepo.findById(request.getIdMontir()).orElse(null);

        service.setCustomer(customer);
        service.setMontir(montir);
        service.setCatatanKerusakan(request.getCatatanKerusakan());
        service.setWaktuMulai(request.getWaktuMulai());
        service.setEstimasiSelesai(request.getEstimasiSelesai());

        service = this.serviceRepo.save(service);

        // create progress
        Progress progress = new Progress();
        progress.setService(service);
        progress.setCatatan_proses("Sedang dikerjakan");
        progress.setWaktu_progress(request.getEstimasiSelesai());
        this.progressRepo.save(progress);

        // create transaksi
        Transaksi transaksi = new Transaksi();
        transaksi.setService(service);
        transaksi.setStatus("belum lunas");
        transaksi.setTotal(request.getTotalBiaya());
        this.transaksiRepo.save(transaksi);
    }

}
