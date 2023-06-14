package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Transaksi;
import tubespbo.aisherviceapp.model.TransaksiCreateRequest;
import tubespbo.aisherviceapp.repository.TransaksiRepository;

@Service
public class TransaksiService{
    
    @Autowired
    private TransaksiRepository transaksiRepo;

    @Transactional
    public List<Transaksi> getAll() {
        return this.transaksiRepo.findAll();
    }

    @Transactional
    public void createTransaksi(TransaksiCreateRequest request) {
        Transaksi transaksi = new Transaksi();
        transaksi.setStatus(request.getStatus());
        transaksi.setTotal(request.getTotal());

        this.transaksiRepo.save(transaksi);
    }

    @Transactional
    public void updateLunas(Long id) {
        Transaksi transaksi = this.transaksiRepo.findById(id).orElse(null);
        transaksi.setStatus("lunas");
        this.transaksiRepo.save(transaksi);
    }

}