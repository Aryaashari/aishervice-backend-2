package tubespbo.aisherviceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tubespbo.aisherviceapp.entity.Inventaris;
import tubespbo.aisherviceapp.model.InventarisChangeStockRequest;
import tubespbo.aisherviceapp.model.InventarisCreateRequest;
import tubespbo.aisherviceapp.repository.InventarisRepository;

@Service
public class InventarisService{
    
    @Autowired
    private InventarisRepository inventarisRepo;

    @Transactional
    public List<Inventaris> getAll() {
        return this.inventarisRepo.findAll();
    }

    @Transactional
    public void createInventaris(InventarisCreateRequest request) {
        Inventaris objInventaris = new Inventaris();
        objInventaris.setSukuCadang(request.getSuku_cadang());
        objInventaris.setStok(request.getStok());
        objInventaris.setHargaSatuan(request.getHarga_satuan());

        this.inventarisRepo.save(objInventaris);
    }

    @Transactional
    public void changeStock(InventarisChangeStockRequest request) {
        Inventaris inventaris = this.inventarisRepo.findById(request.getId()).orElse(null);
        inventaris.setStok(inventaris.getStok() + request.getStock());
        this.inventarisRepo.save(inventaris);
    }

    @Transactional
    public void deleteInventaris(Long id) {
        this.inventarisRepo.deleteById(id);
    }

}
